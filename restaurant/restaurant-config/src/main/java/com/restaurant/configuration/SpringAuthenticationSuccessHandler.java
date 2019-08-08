package com.restaurant.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SpringAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
			
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_OK);
		List<String> roles = new ArrayList<>();
		
		for (GrantedAuthority auth : authentication.getAuthorities()) {
			if("Admin".equals(auth.getAuthority())){
				redirectStrategy.sendRedirect(request,response,"/sys-admin");
			}
		}
		
		/*roles.add("Administration");roles.add("Administrator");roles.add("Admin");
		for (GrantedAuthority auth : authentication.getAuthorities()) {
			
			logger.info("## Current Logged in user role is : " + auth.getAuthority());
			System.out.println("## Current Logged in user role is : " + auth.getAuthority());
			
			if ("Sys_Admin".equals(auth.getAuthority())){
				redirectStrategy.sendRedirect(request,response,"/sys-admin");
			}else{
				redirectStrategy.sendRedirect(request,response,"/restaurant-profile");
			}
				
			
			if ("Project Manager".equals(auth.getAuthority()))
				redirectStrategy.sendRedirect(request,response,"/addprogram");
			
			if(roles.contains(auth.getAuthority()))	
				redirectStrategy.sendRedirect(request,response,"/organization");
			
			if("Fund Manager".contains(auth.getAuthority()))	
				redirectStrategy.sendRedirect(request,response,"/funddonor");
			
			if("Head - Fundraising".contains(auth.getAuthority()))	
				redirectStrategy.sendRedirect(request,response,"/funddonor");
			
		}*/
	}
}