/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.EmploymentHistory;

import java.util.List;

/**
 *
 * @author Acer
 */
public interface EmploymentHistoryRepositoryCustom {
    public List<EmploymentHistory> getallEmploymentHistorybyuserId(int userId);
    public boolean removeEmploymentHistorybyUserId(int id);
}
