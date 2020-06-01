/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.UserLanguage;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface UserLanguageRepositoryCustom {
    public List<UserLanguage> getAllLanguageByUserId(int id);

    public boolean insertUserLanguage(UserLanguage ul);

    public boolean updateUserLanguage(UserLanguage ul);

    public boolean removeUserLanguage(int id);
    public boolean removeUserLanguagebyUserId(int id);
}
