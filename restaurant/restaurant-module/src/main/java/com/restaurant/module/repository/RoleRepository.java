package com.restaurant.module.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.module.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String string);

}
