/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.User;
import com.company.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Acer
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>, UserRoleRepositoryCustom{
    @Query(value="select ur from UserRole ur where ur.email=:email")
    UserRole findByEmail(@Param("email") String email);
    
}
