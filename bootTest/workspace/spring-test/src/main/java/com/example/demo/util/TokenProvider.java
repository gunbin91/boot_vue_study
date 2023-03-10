package com.example.demo.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.example.demo.domain.UserDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class TokenProvider implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private final String securityKey = Base64.getEncoder().encodeToString("test_secret_key".getBytes()); // TODO 민감정보는 따로 분리하는 것이 좋다
    private String DEFAULT_SECRET;
	
	private final Long tokenValidityInMilliseconds = 1000 * 60L * 60L * 1L; // 유효시간 1시간
	private static final String AUTHORITIES_KEY = "auth";
	
	public TokenProvider() {
	}
	
	// 토큰 반환
	public String createToken(UserDto user) {
		long now = (new Date()).getTime();
		Date validity = new Date(now + this.tokenValidityInMilliseconds);
		
		return Jwts.builder()
				.setSubject(user.getUsername())
				.setHeader(createHeader())
				.setClaims(createClaims(user)) // 클레임, 토큰에 포함될 정보
				.signWith(SignatureAlgorithm.HS256, securityKey)
				.setExpiration(validity)
				.compact();
	}
	
	private Map<String, Object> createHeader() {
	    Map<String, Object> header = new HashMap<>();
	    header.put("typ", "JWT");
	    header.put("alg", "HS256"); // 해시 256 사용하여 암호화
	    header.put("regDate", System.currentTimeMillis());
	    return header;
	}
	
	/**
	 * 클레임(Claim)을 생성한다.
	 *
	 * @param member 토큰을 생성하기 위한 계정 정보를 담은 객체
	 * @return Map<String, Object> 클레임(Claim)
	 */
	private Map<String, Object> createClaims(UserDto user) {
	  Map<String, Object> claims = new HashMap<>();
	  claims.put("username", user.getUsername()); // username
	  claims.put("roles", "USER"); // 인가정보
	  return claims;
	}
	
		/**
	   * Token 에서 Claim 을 가져온다.
	   *
	   * @param token JWT 토큰
	   * @return Claims 클레임
	   */
	  private Claims getClaims(String token) {
	    return Jwts
	    		.parser()
	    		.setSigningKey(securityKey)
	    		.parseClaimsJws(token).getBody();
	  }
	  
	  /**
	   * 토큰으로 부터 username 을 가져온다.
	   *
	   * @param token JWT 토큰
	   * @return String Member 의 username
	   */
	  public String getUsernameFromToken(String token) {
	    return (String) getClaims(token).get("username");
	  }
	  
	  public String getRolesFromToken(String token) {
		    return (String) getClaims(token).get("roles");
		  }
	
	  /**
	   * 토큰으로 부터 인가 정보를 가져온다.
	   *
	   * @param token JWT 토큰
	   * @return Set<MemberRole> role 정보를 가지고 있는 Set
	   */
		/*
		 * public Set<MemberRole> getMemberRoleSetFromToken(String token) { return
		 * (Set<MemberRole>) getClaims(token).get("roles"); }
		 */
	  
	  public Authentication getAuthentication(String token) {
	      Claims claims = getClaims(token);
	      System.out.println("claims.getSubject()=" + claims.getSubject());

	      Collection<? extends GrantedAuthority> authorities =
	         Arrays.stream(claims.get("username").toString().split(","))
	            .map(SimpleGrantedAuthority::new)
	            .collect(Collectors.toList());

	      org.springframework.security.core.userdetails.User principal 
	      = new org.springframework.security.core.userdetails.User((String)claims.get("username"), "passs", authorities);
	      
	      
	      return new UsernamePasswordAuthenticationToken(principal, token, authorities);
	   }
	  
	  public boolean validateToken(String token) {
		  try {
			  System.out.println("TokenProvider_토큰밸리데이션호출");
			  Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token);
			  return true;
		  }catch(SecurityException | MalformedJwtException e) {
			  System.out.println("잘못된 JWT 서명입니다.");
		  }catch(ExpiredJwtException e) {
			  System.out.println("만료된 JWT 토큰입니다.");
		  }catch(UnsupportedJwtException e) {
			  System.out.println("지원되지 않는 JWT토큰입니다.");
		  }catch(IllegalArgumentException e) {
			  System.out.println("JWT 토큰이 잘못되었습니다.");
		  }
		  return false;
	  }
}
