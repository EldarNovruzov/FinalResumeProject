/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.SocialLink;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Acer
 */
public interface SocialLinkRepository extends JpaRepository<SocialLink, Integer>, SocialLinkRepositoryCustom{
    
}
