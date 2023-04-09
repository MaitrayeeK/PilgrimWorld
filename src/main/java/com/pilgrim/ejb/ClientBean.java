/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.pilgrim.ejb;

import com.pilgrim.entities.AdvertisementMaster;
import com.pilgrim.entities.CityMaster;
import com.pilgrim.entities.DiscountMaster;
import com.pilgrim.entities.PilgrimImages;
import com.pilgrim.entities.PilgrimMaster;
import com.pilgrim.entities.PilgrimRooms;
import com.pilgrim.entities.PilgrimTickets;
import com.pilgrim.entities.PilgrimTimeslots;
import com.pilgrim.entities.PilgrimTimeslotsDetails;
import com.pilgrim.entities.StateMaster;
import com.pilgrim.entities.UserMaster;
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
public class ClientBean implements ClientBeanLocal {

    @PersistenceContext(unitName = "PilgrimWorld1PU")
    EntityManager em;

    @Override
    public void addPilgrim(PilgrimMaster pilgrim, Integer userId, Integer stateId, Integer cityId) {
        UserMaster u = em.find(UserMaster.class, userId);
        Collection<PilgrimMaster> userPilgrims = u.getPilgrimMasterCollection();

        StateMaster s = em.find(StateMaster.class, stateId);
        Collection<PilgrimMaster> statePilgrims = s.getPilgrimMasterCollection();

        CityMaster c = em.find(CityMaster.class, cityId);
        Collection<PilgrimMaster> cityPilgrims = c.getPilgrimMasterCollection();
        
        pilgrim.setUser(u);
        pilgrim.setState(s);
        pilgrim.setCity(c);

        userPilgrims.add(pilgrim);
        u.setPilgrimMasterCollection(userPilgrims);
        
        statePilgrims.add(pilgrim);
        s.setPilgrimMasterCollection(statePilgrims);
        
        cityPilgrims.add(pilgrim);
        c.setPilgrimMasterCollection(cityPilgrims);
        
        em.persist(pilgrim);
        em.merge(u);
    }

    @Override
    public void updatePilgrim(PilgrimMaster pilgrim, Integer userId, Integer stateId, Integer cityId) {
        UserMaster u = em.find(UserMaster.class, userId);
        Collection<PilgrimMaster> userPilgrims = u.getPilgrimMasterCollection();

        StateMaster s = em.find(StateMaster.class, stateId);
        Collection<PilgrimMaster> statePilgrims = s.getPilgrimMasterCollection();

        CityMaster c = em.find(CityMaster.class, cityId);
        Collection<PilgrimMaster> cityPilgrims = c.getPilgrimMasterCollection();

//        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrim.getPilgrimId());
//        p.setUser(u);
//        p.setPilgrimName(pilgrim.getPilgrimName());
//        p.setAddress(pilgrim.getAddress());
//        p.setState(s);
//        p.setCity(c);
//        p.setPilgrimImage(pilgrim.getPilgrimImage());
//        p.setCreatedDate(p.getCreatedDate());
//        p.setUpdatedDate(new Date());

        pilgrim.setUser(u);
        pilgrim.setState(s);
        pilgrim.setCity(c);

        u.setPilgrimMasterCollection(userPilgrims);
        s.setPilgrimMasterCollection(statePilgrims);
        c.setPilgrimMasterCollection(cityPilgrims);

        em.merge(pilgrim);
    }

