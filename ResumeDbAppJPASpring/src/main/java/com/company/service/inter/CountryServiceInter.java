/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.inter;

import com.company.entity.Country;

import java.util.List;

/**
 *
 * @author Acer
 */
public interface CountryServiceInter {
     public List<Country> getallCountry();
     public List<Country> getallCountrybyId(int id);
     public boolean removeCountrybyUserId(int id);
}
