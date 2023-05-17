/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.pilgrim.ejb;

import com.pilgrim.entities.CityMaster;
import com.pilgrim.entities.CommissionMaster;
import com.pilgrim.entities.GroupMaster;
import com.pilgrim.entities.MenuMaster;
import com.pilgrim.entities.PaymentMaster;
import com.pilgrim.entities.PilgrimMaster;
import com.pilgrim.entities.PilgrimTickets;
import com.pilgrim.entities.ProfitMaster;
import com.pilgrim.entities.StateMaster;
import com.pilgrim.entities.UserMaster;
import com.pilgrim.entities.UserrightsMaster;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dell
 */
@Stateless
public class AdminBean implements AdminBeanLocal {

    @PersistenceContext(name = "PilgrimWorld1PU")
    EntityManager em;

    @Override
    public Collection<CityMaster> getAllCitiesByState(Integer stateid) {
        StateMaster state = em.find(StateMaster.class, stateid);
        return state.getCityMasterCollection();
    }
    
    @Override
    public Collection<CityMaster> getAllCities() {
        return em.createNamedQuery("CityMaster.findAll").getResultList();
    }

    @Override
    public Collection<StateMaster> getAllStates() {
        return em.createNamedQuery("StateMaster.findAll").getResultList();
    }

    @Override
    public Collection<GroupMaster> getAllGroups() {
        return em.createNamedQuery("GroupMaster.findAll").getResultList();
    }

    @Override
    public void addCommission(CommissionMaster commission) {
        PilgrimMaster p = em.find(PilgrimMaster.class, commission.getPilgrim().getPilgrimId());
        Collection<CommissionMaster> commissionByPilgrim = p.getCommissionMasterCollection();

        PilgrimTickets t = em.find(PilgrimTickets.class, commission.getTicket().getTicketId());
        Collection<CommissionMaster> commissionOnTicket = t.getCommissionMasterCollection();

        commission.setPilgrim(p);
        commission.setTicket(t);

        commissionByPilgrim.add(commission);
        p.setCommissionMasterCollection(commissionByPilgrim);

        commissionOnTicket.add(commission);
        t.setCommissionMasterCollection(commissionOnTicket);

        em.persist(commission);
        em.merge(p);
    }

    @Override
    public void updateCommission(CommissionMaster commission) {
        PilgrimMaster p = em.find(PilgrimMaster.class, commission.getPilgrim().getPilgrimId());
        PilgrimTickets t = em.find(PilgrimTickets.class, commission.getTicket().getTicketId());
        commission.setPilgrim(p);
        commission.setTicket(t);
        em.merge(commission);

    }

    @Override
    public void removeCommission(Integer id) {
        CommissionMaster commission = em.find(CommissionMaster.class, id);

        PilgrimMaster p = em.find(PilgrimMaster.class, commission.getPilgrim().getPilgrimId());
        Collection<CommissionMaster> commissionByPilgrim = p.getCommissionMasterCollection();

        PilgrimTickets t = em.find(PilgrimTickets.class, commission.getTicket().getTicketId());
        Collection<CommissionMaster> commissionOnTicket = t.getCommissionMasterCollection();

        if (commissionByPilgrim.contains(commission) && commissionOnTicket.contains(commission)) {
            commissionByPilgrim.remove(commission);
            commissionOnTicket.remove(commission);
        }
        em.remove(commission);
    }

    @Override
    public Collection<CommissionMaster> getAllCommissions() {
        return em.createNamedQuery("CommissionMaster.findAll").getResultList();
    }
    
