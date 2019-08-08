package com.restaurant.module.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.module.Credential;

public interface CredentialRepository extends JpaRepository<Credential, Long> {
	Credential findByUserName(String arg0);

}
