package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.SecurityUser;
import com.example.demo.domain.LoginDto;
import com.example.demo.domain.TokenDto;
import com.example.demo.domain.UserDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.TokenProvider;

@RestController
@RequestMapping("/api")
public class JwtTestController {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@GetMapping("/login")
	public ResponseEntity<TokenDto> login(LoginDto params, HttpServletRequest request, HttpServletResponse response){
		
		  String token = null; 
		  UserDto loginUser = repository.findUser(params);
		  if(loginUser == null) { return null; }
		  else {
			  System.out.println("JwtTestController_유저DB정보조회:" + loginUser);
			  token = tokenProvider.createToken(loginUser); 
			  System.out.println("JwtTestController_생성토큰값: " + token); 
			  
			  UserDetails userDetails = new SecurityUser(loginUser);
			  
			  UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
              usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
              SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
              
			  System.out.println("JwtTestController_authentication객체: " + SecurityContextHolder.getContext().getAuthentication());

			  // response헤더에 토큰셋팅
			  response.setHeader("authorization", token);	
		  }
		  
//		  return ResponseEntity.ok((String)tokenProvider.getUsernameFromToken(token));
		  return new ResponseEntity<>(new TokenDto(token), new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/call")
	//@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<Authentication> call(LoginDto params, HttpServletRequest request, HttpServletResponse response){	
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("call_authentication객체: " + authentication.getName());
		return ResponseEntity.ok(authentication);

	}
}
