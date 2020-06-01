/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.ExtraCurricularActivities;
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
@Repository("extraCurricular1")
public class ExtraCurricularRepositoryCustomImpl extends AbstractDAO implements ExtraCurricularRepositoryCustom{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public List<ExtraCurricularActivities> getallExtraCurricularActivitiesbyUserId(int userId) {
        Query query = em.createQuery("select exc from ExtraCurricularActivities exc where exc.userId.id=:usid ");
        query.setParameter("usid",userId);
        return query.getResultList();
    }

    @Override
    public boolean removeExtraCurricularbyUserId(int id) {
        Query q= em.createQuery("delete from ExtraCurricularActivities eee where eee.userId.id=:aaa");
        q.setParameter("aaa", id);
        q.executeUpdate();
        return true;
    }

}
