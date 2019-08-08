package com.restaurant.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.restaurant.module.Credential;
import com.restaurant.module.Role;
import com.restaurant.module.repository.CredentialRepository;

@Service
public class SpringUserDetailsService implements UserDetailsService  {

	@Autowired
	CredentialRepository credentialRepository;
	
	public UserDetails loadUserByEmailOrUsername(String email,String userName) throws UsernameNotFoundException {
		return null;
	}
	
	private List<SimpleGrantedAuthority> getAuthority(Credential credential) {
		List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<SimpleGrantedAuthority>();
			SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(credential.getUser().getRole().getName());
	        grantedAuthorities.add(grantedAuthority);
		
		return grantedAuthorities;
	}

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		Credential credential = credentialRepository.findByUserName(arg0);
		if(credential == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(credential.getUserName(), credential.getPassword(), getAuthority(credential));
	}
}
