package com.example.demo.Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.example.demo.util.TokenProvider;

public class JwtFilter extends GenericFilterBean{
	
	public static final String AUTHORIZATION_HEADER = "authorization";
	
	private TokenProvider tokenProvider;
	
	private final RequestMatcher apiRequests = new AntPathRequestMatcher("/api/**");
	
	public JwtFilter(TokenProvider tokenProvider) {
		this.tokenProvider = tokenProvider;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("JwtFilter_필터호출");
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		String jwt = resolveToken(httpServletRequest);
		String requestURI = httpServletRequest.getRequestURI();
		
		if(StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
			String username = tokenProvider.getUsernameFromToken(jwt);
//			System.out.println("JwtFilter_토큰매칭username: " + username);
		}else {
//			System.out.println("JwtFilter_헤더에 유효한 jwt 토큰이 없습니다.");
		}
		chain.doFilter(request, response);
	}
	
	private String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
		System.out.println("JwtFilter_헤더토큰값: " + bearerToken);
		return bearerToken;
	}
}