    @Override
    public Collection<CommissionMaster> getCommissionsByPilgrim(Integer pilgrimId) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, pilgrimId);
        return pilgrim.getCommissionMasterCollection();
    }

    @Override
    public void addMenu(MenuMaster menu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateMenu(MenuMaster menu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeMenu(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<MenuMaster> getAllMenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addProfit(ProfitMaster profit) {
        CommissionMaster c = em.find(CommissionMaster.class, profit.getCommission().getCommissionId());
        Collection<ProfitMaster> profitByCommission = c.getProfitMasterCollection();

        PaymentMaster pm = em.find(PaymentMaster.class, profit.getPayment().getPaymentId());
        Collection<ProfitMaster> profitByPayment = pm.getProfitMasterCollection();

        profit.setCommission(c);
        profit.setPayment(pm);

        profitByCommission.add(profit);
        c.setProfitMasterCollection(profitByCommission);

        profitByPayment.add(profit);
        pm.setProfitMasterCollection(profitByPayment);

        em.persist(profit);
        em.merge(c);
    }

    @Override
    public void updateProfit(ProfitMaster profit) {
        CommissionMaster c = em.find(CommissionMaster.class, profit.getCommission().getCommissionId());
        PaymentMaster pm = em.find(PaymentMaster.class, profit.getPayment().getPaymentId());
        profit.setCommission(c);
        profit.setPayment(pm);
        em.merge(profit);
    }

    @Override
    public void removeProfit(Integer id) {
        ProfitMaster profit = em.find(ProfitMaster.class, id);

        CommissionMaster c = em.find(CommissionMaster.class, profit.getCommission().getCommissionId());
        Collection<ProfitMaster> profitByCommission = c.getProfitMasterCollection();

        PaymentMaster pm = em.find(PaymentMaster.class, profit.getPayment().getPaymentId());
        Collection<ProfitMaster> profitByPayment = pm.getProfitMasterCollection();

        if (profitByCommission.contains(profit) && profitByPayment.contains(profit)) {
            profitByCommission.remove(profit);
            profitByPayment.remove(profit);
        }
        em.remove(profit);
    }

    @Override
    public Collection<ProfitMaster> getAllProfits() {
        return em.createNamedQuery("ProfitMaster.findAll").getResultList();
    }

    @Override
    public void addUserrights(UserrightsMaster userrights) {
        GroupMaster group = em.find(GroupMaster.class, userrights.getGroup().getGroupId());
        Collection<UserrightsMaster> userrightsByGroup = group.getUserrightsMasterCollection();

        MenuMaster menu = em.find(MenuMaster.class, userrights.getMenu().getMenuId());
        Collection<UserrightsMaster> userrightsByMenu = menu.getUserrightsMasterCollection();

        userrights.setGroup(group);
        userrights.setMenu(menu);

        userrightsByGroup.add(userrights);
        userrightsByMenu.add(userrights);
        menu.setUserrightsMasterCollection(userrightsByMenu);
        group.setUserrightsMasterCollection(userrightsByGroup);

        em.persist(userrights);
        em.merge(userrights);
    }

    @Override
    public void updateUserrights(UserrightsMaster userrights) {
        GroupMaster group = em.find(GroupMaster.class, userrights.getGroup().getGroupId());
        MenuMaster menu = em.find(MenuMaster.class, userrights.getMenu().getMenuId());
        userrights.setGroup(group);
        userrights.setMenu(menu);
        em.merge(userrights);
    }

    @Override
    public void removeUserrights(Integer id) {
        UserrightsMaster userrights = em.find(UserrightsMaster.class, id);
        GroupMaster group = em.find(GroupMaster.class, userrights.getGroup().getGroupId());
        Collection<UserrightsMaster> userrightsByGroup = group.getUserrightsMasterCollection();

        MenuMaster menu = em.find(MenuMaster.class, userrights.getMenu().getMenuId());
        Collection<UserrightsMaster> userrightsByMenu = menu.getUserrightsMasterCollection();

        if (userrightsByGroup.contains(userrights) && userrightsByMenu.contains(userrights)) {
            userrightsByGroup.remove(userrights);
            userrightsByMenu.remove(userrights);
        }
        em.remove(userrights);
    }

    @Override
    public Collection<UserrightsMaster> getAllUserrights() {
        return em.createNamedQuery("UserrightsMaster.findAll").getResultList();
    }

    @Override
    public void addUser(UserMaster user) {
        GroupMaster g = em.find(GroupMaster.class, user.getGroup().getGroupId());
        StateMaster s = em.find(StateMaster.class, user.getState().getStateId());
        CityMaster c = em.find(CityMaster.class, user.getCity().getCityId());

        user.setGroup(g);
        user.setState(s);
        user.setCity(c);
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
        
        Collection<UserMaster> userCollection = g.getUserMasterCollection();
        userCollection.add(user);
        g.setUserMasterCollection(userCollection);

        userCollection = s.getUserMasterCollection();
        userCollection.add(user);
        s.setUserMasterCollection(userCollection);

        userCollection = c.getUserMasterCollection();
        userCollection.add(user);
        c.setUserMasterCollection(userCollection);
        
        em.persist(user);
        em.merge(user);
    }

    @Override
    public void updateUser(UserMaster user) {
        GroupMaster g = em.find(GroupMaster.class, user.getGroup().getGroupId());
        StateMaster s = em.find(StateMaster.class, user.getState().getStateId());
        CityMaster c = em.find(CityMaster.class, user.getCity().getCityId());
        user.setGroup(g);
        user.setState(s);
        user.setCity(c);
        em.merge(user);
    }

    @Override
    public void removeUser(Integer id) {
        UserMaster user = em.find(UserMaster.class, id);
        
        GroupMaster g = em.find(GroupMaster.class, user.getGroup().getGroupId());
        Collection<UserMaster> usersByGroup = g.getUserMasterCollection();

        StateMaster s = em.find(StateMaster.class, user.getState().getStateId());
        Collection<UserMaster> usersByState = s.getUserMasterCollection();

        CityMaster c = em.find(CityMaster.class, user.getCity().getCityId());
        Collection<UserMaster> usersByCity = c.getUserMasterCollection();
        
        if(usersByCity.contains(user) && usersByGroup.contains(user) && usersByState.contains(user)) {
            usersByCity.remove(user);
            usersByGroup.remove(user);
            usersByState.remove(user);
        }
        em.remove(user);
    }
    
    @Override
    public UserMaster getUser(Integer id) {
        return em.find(UserMaster.class, id);
    }
    
    @Override
    public Collection<UserMaster> getAllUser() {
        return em.createNamedQuery("UserMaster.findAll").getResultList();
    }

    @Override
    public UserMaster getUserByUsername(String username) {
        return (UserMaster) em.createNamedQuery("UserMaster.findByUsername").setParameter("username", username).getResultList().iterator().next();
    }

    @Override
    public Collection<UserMaster> getUsersByGroup(Integer groupId) {
        GroupMaster group = em.find(GroupMaster.class, groupId);
        return group.getUserMasterCollection();
    }
}
