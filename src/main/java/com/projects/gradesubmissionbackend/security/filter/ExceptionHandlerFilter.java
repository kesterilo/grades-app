package com.projects.gradesubmissionbackend.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.projects.gradesubmissionbackend.exceptions.EntityNotFoundException;


public class ExceptionHandlerFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			filterChain.doFilter(request, response);
		} catch (EntityNotFoundException e) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("Username doesn't exist");
			response.getWriter().flush();
		} catch (JWTCreationException e) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.getWriter().write("JWT NOT VALID");
			response.getWriter().flush();
		}
		catch (RuntimeException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("Something is wrong with your Request");
			response.getWriter().flush();
		}
	}
	
}
