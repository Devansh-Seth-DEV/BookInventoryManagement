package com.bookinventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookinventory.model.PermRole;
import com.bookinventory.repository.PermRoleRepository;

@Service
public class PermRoleServiceImpl implements PermRoleService {

    @Autowired
    private PermRoleRepository permRoleRepository;

    @Override
    public List<PermRole> getAllRoles() {
        return permRoleRepository.findAll();
    }
}