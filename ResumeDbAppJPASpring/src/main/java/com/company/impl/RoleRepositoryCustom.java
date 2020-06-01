/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.Role;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface RoleRepositoryCustom {
    public List<Role> getAllRoles();
    public List<Role> getAllRolebyId(int roleId);
    public boolean updateRole(Role r);
    public boolean removeRole(int roleId);
    public List<Role> getRolebyName(String roleName);
    public boolean insertRole(Role role);
}
