package com.bookinventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookinventory.dto.UserResponseDTO;
import com.bookinventory.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT new com.bookinventory.dto.UserResponseDTO(u.firstName, u.lastName, u.userName, u.phoneNumber, r.roleName) " +
	           "FROM User u JOIN u.roleNumber r " +
	           "WHERE u.userId = :userId")
	Optional<UserResponseDTO> getUserProfileById(Integer userId);
	
}
