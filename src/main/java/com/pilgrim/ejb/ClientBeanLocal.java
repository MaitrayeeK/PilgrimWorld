/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.pilgrim.ejb;

import com.pilgrim.entities.AdvertisementMaster;
import com.pilgrim.entities.DiscountMaster;
import com.pilgrim.entities.PilgrimImages;
import com.pilgrim.entities.PilgrimMaster;
import com.pilgrim.entities.PilgrimRooms;
import com.pilgrim.entities.PilgrimTickets;
import com.pilgrim.entities.PilgrimTimeslots;
import com.pilgrim.entities.PilgrimTimeslotsDetails;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Dell
 */
@Local
public interface ClientBeanLocal {
    
    //operations for pilgrim_master
    public void addPilgrim(PilgrimMaster pilgrim, Integer userId, Integer stateId, Integer cityId);
    public void updatePilgrim(PilgrimMaster pilgrim, Integer userId, Integer stateId, Integer cityId);
    public void removePilgrim(Integer pilgrimId, Integer userId, Integer stateId, Integer cityId);
    
    Collection<PilgrimMaster> getPilgrims();
    Collection<PilgrimMaster> getPilgrimsByState(Integer stateId);
    Collection<PilgrimMaster> getPilgrimsByCity(Integer cityId);
    Collection<PilgrimMaster> getPilgrimsByStateCity(Integer StateId, Integer cityId);
    
    //operations for pilgrim_images
    public void addPilgrimImages(PilgrimImages pimages, Integer pilgrimId);
    public void updatePilgrimImages(PilgrimImages pimages, Integer pilgrimId);
    public void removePilgrimImages(Integer pilgrimImageId, Integer pilgrimId);
    
    Collection<PilgrimImages> getPilgrimImages(PilgrimMaster pilgrim);
    
    //operations for pilgrim_rooms
    public void addPilgrimRooms(PilgrimRooms prooms, Integer pilgrimId);
    public void updatePilgrimRooms(PilgrimRooms prooms, Integer pilgrimId);
    public void removePilgrimRooms(Integer pilgrimRoomId, Integer pilgrimId);
    
    Collection<PilgrimRooms> getPilgrimRooms(PilgrimMaster pilgrim);
    
    //operations for pilgrim_timeslots
    public void addPilgrimTimeSlots(PilgrimTimeslots ptimeslots, Integer pilgrimId);
    public void updatePilgrimTimeSlots(PilgrimTimeslots ptimeslots, Integer pilgrimId);
    public void removePilgrimTimeSlots(Integer timeslotsId, Integer pilgrimId);
    
    Collection<PilgrimTimeslots> getPilgrimTimeslots(PilgrimMaster pilgrim);
    
    //operations for pilgrim_timeslots_details
    public void addPilgrimTimeslotsDetails(PilgrimTimeslotsDetails timeslotsdetails, Integer pilgrimTimeslotsId);
    public void updatepilgrimTimeslotsDetails(PilgrimTimeslotsDetails timeslotsdetails, Integer pilgrimTimeslotsId);
    public void removePilgrimTimeslotsDetails(Integer timeslotsDetailsId, Integer pilgrimTimeslotsId);
    
    Collection<PilgrimTimeslotsDetails> getPilgrimTimeslotsDetails(PilgrimTimeslots timeslots);
    
    //operations from discount_master
    public void addDiscount(DiscountMaster discount);
    public void updateDiscount(DiscountMaster discount);
    public void removeDiscount(DiscountMaster discount);
    
    Collection<DiscountMaster> getDiscounts();
    
    //operations for pilgrim_tickets
    public void addPilgrimTicket(PilgrimTickets ptickets, Integer pilgrimId, Integer timeslotsDetailsId);
    public void updatePilgrimTicket(PilgrimTickets ptickets, Integer pilgrimId, Integer timeslotsDetailsId);
    public void removePilgrimTicket(Integer ticketId, Integer pilgrimId, Integer timeslotsDetailsId);
    
    Collection<PilgrimTickets> getTicketsByPilgrim(PilgrimMaster pilgrim);
    
    //operations for advertisement_master
    public void addAdvertisement(AdvertisementMaster advertisement, Integer pilgrimId);
    public void updateAdvertisement(AdvertisementMaster advertisement, Integer pilgrimId);
    public void removeAdvertisement(Integer advertisementId, Integer pilgrimId);
    
    public Collection<AdvertisementMaster> getAdvertisements();
    public Collection<AdvertisementMaster> getAdvertisementByPilgrim(PilgrimMaster pilgrim);
}
