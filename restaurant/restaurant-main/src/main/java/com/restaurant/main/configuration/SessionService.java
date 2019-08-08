package com.restaurant.main.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.restaurant.module.Credential;
import com.restaurant.module.repository.CredentialRepository;

@Component
public class SessionService {
	
	@Autowired
	CredentialRepository credentialRepository;

	public Credential getCurrentUser(){
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Credential credential = credentialRepository.findByUserName(auth.getName());
	    	return credential;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
}

