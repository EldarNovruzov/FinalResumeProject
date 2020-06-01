/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.UserRole;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface UserRoleRepositoryCustom {
    public List<UserRole> getAllUserRole(String name, String surname);
    public UserRole findUserRolebyEmailandPassword(String email, String password);
    public UserRole findUserRolebyId(int userRoleid);
    public boolean addUserRole(UserRole ur);
    public UserRole findUserRolebyEmail(String userRoleEmail);
    public boolean updateUserRole(UserRole ur);
    public boolean removeUserRole(int userRoleId);
}
