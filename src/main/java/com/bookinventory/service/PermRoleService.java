package com.bookinventory.service;

import java.util.List;
import com.bookinventory.model.PermRole;

public interface PermRoleService {
	/**
     * Retrieves a master list of all defined security roles and their 
     * associated permissions.
     * @return List of PermRole entities representing the system's security matrix.
     */
    List<PermRole> getAllRoles();
}