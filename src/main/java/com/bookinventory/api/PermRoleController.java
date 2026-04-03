package com.bookinventory.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookinventory.model.PermRole;
import com.bookinventory.service.PermRoleService;

@RestController
public class PermRoleController {

    @Autowired
    private PermRoleService permRoleService;

    /**
     * Retrieves a master list of all security roles and associated permissions.
     * @return List of PermRole entities representing the system's access levels.
     */
    @GetMapping("/permrole")
    public List<PermRole> getAllRoles() {
        return permRoleService.getAllRoles();
    }
}