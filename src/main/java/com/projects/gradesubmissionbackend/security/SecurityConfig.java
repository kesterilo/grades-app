package com.projects.gradesubmissionbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.projects.gradesubmissionbackend.security.filter.AuthenticationFilter;
import com.projects.gradesubmissionbackend.security.filter.ExceptionHandlerFilter;
import com.projects.gradesubmissionbackend.security.filter.JWTAuthorizationFilter;
import com.projects.gradesubmissionbackend.security.manager.CustomAuthenticationManager;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
	
	CustomAuthenticationManager customAuthenticationManager;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
		authenticationFilter.setFilterProcessesUrl("/authenticate");
		http
			.headers().frameOptions().disable()
			.and()
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/h2/**").permitAll()
			.antMatchers(HttpMethod.POST, SecurityConstants.REGISTER_PATH).permitAll()
			.anyRequest().authenticated()
			.and()
			.addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
			.addFilter(authenticationFilter)
			.addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
			.sessionManagement().sessionCreationPolicy(
					SessionCreationPolicy.STATELESS);
		return http.build();
		
	}
	
}
