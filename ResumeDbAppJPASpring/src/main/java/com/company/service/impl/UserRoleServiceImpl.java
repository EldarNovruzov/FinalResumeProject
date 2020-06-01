/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import com.company.entity.UserRole;
import com.company.impl.UserRoleRepositoryCustom;
import com.company.service.inter.UserRoleServiceInter;
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
public class UserRoleServiceImpl implements UserRoleServiceInter{
    
    @PersistenceContext
    EntityManager em;
    
    @Autowired
    @Qualifier("userRoleDao1")
    private UserRoleRepositoryCustom uRoleRepoCus;

    @Override
    public List<UserRole> getAllUserRole(String name, String surname) {
        return uRoleRepoCus.getAllUserRole(name, surname);
    }

    @Override
    public UserRole findUserRolebyEmailandPassword(String email, String password) {
        return uRoleRepoCus.findUserRolebyEmailandPassword(email, password);
    }

    @Override
    public UserRole findUserRolebyId(int userRoleid) {
        return uRoleRepoCus.findUserRolebyId(userRoleid);
    }

    @Override
    public boolean addUserRole(UserRole ur) {
        return uRoleRepoCus.addUserRole(ur);
    }

    @Override
    public UserRole findUserRolebyEmail(String userRoleEmail) {
        return uRoleRepoCus.findUserRolebyEmail(userRoleEmail);
    }

    @Override
    public boolean updateUserRole(UserRole ur) {
        return uRoleRepoCus.updateUserRole(ur);
    }

    @Override
    public boolean removeUserRole(int userRoleId) {
        return uRoleRepoCus.removeUserRole(userRoleId);
    }
    
}
