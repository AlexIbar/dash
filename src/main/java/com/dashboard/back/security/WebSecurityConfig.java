package com.dashboard.back.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig {
	
	private final UserDetailsService userDetailService;
	private final JWTAuthorizationFilter jwtAutorizationFilter;
	
	
	
	public WebSecurityConfig(UserDetailsService userDetailService, JWTAuthorizationFilter jwtAutorizationFilter) {
		super();
		this.userDetailService = userDetailService;
		this.jwtAutorizationFilter = jwtAutorizationFilter;
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
		
		JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
		jwtAuthenticationFilter.setAuthenticationManager(authManager);
		jwtAuthenticationFilter.setFilterProcessesUrl("/login");
		return http
					.csrf().disable()
					.authorizeRequests()
					.anyRequest()
					.authenticated()
					.and()
					.httpBasic()
					.and()
					.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
					.and()
					.addFilter(jwtAuthenticationFilter)
					.addFilterBefore(jwtAutorizationFilter, UsernamePasswordAuthenticationFilter.class)
					.build();
	}
	
	@Bean
	AuthenticationManager authManager(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailService)
				.passwordEncoder(passwordEncoder())
				.and()
				.build();
	} 
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