    @Override
    public void removePilgrim(Integer pilgrimId, Integer userId, Integer stateId, Integer cityId) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);

        UserMaster u = em.find(UserMaster.class, userId);
        Collection<PilgrimMaster> userPilgrims = u.getPilgrimMasterCollection();

        StateMaster s = em.find(StateMaster.class, stateId);
        Collection<PilgrimMaster> statePilgrims = s.getPilgrimMasterCollection();

        CityMaster c = em.find(CityMaster.class, cityId);
        Collection<PilgrimMaster> cityPilgrims = c.getPilgrimMasterCollection();

        if (userPilgrims.contains(p) && statePilgrims.contains(p) && cityPilgrims.contains(p)) {
            userPilgrims.remove(p);
            u.setPilgrimMasterCollection(userPilgrims);

            statePilgrims.remove(p);
            s.setPilgrimMasterCollection(statePilgrims);

            cityPilgrims.remove(p);
            c.setPilgrimMasterCollection(cityPilgrims);

            em.remove(p);
        }
    }

    @Override
    public Collection<PilgrimMaster> getPilgrims() {
        Collection<PilgrimMaster> pilgrims = em.createNamedQuery("PilgrimMaster.findAll").getResultList();
        return pilgrims;
    }

    @Override
    public Collection<PilgrimMaster> getPilgrimsByState(Integer stateId) {
        StateMaster s = em.find(StateMaster.class, stateId);
        return s.getPilgrimMasterCollection();
    }

    @Override
    public Collection<PilgrimMaster> getPilgrimsByCity(Integer cityId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<PilgrimMaster> getPilgrimsByStateCity(Integer StateId, Integer cityId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addPilgrimImages(PilgrimImages pimages, Integer pilgrimId) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<PilgrimImages> pilgrimImages = p.getPilgrimImagesCollection();

        pimages.setPilgrim(p);
        
        pilgrimImages.add(pimages);
        p.setPilgrimImagesCollection(pilgrimImages);

        em.persist(pimages);
        em.merge(p);
    }

    @Override
    public void updatePilgrimImages(PilgrimImages pimages, Integer pilgrimId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        PilgrimMaster p = em.find(PilgrimMaster.class, pimages.getPilgrim().getPilgrimId());
        Collection<PilgrimImages> pilgrimImages = p.getPilgrimImagesCollection();
        
        pimages.setPilgrim(p);

        p.setPilgrimImagesCollection(pilgrimImages);
        em.merge(pimages);
    }

    @Override
    public void removePilgrimImages(Integer pilgrimImageId, Integer pilgrimId) {
        PilgrimImages i = em.find(PilgrimImages.class, pilgrimImageId);

        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<PilgrimImages> pilgrimImages = p.getPilgrimImagesCollection();

        if (pilgrimImages.contains(i)) {
            pilgrimImages.remove(i);
            p.setPilgrimImagesCollection(pilgrimImages);
            em.remove(i);
        }
    }

    @Override
    public Collection<PilgrimImages> getPilgrimImages(PilgrimMaster pilgrim) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrim.getPilgrimId());
        Collection<PilgrimImages> images = p.getPilgrimImagesCollection();
        return images;
    }

    @Override
    public void addPilgrimRooms(PilgrimRooms prooms, Integer pilgrimId) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<PilgrimRooms> pilgrimRooms = p.getPilgrimRoomsCollection();
        
        prooms.setPilgrim(p);

        pilgrimRooms.add(prooms);
        p.setPilgrimRoomsCollection(pilgrimRooms);

        em.persist(prooms);
        em.merge(p);
    }

    @Override
    public void updatePilgrimRooms(PilgrimRooms prooms, Integer pilgrimId) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<PilgrimRooms> pilgrimRooms = p.getPilgrimRoomsCollection();
        
        prooms.setPilgrim(p);

        p.setPilgrimRoomsCollection(pilgrimRooms);
        em.merge(prooms);

    }

    @Override
    public void removePilgrimRooms(Integer pilgrimRoomId, Integer pilgrimId) {
        PilgrimRooms r = em.find(PilgrimRooms.class, pilgrimRoomId);

        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<PilgrimRooms> pilgrimRooms = p.getPilgrimRoomsCollection();

        if (pilgrimRooms.contains(r)) {
            pilgrimRooms.remove(r);
            p.setPilgrimRoomsCollection(pilgrimRooms);
            em.remove(r);
        }
    }

    @Override
    public Collection<PilgrimRooms> getPilgrimRooms(PilgrimMaster pilgrim) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrim.getPilgrimId());
        Collection<PilgrimRooms> rooms = p.getPilgrimRoomsCollection();
        return rooms;
    }

    @Override
    public void addPilgrimTimeSlots(PilgrimTimeslots ptimeslots, Integer pilgrimId) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<PilgrimTimeslots> timeslots = p.getPilgrimTimeslotsCollection();
        
        ptimeslots.setPilgrim(p);

        timeslots.add(ptimeslots);
        p.setPilgrimTimeslotsCollection(timeslots);

        em.persist(ptimeslots);
        em.merge(p);
    }

    @Override
    public void updatePilgrimTimeSlots(PilgrimTimeslots ptimeslots, Integer pilgrimId) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<PilgrimTimeslots> timeslots = p.getPilgrimTimeslotsCollection();
        
        ptimeslots.setPilgrim(p);

        p.setPilgrimTimeslotsCollection(timeslots);
        em.merge(ptimeslots);
    }

    @Override
    public void removePilgrimTimeSlots(Integer timeslotsId, Integer pilgrimId) {
        PilgrimTimeslots ts = em.find(PilgrimTimeslots.class, timeslotsId);

        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<PilgrimTimeslots> timeslots = p.getPilgrimTimeslotsCollection();

        if(timeslots.contains(ts)){
            timeslots.remove(ts);
            p.setPilgrimTimeslotsCollection(timeslots);
            em.remove(ts);
        }
    }

    @Override
    public Collection<PilgrimTimeslots> getPilgrimTimeslots(PilgrimMaster pilgrim) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrim.getPilgrimId());
        Collection<PilgrimTimeslots> timeslots = p.getPilgrimTimeslotsCollection();
        return timeslots;
    }

    @Override
    public void addPilgrimTimeslotsDetails(PilgrimTimeslotsDetails timeslotsdetails, Integer pilgrimTimeslotsId) {
        PilgrimTimeslots ts = em.find(PilgrimTimeslots.class, pilgrimTimeslotsId);
        Collection<PilgrimTimeslotsDetails> slotsdetails = ts.getPilgrimTimeslotsDetailsCollection();
        
        timeslotsdetails.setTimeslots(ts);
        
        slotsdetails.add(timeslotsdetails);
        ts.setPilgrimTimeslotsDetailsCollection(slotsdetails);
        
        em.persist(timeslotsdetails);
        em.merge(ts);
    }

    @Override
    public void updatepilgrimTimeslotsDetails(PilgrimTimeslotsDetails timeslotsdetails, Integer pilgrimTimeslotsId) {
        PilgrimTimeslots ts = em.find(PilgrimTimeslots.class, pilgrimTimeslotsId);
        Collection<PilgrimTimeslotsDetails> slotsdetails = ts.getPilgrimTimeslotsDetailsCollection();
        
        timeslotsdetails.setTimeslots(ts);
        
        ts.setPilgrimTimeslotsDetailsCollection(slotsdetails);
        em.merge(timeslotsdetails);
    }

    @Override
    public void removePilgrimTimeslotsDetails(Integer timeslotsDetailsId, Integer pilgrimTimeslotsId) {
        PilgrimTimeslotsDetails tsd = em.find(PilgrimTimeslotsDetails.class, timeslotsDetailsId);
        
        PilgrimTimeslots ts = em.find(PilgrimTimeslots.class, pilgrimTimeslotsId);
        Collection<PilgrimTimeslotsDetails> slotsdetails = ts.getPilgrimTimeslotsDetailsCollection();
        
        if(slotsdetails.contains(tsd)){
            slotsdetails.remove(tsd);
            ts.setPilgrimTimeslotsDetailsCollection(slotsdetails);
            em.remove(tsd);
        }
    }

    @Override
    public Collection<PilgrimTimeslotsDetails> getPilgrimTimeslotsDetails(PilgrimTimeslots timeslots) {
        PilgrimTimeslots ts = em.find(PilgrimTimeslots.class, timeslots.getTimeslotsId());
        Collection<PilgrimTimeslotsDetails> slotsdetails = ts.getPilgrimTimeslotsDetailsCollection();
        return slotsdetails;
    }

    @Override
    public void addDiscount(DiscountMaster discount) {
        em.persist(discount);
    }

    @Override
    public void updateDiscount(DiscountMaster discount) {
        em.merge(discount);
    }

    @Override
    public void removeDiscount(DiscountMaster discount) {
        DiscountMaster d = em.find(DiscountMaster.class, discount.getDiscountId());
        em.remove(d);
    }

    @Override
    public Collection<DiscountMaster> getDiscounts() {
        return em.createNamedQuery("DiscountMaster.findAll").getResultList();
    }

    @Override
    public void addPilgrimTicket(PilgrimTickets ptickets, Integer pilgrimId, Integer timeslotsDetailsId) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<PilgrimTickets> pilgrimTickets = p.getPilgrimTicketsCollection();
        
        PilgrimTimeslotsDetails tsd = em.find(PilgrimTimeslotsDetails.class, timeslotsDetailsId);
        Collection<PilgrimTickets> timeslotsTickets = p.getPilgrimTicketsCollection();
        
        ptickets.setPilgrim(p);
        ptickets.setTimeslotsDetails(tsd);
        
        pilgrimTickets.add(ptickets);
        p.setPilgrimTicketsCollection(pilgrimTickets);
        
        timeslotsTickets.add(ptickets);
        tsd.setPilgrimTicketsCollection(pilgrimTickets);
        
        em.persist(ptickets);
        em.merge(p);
    }

    @Override
    public void updatePilgrimTicket(PilgrimTickets ptickets, Integer pilgrimId, Integer timeslotsDetailsId) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<PilgrimTickets> pilgrimTickets = p.getPilgrimTicketsCollection();
        
        PilgrimTimeslotsDetails tsd = em.find(PilgrimTimeslotsDetails.class, timeslotsDetailsId);
        Collection<PilgrimTickets> timeslotsTickets = p.getPilgrimTicketsCollection();
        
        ptickets.setPilgrim(p);
        ptickets.setTimeslotsDetails(tsd);
        
        p.setPilgrimTicketsCollection(pilgrimTickets);
        tsd.setPilgrimTicketsCollection(timeslotsTickets);
        
        em.merge(ptickets);
    }

    @Override
    public void removePilgrimTicket(Integer ticketId, Integer pilgrimId, Integer timeslotsDetailsId) {
        PilgrimTickets t = em.find(PilgrimTickets.class, ticketId);
        
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<PilgrimTickets> pilgrimTickets = p.getPilgrimTicketsCollection();
        
        PilgrimTimeslotsDetails tsd = em.find(PilgrimTimeslotsDetails.class, timeslotsDetailsId);
        Collection<PilgrimTickets> timeslotsTickets = p.getPilgrimTicketsCollection();
        
        if(pilgrimTickets.contains(t) && timeslotsTickets.contains(t)){
            pilgrimTickets.remove(t);
            p.setPilgrimTicketsCollection(pilgrimTickets);
            
            timeslotsTickets.remove(t);
            tsd.setPilgrimTicketsCollection(pilgrimTickets);
            
            em.remove(t);
        }
    }

    @Override
    public Collection<PilgrimTickets> getTicketsByPilgrim(PilgrimMaster pilgrim) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrim.getPilgrimId());
        Collection<PilgrimTickets> tickets = p.getPilgrimTicketsCollection();
        return tickets;
    }

    @Override
    public void addAdvertisement(AdvertisementMaster advertisement, Integer pilgrimId) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<AdvertisementMaster> pilgrimAds = p.getAdvertisementMasterCollection();
        
        advertisement.setPilgrim(p);
        
        pilgrimAds.add(advertisement);
        p.setAdvertisementMasterCollection(pilgrimAds);
        
        em.persist(advertisement);
        em.merge(p);
    }

    @Override
    public void updateAdvertisement(AdvertisementMaster advertisement, Integer pilgrimId) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<AdvertisementMaster> pilgrimAds = p.getAdvertisementMasterCollection();
        
        advertisement.setPilgrim(p);
        
        p.setAdvertisementMasterCollection(pilgrimAds);
        em.merge(advertisement);
    }

    @Override
    public void removeAdvertisement(Integer advertisementId, Integer pilgrimId) {
        AdvertisementMaster a = em.find(AdvertisementMaster.class, advertisementId);
        
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<AdvertisementMaster> pilgrimAds = p.getAdvertisementMasterCollection();
        
        if(pilgrimAds.contains(a)){
            pilgrimAds.remove(a);
            p.setAdvertisementMasterCollection(pilgrimAds);
            em.remove(a);
        }
        
    }

    @Override
    public Collection<AdvertisementMaster> getAdvertisements() {
        Collection<AdvertisementMaster> ads = em.createNamedQuery("AdvertisementMaster.findAll").getResultList();
        return ads;
    }

    @Override
    public Collection<AdvertisementMaster> getAdvertisementByPilgrim(PilgrimMaster pilgrim) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrim.getPilgrimId());
        Collection<AdvertisementMaster> pilgrimAds = p.getAdvertisementMasterCollection();
        return pilgrimAds;
    }
}
