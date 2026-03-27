package com.bookinventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookinventory.model.User;

public interface UserRespository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String userName);
}
