/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.pilgrim.ejb;

import com.pilgrim.entities.CityMaster;
import com.pilgrim.entities.CommissionMaster;
import com.pilgrim.entities.GroupMaster;
import com.pilgrim.entities.MenuMaster;
import com.pilgrim.entities.ProfitMaster;
import com.pilgrim.entities.StateMaster;
import com.pilgrim.entities.UserMaster;
import com.pilgrim.entities.UserrightsMaster;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Dell
 */
@Local
public interface AdminBeanLocal {
    
    //get cities by state
    Collection<CityMaster> getAllCitiesByState(Integer stateid);
    
    Collection<CityMaster> getAllCities();
    
    Collection<StateMaster> getAllStates();
    
    Collection<GroupMaster> getAllGroups();
    
    void addCommission(CommissionMaster commission);
    void updateCommission(CommissionMaster commission);
    void removeCommission(Integer commission);
    
    Collection<CommissionMaster> getAllCommissions();
    Collection<CommissionMaster> getCommissionsByPilgrim(Integer pilgrimId);
    
    void addMenu(MenuMaster menu);
    void updateMenu(MenuMaster menu);
    void removeMenu(Integer menu);
    
    Collection<MenuMaster> getAllMenu();
    
    void addProfit(ProfitMaster profit);
    void updateProfit(ProfitMaster profit);
    void removeProfit(Integer profit);
    
    Collection<ProfitMaster> getAllProfits();
    
    void addUserrights(UserrightsMaster userrights);
    void updateUserrights(UserrightsMaster userrights);
    void removeUserrights(Integer userrights);

    Collection<UserrightsMaster> getAllUserrights();
    
    void addUser(UserMaster user);
    void updateUser(UserMaster user);
    void removeUser(Integer user);

    Collection<UserMaster> getAllUser();
    UserMaster getUserByUsername(String username);
    Collection<UserMaster> getUsersByGroup(Integer groupId);
}
