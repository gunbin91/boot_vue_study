package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.example.demo.configuration.exception.JwtAccessDenidHandler;
import com.example.demo.configuration.exception.JwtAuthenticationEntryPoint;
import com.example.demo.util.TokenProvider;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)	//	@PreAuthorize어노테이션을 메소드 단위로 추가하기 위해 사용
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private TokenProvider tokenProvider;
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	private JwtAccessDenidHandler jwtAccessDenidHandler;
	
	 public void configure(WebSecurity web,
			 TokenProvider tokenProvider,
			 JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
			 JwtAccessDenidHandler jwtAccessDenidHandler) {
		 
		 this.tokenProvider = tokenProvider;
		 this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
		 this.jwtAccessDenidHandler = jwtAccessDenidHandler;
		 
		 web.ignoring()
		 .antMatchers("/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html", "/webjars/**", "/swagger/**")
		 .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
	 }
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable()	// 비인증시 로그인화면으로 이동되지 않도록 ..
			.csrf().disable()
			.exceptionHandling()
			.authenticationEntryPoint(jwtAuthenticationEntryPoint)
			.accessDeniedHandler(jwtAccessDenidHandler)
			
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)	//	세션을 이용한 토큰사용X
			
			.and()
			.authorizeHttpRequests()
			.antMatchers(HttpMethod.OPTIONS).permitAll()
			.antMatchers("/**").permitAll()
			.antMatchers("/api/**").authenticated()
			.anyRequest().authenticated()
		
			.and()
			.apply(new JwtSecurityConfig(tokenProvider));
	}
	
}
