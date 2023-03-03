/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.pilgrim.ejb;

import com.pilgrim.entities.CityMaster;
import com.pilgrim.entities.StateMaster;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Dell
 */
@Local
public interface AdminBeanLocal {
    
    //get cities by state
    Collection<CityMaster> getAllCitiesByState(StateMaster stateid);
}
