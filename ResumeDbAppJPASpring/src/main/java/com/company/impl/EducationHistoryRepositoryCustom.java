/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.EducationHistory;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface EducationHistoryRepositoryCustom {
    public List<EducationHistory> getallEducationHistorybyUserId(int userId);
    public boolean removeEducationHistorybyUserId(int id);
}
