package com.example.demo.configuration.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

// 유효한 자격증명을 제공하지 않고 접근하려고 할때 401 리턴
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		System.out.println("JwtAuthenticationEntryPoint: 401리턴");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
	}

	
}
