package com.projects.gradesubmissionbackend.security.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.projects.gradesubmissionbackend.entity.User;
import com.projects.gradesubmissionbackend.service.UserService;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		User user = userService.getUser(authentication.getName());
		if (!bCryptPasswordEncoder.matches(authentication.getCredentials().toString(), user.getPassword())) {
			throw new BadCredentialsException("You provided an incorrect Password.");
		}
		return new UsernamePasswordAuthenticationToken(authentication.getName(), user.getPassword());
	}

}
