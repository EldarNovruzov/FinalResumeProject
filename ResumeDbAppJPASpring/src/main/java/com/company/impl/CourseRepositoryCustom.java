/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.Course;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface CourseRepositoryCustom {
    public List<Course> getallCoursebyUserId(int userId);
    public boolean removeCoursebyUserId(int id);
}
