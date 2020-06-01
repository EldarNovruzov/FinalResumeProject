/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.impl;

import com.company.entity.Reference;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface ReferenceRepositoryCustom {
    public List<Reference> getAllReferenceByUserId(int id);

    public boolean insertReference(Reference r);

    public boolean updateReference(Reference r);

    public boolean removeReference(int id);

    public boolean removeReferencebyUserId(int id);
}
