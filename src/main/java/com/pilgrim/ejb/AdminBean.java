/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.pilgrim.ejb;

import com.pilgrim.entities.CityMaster;
import com.pilgrim.entities.StateMaster;
import java.util.Collection;
import javax.ejb.Stateless;

/**
 *
 * @author Dell
 */
@Stateless
public class AdminBean implements AdminBeanLocal {

    @Override
    public Collection<CityMaster> getAllCitiesByState(StateMaster stateid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
