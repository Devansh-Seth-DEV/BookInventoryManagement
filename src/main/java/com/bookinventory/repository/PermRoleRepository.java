package com.bookinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookinventory.model.PermRole;

public interface PermRoleRepository extends JpaRepository<PermRole, Integer> {
}