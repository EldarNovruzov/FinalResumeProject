/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import com.company.entity.Course;
import com.company.impl.CourseRepositoryCustom;
import com.company.service.inter.CourseServiceInter;
import java.util.List;
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
public class CourseServiceImpl implements CourseServiceInter{
    
    @Autowired
    @Qualifier("course1")
    private CourseRepositoryCustom repositoryCustom;

    @Override
    public List<Course> getallCoursebyUserId(int userId) {
       return repositoryCustom.getallCoursebyUserId(userId);
    }

    @Override
    public boolean removeCoursebyUserId(int id) {
        return repositoryCustom.removeCoursebyUserId(id);
    }

}
