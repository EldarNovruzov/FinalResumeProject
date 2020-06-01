/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.EducationHistory;
import com.company.inter.AbstractDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Acer
 */
@Repository("educationHistory1")
public class EducationHistoryRepositoryCustomImpl extends AbstractDAO implements EducationHistoryRepositoryCustom{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public List<EducationHistory> getallEducationHistorybyUserId(int userId) {
        Query query = em.createQuery("select e from EducationHistory e where e.userId.id=:usid ");
        query.setParameter("usid",userId);
        return query.getResultList();
    }

    @Override
    public boolean removeEducationHistorybyUserId(int id) {
        Query q=em.createQuery("delete from EducationHistory eh where eh.userId.id=:sdi");
        q.setParameter("sdi", id);
        q.executeUpdate();
        return true;
    }

}
