/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.User;

import java.util.List;

/**
 *
 * @author Acer
 */
public interface UserRepositoryCustom {
    public List<User> getAll(String name, String surname, Integer nationalityIdbyRequest);
    public User findbyEmailandPassword(String email, String password);
    public User getbyID(int userId);
    public boolean addUser(User u);
    public User findByEmail(String email);
    public boolean updateUser(User u);
    public boolean removeUser(int id);
    public List<User> getUserbyUserRoleId(Integer userRoleId);
    public List<User> getAllWithoutParameter();
    
}
