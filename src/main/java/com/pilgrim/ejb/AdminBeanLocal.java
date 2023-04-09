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
    
    Collection<StateMaster> getAllState();
    
    Collection<GroupMaster> getAllGroups();
    
    void addCommission(CommissionMaster commission, Integer pilgrimID, Integer ticketID);
    void updateCommission(CommissionMaster commission);
    void removeCommission(CommissionMaster commission);
    
    Collection<CommissionMaster> getAllCommissions();
    
    void addMenu(MenuMaster menu);
    void updateMenu(MenuMaster menu);
    void removeMenu(MenuMaster menu);
    
    Collection<MenuMaster> getAllMenu();
    
    void addProfit(ProfitMaster profit, Integer commissionId, Integer paymentId);
    void updateProfit(ProfitMaster profit, Integer commissionId, Integer paymentId);
    void removeProfit(ProfitMaster profit);
    
    Collection<ProfitMaster> getAllProfits();
    
    void addUserrights(UserrightsMaster userrights, Integer groupId, Integer menuId);
    void updateUserrights(UserrightsMaster userrights, Integer groupId, Integer menuId);
    void removeUserrights(UserrightsMaster userrights);

    Collection<UserrightsMaster> getAllUserrights();
    
    Object addUser(UserMaster user, Integer groupId, Integer stateId, Integer cityId);
    Object updateUser(UserMaster user, Integer groupId, Integer stateId, Integer cityId);
    void removeUser(UserMaster user);

    Collection<UserMaster> getAllUser();
}
