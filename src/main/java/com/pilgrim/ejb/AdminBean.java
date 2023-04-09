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
import java.util.List;
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
    public Collection<StateMaster> getAllState() {
        return em.createNamedQuery("StateMaster.findAll").getResultList();
    }

    @Override
    public Collection<GroupMaster> getAllGroups() {
        return em.createNamedQuery("GroupMaster.findAll").getResultList();
    }

    @Override
    public void addCommission(CommissionMaster commission, Integer pilgrimID, Integer ticketID) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimID);
        Collection<CommissionMaster> commissionByPilgrim = p.getCommissionMasterCollection();

        PilgrimTickets t = em.find(PilgrimTickets.class, ticketID);
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
        CommissionMaster com = em.find(CommissionMaster.class, commission.getCommissionId());

    }

    @Override
    public void removeCommission(CommissionMaster commission) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<CommissionMaster> getAllCommissions() {
        return em.createNamedQuery("CommissionMaster.findAll").getResultList();
    }

    @Override
    public void addMenu(MenuMaster menu) {
        em.persist(menu);
    }

    @Override
    public void updateMenu(MenuMaster menu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeMenu(MenuMaster menu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<MenuMaster> getAllMenu() {
        return em.createNamedQuery("MenuMaster.findAll").getResultList();
    }

    @Override
    public void addProfit(ProfitMaster profit, Integer commissionId, Integer paymentId) {

        CommissionMaster c = em.find(CommissionMaster.class, commissionId);
        Collection<ProfitMaster> profitByCommission = c.getProfitMasterCollection();

        PaymentMaster pm = em.find(PaymentMaster.class, paymentId);
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
    public void updateProfit(ProfitMaster profit, Integer commissionId, Integer paymentId) {
        CommissionMaster c = em.find(CommissionMaster.class, commissionId);
        Collection<ProfitMaster> profitByCommission = c.getProfitMasterCollection();

        PaymentMaster pm = em.find(PaymentMaster.class, paymentId);
        Collection<ProfitMaster> profitByPayment = pm.getProfitMasterCollection();

        ProfitMaster p = em.find(ProfitMaster.class, profit.getProfitId());
        p.setCommission(c);
        p.setPayment(pm);
        p.setUpdatedDate(new Date());

        c.setProfitMasterCollection(profitByCommission);

        pm.setProfitMasterCollection(profitByPayment);

        em.merge(p);
    }

    @Override
    public void removeProfit(ProfitMaster profit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<ProfitMaster> getAllProfits() {
        return em.createNamedQuery("ProfitMaster.findAll").getResultList();
    }

    @Override
    public void addUserrights(UserrightsMaster userrights, Integer groupId, Integer menuId) {
        GroupMaster group = em.find(GroupMaster.class, groupId);
        Collection<UserrightsMaster> userrightsByGroup = group.getUserrightsMasterCollection();

        MenuMaster menu = em.find(MenuMaster.class, menuId);
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
    public void updateUserrights(UserrightsMaster userrights, Integer groupId, Integer menuId) {
        GroupMaster group = em.find(GroupMaster.class, groupId);
        Collection<UserrightsMaster> userrightsByGroup = group.getUserrightsMasterCollection();

        MenuMaster menu = em.find(MenuMaster.class, menuId);
        Collection<UserrightsMaster> userrightsByMenu = menu.getUserrightsMasterCollection();

        UserrightsMaster upUserright = em.find(UserrightsMaster.class, userrights.getUserrightsId());
        upUserright.setGroup(group);
        upUserright.setMenu(menu);

        menu.setUserrightsMasterCollection(userrightsByMenu);
        group.setUserrightsMasterCollection(userrightsByGroup);

        em.merge(upUserright);
    }

    @Override
    public void removeUserrights(UserrightsMaster userrights) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<UserrightsMaster> getAllUserrights() {
        return em.createNamedQuery("UserrightsMaster.findAll").getResultList();
    }

    @Override
    public Object addUser(UserMaster user, Integer groupId, Integer stateId, Integer cityId) {
        try {
            GroupMaster g = em.find(GroupMaster.class, groupId);
            StateMaster s = em.find(StateMaster.class, stateId);
            CityMaster c = em.find(CityMaster.class, cityId);

            user.setGroup(g);
            user.setState(s);
            user.setCity(c);

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
            return em.merge(user);
        } catch (Exception e) {
            return e;
        }
    }

    @Override
    public Object updateUser(UserMaster user, Integer groupId, Integer stateId, Integer cityId) {
        try {
            GroupMaster g = em.find(GroupMaster.class, groupId);
            StateMaster s = em.find(StateMaster.class, stateId);
            CityMaster c = em.find(CityMaster.class, cityId);

            UserMaster upUser = em.find(UserMaster.class, user.getUserId());
            upUser.setGroup(g);
            upUser.setState(s);
            upUser.setCity(c);

            Collection<UserMaster> userCollection = g.getUserMasterCollection();
            g.setUserMasterCollection(userCollection);

            userCollection = s.getUserMasterCollection();
            s.setUserMasterCollection(userCollection);

            userCollection = c.getUserMasterCollection();
            c.setUserMasterCollection(userCollection);

            return em.merge(upUser);
        } catch (Exception e) {
            return e;
        }

    }

    @Override
    public void removeUser(UserMaster user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<UserMaster> getAllUser() {
        return em.createNamedQuery("UserMaster.findAll").getResultList();
    }
}
