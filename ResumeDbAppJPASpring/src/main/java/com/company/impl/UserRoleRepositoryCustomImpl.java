/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import com.company.entity.UserRole;
import com.company.inter.AbstractDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Acer
 */
@Repository("userRoleDao1")
@Transactional
public class UserRoleRepositoryCustomImpl extends AbstractDAO implements UserRoleRepositoryCustom{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public List<UserRole> getAllUserRole(String name, String surname) {
         String jpql = "select ur from UserRole ur where 1=1";

        if (name != null && !name.trim().isEmpty()) {
            jpql += " and ur.name=:name";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and ur.surname=:surname";
        }

        Query q = em.createQuery(jpql, UserRole.class);

        if (name != null && !name.trim().isEmpty()) {
            q.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            q.setParameter("surname", surname);
        }

        return q.getResultList();
    }

    @Override
    public UserRole findUserRolebyEmailandPassword(String email, String password) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserRole> q1 = cb.createQuery(UserRole.class);
        Root<UserRole> fr = q1.from(UserRole.class);

        CriteriaQuery<UserRole> cq = q1.where(cb.equal(fr.get("email"), email), cb.equal(fr.get("password"), password));

        Query query = em.createQuery(cq);

        List<UserRole> resultList = query.getResultList();
        if (resultList.size() == 1) {
            return resultList.get(0);
        }
        return null;
    }

    @Override
    public UserRole findUserRolebyId(int userRoleid) {
        UserRole u = em.find(UserRole.class, userRoleid);
        return u;
    }

    private static BCrypt.Hasher crypt = BCrypt.withDefaults();
    @Override
    public boolean addUserRole(UserRole ur) {
        char[] hashArray = ur.getPassword().toCharArray();
        String hashToString = crypt.hashToString(15, hashArray);
        ur.setPassword(hashToString);
        em.persist(ur);
        return true;
    }

    @Override
    public UserRole findUserRolebyEmail(String userRoleEmail) {
        Query query = em.createNamedQuery("UserRole.findByEmail", UserRole.class);

        query.setParameter("email", userRoleEmail);

        List<UserRole> resultList = query.getResultList();
        if (resultList.size() == 1) {
            return resultList.get(0);
        }
        return null;
    }

    @Override
    public boolean updateUserRole(UserRole ur) {
        em.merge(ur);
        return true;
    }

    @Override
    public boolean removeUserRole(int userRoleId) {
        User u = em.find(User.class, userRoleId);
        em.remove(u);
        return true;
    }
    
}
