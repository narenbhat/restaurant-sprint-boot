package com.restaurant.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.restaurant.module.Credential;
import com.restaurant.module.Role;
import com.restaurant.module.User;
import com.restaurant.module.repository.CredentialRepository;
import com.restaurant.module.repository.RoleRepository;
import com.restaurant.module.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantTest {

	@Autowired
	CredentialRepository credentialRepository;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	
	@Test
	public void test() {
		
		if(roleRepo.findByName("Admin") == null){
		
		Role role = new Role();
		role.setName("Admin");
		Role r = roleRepo.save(role);
		
		Credential cr = new Credential();
		String password = "123"; 
	    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
	    String encodedPassword = passwordEncoder.encode(password); 
	    
        User u = new User();
	    u.setRole(r);
	    u.setFirstName("Narendra");
	    u.setLastName("Bhatgavkar");
	    User user = userRepo.save(u);
	    
	    cr.setUserName("nbhatgavkar@gmail.com");
	    cr.setPassword(encodedPassword);
	    cr.setUser(user);
	    Credential credential = credentialRepository.save(cr);
	    
		}
	}
}
