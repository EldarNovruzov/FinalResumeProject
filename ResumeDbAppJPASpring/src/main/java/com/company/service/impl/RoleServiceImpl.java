/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import com.company.entity.Role;
import com.company.impl.RoleRepositoryCustom;
import com.company.service.inter.RoleServiceInter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Acer
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleServiceInter{
    @PersistenceContext
    EntityManager em;
    
    @Autowired
    @Qualifier("roleRepository1")
    private RoleRepositoryCustom roleRepoCustom;

    @Override
    public List<Role> getAllRoles() {
        return roleRepoCustom.getAllRoles();
    }

    @Override
    public List<Role> getAllRolebyId(int roleId) {
        return roleRepoCustom.getAllRolebyId(roleId);
    }

    @Override
    public boolean updateRole(Role r) {
        return roleRepoCustom.updateRole(r);
    }

    @Override
    public boolean removeRole(int roleId) {
        return roleRepoCustom.removeRole(roleId);
    }

    @Override
    public List<Role> getRolebyName(String roleName) {
        return roleRepoCustom.getRolebyName(roleName);
    }

    @Override
    public boolean insertRole(Role role) {
        return roleRepoCustom.insertRole(role);
    }
    
}
