/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.Role;
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
@Repository("roleRepository1")
@Transactional
public class RoleRepositoryCustomImpl extends AbstractDAO implements RoleRepositoryCustom{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Role> getAllRoles() {
       Query q= em.createQuery("select r from Role r ");
        return q.getResultList();
    }

    @Override
    public List<Role> getAllRolebyId(int roleId) {
        Query q = em.createQuery("select r from Role r where r.id=:roleId");
        return q.getResultList();
    }

    @Override
    public boolean updateRole(Role r) {
        em.merge(r);
        return true;
    }

    @Override
    public boolean removeRole(int roleId) {
        Role role = em.find(Role.class, roleId);
        em.remove(role);
        return true;
    }

    @Override
    public List<Role> getRolebyName(String roleName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Role> cbq = cb.createQuery(Role.class);
        Root<Role> from = cbq.from(Role.class);

        CriteriaQuery<Role> cqn = cbq.where(cb.equal(from.get("role_name"), roleName));

        Query query= em.createQuery(cqn);

        return query.getResultList();
    }

    @Override
    public boolean insertRole(Role role) {
        em.persist(role);
        return true;
    }
    
}
