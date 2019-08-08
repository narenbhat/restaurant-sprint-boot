package com.restaurant.module.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.module.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
