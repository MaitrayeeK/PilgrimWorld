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
    public void addPilgrim(PilgrimMaster pilgrim);
    public void updatePilgrim(PilgrimMaster pilgrim);
    public void removePilgrim(Integer pilgrimId);
    
    Collection<PilgrimMaster> getPilgrims();
    PilgrimMaster getPilgrimById(Integer pilgrimid);
    Collection<PilgrimMaster> getPilgrimsByState(Integer stateId);
    Collection<PilgrimMaster> getPilgrimsByCity(Integer cityId);
    Collection<PilgrimMaster> getPilgrimsByStateCity(Integer StateId, Integer cityId);
    
    //operations for pilgrim_images
    public void addPilgrimImages(PilgrimImages pimages);
    public void updatePilgrimImages(PilgrimImages pimages);
    public void removePilgrimImages(Integer pilgrimImageId);
    
    Collection<PilgrimImages> getPilgrimImages(Integer pilgrimid);
    
    //operations for pilgrim_rooms
    public void addPilgrimRooms(PilgrimRooms prooms);
    public void updatePilgrimRooms(PilgrimRooms prooms);
    public void removePilgrimRooms(Integer pilgrimRoomId);
    
    Collection<PilgrimRooms> getPilgrimRooms(Integer pilgrimid);
    PilgrimRooms getPilgrimRoomsById(Integer proomid);
    
    //operations for pilgrim_timeslots
    public void addPilgrimTimeslots(PilgrimTimeslots ptimeslots);
    public void updatePilgrimTimeslots(PilgrimTimeslots ptimeslots);
    public void removePilgrimTimeslots(Integer timeslotsId);
    
    Collection<PilgrimTimeslots> getPilgrimTimeslots(Integer pilgrimid);
    
    //operations for pilgrim_timeslots_details
    public void addPilgrimTimeslotsDetails(PilgrimTimeslotsDetails timeslotsdetails);
    public void updatepilgrimTimeslotsDetails(PilgrimTimeslotsDetails timeslotsdetails);
    public void removePilgrimTimeslotsDetails(Integer timeslotsDetailsId);
    
    Collection<PilgrimTimeslotsDetails> getPilgrimTimeslotsDetails(Integer timeslotsid);
    
    //operations from discount_master
    public void addDiscount(DiscountMaster discount);
    public void updateDiscount(DiscountMaster discount);
    public void removeDiscount(Integer discountid);
    
    Collection<DiscountMaster> getDiscounts();
    
    //operations for pilgrim_tickets
    public void addPilgrimTicket(PilgrimTickets ptickets);
    public void updatePilgrimTicket(PilgrimTickets ptickets);
    public void removePilgrimTicket(Integer ticketId);
    
    Collection<PilgrimTickets> getTicketsByPilgrim(Integer pilgrimid);
    PilgrimTickets getTicketsByPTimeSlotsDetails(Integer ptimeslotsdetailsid);
    
    //operations for advertisement_master
    public void addAdvertisement(AdvertisementMaster advertisement);
    public void updateAdvertisement(AdvertisementMaster advertisement);
    public void removeAdvertisement(Integer advertisementId);
    
    public Collection<AdvertisementMaster> getAdvertisements();
    public Collection<AdvertisementMaster> getAdvertisementByPilgrim(Integer pilgrimid);
    
    public Collection<PilgrimMaster> getPilgrimsByUser(Integer id);
    public Collection<PilgrimTimeslotsDetails> getAllTimeslotsDetails();
}
