/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.Course;
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
@Repository("course1")
public class CourseRepositoryCustomImpl extends AbstractDAO implements CourseRepositoryCustom{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Course> getallCoursebyUserId(int userId) {
        Query query = em.createQuery("select c from Course c where c.userId.id=:usid ");
        query.setParameter("usid",userId);
        return query.getResultList();
    }

    @Override
    public boolean removeCoursebyUserId(int id) {
        Query q=em.createQuery("delete from Course c where c.userId.id=:sd");
        q.setParameter("sd", id);
        q.executeUpdate();
        return true;
    }

}
