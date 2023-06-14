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
    public void addPilgrim(PilgrimMaster pilgrim) {
        UserMaster user = em.find(UserMaster.class, pilgrim.getUser().getUserId());
        Collection<PilgrimMaster> userPilgrims = user.getPilgrimMasterCollection();

        StateMaster state = em.find(StateMaster.class, pilgrim.getState().getStateId());
        Collection<PilgrimMaster> statePilgrims = state.getPilgrimMasterCollection();

        CityMaster city = em.find(CityMaster.class, pilgrim.getCity().getCityId());
        Collection<PilgrimMaster> cityPilgrims = city.getPilgrimMasterCollection();
        
        pilgrim.setUser(user);
        pilgrim.setState(state);
        pilgrim.setCity(city);

        userPilgrims.add(pilgrim);
        user.setPilgrimMasterCollection(userPilgrims);
        
        statePilgrims.add(pilgrim);
        state.setPilgrimMasterCollection(statePilgrims);
        
        cityPilgrims.add(pilgrim);
        city.setPilgrimMasterCollection(cityPilgrims);
        
        em.persist(pilgrim);
        em.merge(user);
    }

    @Override
    public void updatePilgrim(PilgrimMaster pilgrim) {
        UserMaster user = em.find(UserMaster.class, pilgrim.getUser().getUserId());
        StateMaster state = em.find(StateMaster.class, pilgrim.getState().getStateId());
        CityMaster city = em.find(CityMaster.class, pilgrim.getCity().getCityId());

        pilgrim.setUser(user);
        pilgrim.setState(state);
        pilgrim.setCity(city);

        em.merge(pilgrim);
    }

    @Override
    public void removePilgrim(Integer pilgrimId) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, pilgrimId);

        UserMaster user = em.find(UserMaster.class, pilgrim.getUser().getUserId());
        Collection<PilgrimMaster> userPilgrims = user.getPilgrimMasterCollection();

        StateMaster state = em.find(StateMaster.class, pilgrim.getState().getStateId());
        Collection<PilgrimMaster> statePilgrims = state.getPilgrimMasterCollection();

        CityMaster city = em.find(CityMaster.class, pilgrim.getCity().getCityId());
        Collection<PilgrimMaster> cityPilgrims = city.getPilgrimMasterCollection();

        if (userPilgrims.contains(pilgrim) && statePilgrims.contains(pilgrim) && cityPilgrims.contains(pilgrim)) {
            
            userPilgrims.remove(pilgrim);
            statePilgrims.remove(pilgrim);
            cityPilgrims.remove(pilgrim);

            em.remove(pilgrim);
        }
    }

    @Override
    public Collection<PilgrimMaster> getPilgrims() {
        Collection<PilgrimMaster> pilgrims = em.createNamedQuery("PilgrimMaster.findAll").getResultList();
        return pilgrims;
    }
    
    @Override
    public PilgrimMaster getPilgrimById(Integer pilgrimid) {
        return em.find(PilgrimMaster.class, pilgrimid);
    }

    @Override
    public Collection<PilgrimMaster> getPilgrimsByState(Integer stateId) {
        StateMaster state = em.find(StateMaster.class, stateId);
        return state.getPilgrimMasterCollection();
    }

    @Override
    public Collection<PilgrimMaster> getPilgrimsByCity(Integer cityId) {
        CityMaster city = em.find(CityMaster.class, cityId);
        return city.getPilgrimMasterCollection();
    }

    @Override
    public Collection<PilgrimMaster> getPilgrimsByStateCity(Integer StateId, Integer cityId) {
        StateMaster state = em.find(StateMaster.class, StateId);
        CityMaster city = em.find(CityMaster.class, cityId);
        return em.createNamedQuery("PilgrimMaster.findByStateCity")
                .setParameter("state", state)
                .setParameter("city", city)
                .getResultList();
    }

    @Override
    public void addPilgrimImages(PilgrimImages pimages) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, pimages.getPilgrim().getPilgrimId());
        Collection<PilgrimImages> pilgrimImages = pilgrim.getPilgrimImagesCollection();

        pimages.setPilgrim(pilgrim);
        
        pilgrimImages.add(pimages);
        pilgrim.setPilgrimImagesCollection(pilgrimImages);

        em.persist(pimages);
        em.merge(pilgrim);
    }

    @Override
    public void updatePilgrimImages(PilgrimImages pimages) {

        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, pimages.getPilgrim().getPilgrimId());
        pimages.setPilgrim(pilgrim);
        em.merge(pimages);
    }

    @Override
    public void removePilgrimImages(Integer pilgrimImageId) {
        PilgrimImages pimages = em.find(PilgrimImages.class, pilgrimImageId);

        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, pimages.getPilgrim().getPilgrimId());
        Collection<PilgrimImages> pilgrimImages = pilgrim.getPilgrimImagesCollection();

        if (pilgrimImages.contains(pimages)) {
            pilgrimImages.remove(pimages);
            em.remove(pimages);
        }
    }

    @Override
    public Collection<PilgrimImages> getPilgrimImages(Integer pilgrimid) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, pilgrimid);
        Collection<PilgrimImages> images = pilgrim.getPilgrimImagesCollection();
        return images;
    }

    @Override
    public void addPilgrimRooms(PilgrimRooms prooms) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, prooms.getPilgrim().getPilgrimId());
        Collection<PilgrimRooms> pilgrimRooms = pilgrim.getPilgrimRoomsCollection();
        
        prooms.setPilgrim(pilgrim);

        pilgrimRooms.add(prooms);
        pilgrim.setPilgrimRoomsCollection(pilgrimRooms);

        em.persist(prooms);
        em.merge(pilgrim);
    }

    @Override
    public void updatePilgrimRooms(PilgrimRooms prooms) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, prooms.getPilgrim().getPilgrimId());
        prooms.setPilgrim(pilgrim);
        em.merge(prooms);

    }

    @Override
    public void removePilgrimRooms(Integer pilgrimRoomId) {
        PilgrimRooms prooms = em.find(PilgrimRooms.class, pilgrimRoomId);

        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, prooms.getPilgrim().getPilgrimId());
        Collection<PilgrimRooms> pilgrimRooms = pilgrim.getPilgrimRoomsCollection();

        if (pilgrimRooms.contains(prooms)) {
            pilgrimRooms.remove(prooms);
            em.remove(prooms);
        }
    }

    @Override
    public Collection<PilgrimRooms> getPilgrimRooms(Integer pilgrimid) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, pilgrimid);
        Collection<PilgrimRooms> rooms = pilgrim.getPilgrimRoomsCollection();
        return rooms;
    }
    
    @Override
    public PilgrimRooms getPilgrimRoomsById(Integer proomid) {
        return em.find(PilgrimRooms.class, proomid);
    }

    @Override
    public void addPilgrimTimeslots(PilgrimTimeslots ptimeslots) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, ptimeslots.getPilgrim().getPilgrimId());
        Collection<PilgrimTimeslots> timeslots = pilgrim.getPilgrimTimeslotsCollection();
        
        ptimeslots.setPilgrim(pilgrim);

        timeslots.add(ptimeslots);
        pilgrim.setPilgrimTimeslotsCollection(timeslots);

        em.persist(ptimeslots);
        em.merge(pilgrim);
    }

    @Override
    public void updatePilgrimTimeslots(PilgrimTimeslots ptimeslots) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, ptimeslots.getPilgrim().getPilgrimId());
        ptimeslots.setPilgrim(pilgrim);
        em.merge(ptimeslots);
    }

    @Override
    public void removePilgrimTimeslots(Integer timeslotsId) {
        PilgrimTimeslots ptimeslot = em.find(PilgrimTimeslots.class, timeslotsId);

        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, ptimeslot.getPilgrim().getPilgrimId());
        Collection<PilgrimTimeslots> pilgrimTimeslots = pilgrim.getPilgrimTimeslotsCollection();

        if(pilgrimTimeslots.contains(ptimeslot)){
            pilgrimTimeslots.remove(ptimeslot);
            em.remove(ptimeslot);
        }
    }

    @Override
    public Collection<PilgrimTimeslots> getPilgrimTimeslots(Integer pilgrimid) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, pilgrimid);
        Collection<PilgrimTimeslots> timeslots = pilgrim.getPilgrimTimeslotsCollection();
        return timeslots;
    }

    @Override
    public void addPilgrimTimeslotsDetails(PilgrimTimeslotsDetails timeslotsdetails) {
        PilgrimTimeslots timeslots = em.find(PilgrimTimeslots.class, timeslotsdetails.getTimeslots().getTimeslotsId());
        Collection<PilgrimTimeslotsDetails> slotsdetails = timeslots.getPilgrimTimeslotsDetailsCollection();
        
        timeslotsdetails.setTimeslots(timeslots);
        
        slotsdetails.add(timeslotsdetails);
        timeslots.setPilgrimTimeslotsDetailsCollection(slotsdetails);
        
        em.persist(timeslotsdetails);
        em.merge(timeslots);
    }

    @Override
    public void updatepilgrimTimeslotsDetails(PilgrimTimeslotsDetails timeslotsdetails) {
        PilgrimTimeslots timeslots = em.find(PilgrimTimeslots.class, timeslotsdetails.getTimeslots().getTimeslotsId());
        timeslotsdetails.setTimeslots(timeslots);
        em.merge(timeslotsdetails);
    }

    @Override
    public void removePilgrimTimeslotsDetails(Integer timeslotsDetailsId) {
        PilgrimTimeslotsDetails timeslotsdetails = em.find(PilgrimTimeslotsDetails.class, timeslotsDetailsId);
        
        PilgrimTimeslots timeslots = em.find(PilgrimTimeslots.class, timeslotsdetails.getTimeslots().getTimeslotsId());
        Collection<PilgrimTimeslotsDetails> slotsdetails = timeslots.getPilgrimTimeslotsDetailsCollection();
        
        if(slotsdetails.contains(timeslotsdetails)){
            slotsdetails.remove(timeslotsdetails);
            em.remove(timeslotsdetails);
        }
    }

    @Override
    public Collection<PilgrimTimeslotsDetails> getPilgrimTimeslotsDetails(Integer timeslotsid) {
        PilgrimTimeslots timeslots = em.find(PilgrimTimeslots.class, timeslotsid);
        Collection<PilgrimTimeslotsDetails> timeslotsdetails = timeslots.getPilgrimTimeslotsDetailsCollection();
        return timeslotsdetails;
    }
    
    @Override
    public PilgrimTickets getTicketsByPTimeSlotsDetails(Integer ptimeslotsdetailsid) {
        return em.find(PilgrimTickets.class, ptimeslotsdetailsid);
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
    public void removeDiscount(Integer discountid) {
        DiscountMaster discount = em.find(DiscountMaster.class, discountid);
        em.remove(discount);
    }

    @Override
    public Collection<DiscountMaster> getDiscounts() {
        return em.createNamedQuery("DiscountMaster.findAll").getResultList();
    }

    @Override
    public void addPilgrimTicket(PilgrimTickets ptickets) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, ptickets.getPilgrim().getPilgrimId());
        Collection<PilgrimTickets> pilgrimTickets = pilgrim.getPilgrimTicketsCollection();
        
        PilgrimTimeslotsDetails timeslotsdetails = em.find(PilgrimTimeslotsDetails.class, ptickets.getTimeslotsDetails().getTimeslotsDetailsId());
        Collection<PilgrimTickets> timeslotsTickets = timeslotsdetails.getPilgrimTicketsCollection();
        
        ptickets.setPilgrim(pilgrim);
        ptickets.setTimeslotsDetails(timeslotsdetails);
        
        pilgrimTickets.add(ptickets);
        pilgrim.setPilgrimTicketsCollection(pilgrimTickets);
        
        timeslotsTickets.add(ptickets);
        timeslotsdetails.setPilgrimTicketsCollection(pilgrimTickets);
        
        em.persist(ptickets);
        em.merge(pilgrim);
    }

    @Override
    public void updatePilgrimTicket(PilgrimTickets ptickets) {
        
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, ptickets.getPilgrim().getPilgrimId());
        PilgrimTimeslotsDetails timeslotsdetails = em.find(PilgrimTimeslotsDetails.class, ptickets.getTimeslotsDetails().getTimeslotsDetailsId());
        
        ptickets.setPilgrim(pilgrim);
        ptickets.setTimeslotsDetails(timeslotsdetails);
        
        em.merge(ptickets);
    }

    @Override
    public void removePilgrimTicket(Integer ticketId) {
        PilgrimTickets pticket = em.find(PilgrimTickets.class, ticketId);
        
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, pticket.getPilgrim().getPilgrimId());
        Collection<PilgrimTickets> pilgrimTickets = pilgrim.getPilgrimTicketsCollection();
        
        PilgrimTimeslotsDetails timeslotsdetails = em.find(PilgrimTimeslotsDetails.class, pticket.getTimeslotsDetails().getTimeslotsDetailsId());
        Collection<PilgrimTickets> timeslotsTickets = timeslotsdetails.getPilgrimTicketsCollection();
        
        if(pilgrimTickets.contains(pticket) && timeslotsTickets.contains(pticket)){
            pilgrimTickets.remove(pticket);
            timeslotsTickets.remove(pticket);
            em.remove(pticket);
        }
    }

    @Override
    public Collection<PilgrimTickets> getTicketsByPilgrim(Integer pilgrimid) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, pilgrimid);
        Collection<PilgrimTickets> tickets = pilgrim.getPilgrimTicketsCollection();
        return tickets;
    }

    @Override
    public void addAdvertisement(AdvertisementMaster advertisement) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, advertisement.getPilgrim().getPilgrimId());
        Collection<AdvertisementMaster> pilgrimAds = pilgrim.getAdvertisementMasterCollection();
        
        advertisement.setPilgrim(pilgrim);
        
        pilgrimAds.add(advertisement);
        pilgrim.setAdvertisementMasterCollection(pilgrimAds);
        
        em.persist(advertisement);
        em.merge(pilgrim);
    }

    @Override
    public void updateAdvertisement(AdvertisementMaster advertisement) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, advertisement.getPilgrim().getPilgrimId());
        advertisement.setPilgrim(pilgrim);
        em.merge(advertisement);
    }

    @Override
    public void removeAdvertisement(Integer advertisementId) {
        AdvertisementMaster advertisement = em.find(AdvertisementMaster.class, advertisementId);
        
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, advertisement.getPilgrim().getPilgrimId());
        Collection<AdvertisementMaster> pilgrimAds = pilgrim.getAdvertisementMasterCollection();
        
        if(pilgrimAds.contains(advertisement)){
            pilgrimAds.remove(advertisement);
            em.remove(advertisement);
        }
        
    }

    @Override
    public Collection<AdvertisementMaster> getAdvertisements() {
        Collection<AdvertisementMaster> ads = em.createNamedQuery("AdvertisementMaster.findAll").getResultList();
        return ads;
    }

    @Override
    public Collection<AdvertisementMaster> getAdvertisementByPilgrim(Integer pilgrimid) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, pilgrimid);
        Collection<AdvertisementMaster> pilgrimAds = pilgrim.getAdvertisementMasterCollection();
        return pilgrimAds;
    }
}
