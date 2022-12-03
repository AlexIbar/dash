package com.dashboard.back.security;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {
	
	private final static String ACCESS_TOKEN_SECRET = "814b5860-2476-415f-9654-d2b95844de68";
	/*private String[] administrador = {
			"GET/cliente",
			"POST/cliente",
			"GET/cliente/search",
			"PUT/cliente",
			"DELETE/cliente"
	};
	private String[] cajero = {
			""
	};
	
	private String[] info = {
			""
	};*/
	
	//private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 34414242325253;
	
	public static String createToken(String nombre, String email) {
		//long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS*1_000;
		//Date expirationDate = new Date(System.currentTimeMillis()*expirationTime);
		
		Map<String, Object> extra = new HashMap<>();
		
		extra.put("nombre", nombre);
		
		return Jwts.builder()
				.setSubject(email)
				.addClaims(extra)
				.signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
				.compact();
		
	}
	public static UsernamePasswordAuthenticationToken getAuthentication(String token, String ruta) {
		try {
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
					.build()
					.parseClaimsJws(token)
					.getBody();
			String email = claims.getSubject();
			
			return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
		} catch (JwtException e) {
			return null;
		}
	}
	public boolean estaPermitido() {
		return true;
	}
}
