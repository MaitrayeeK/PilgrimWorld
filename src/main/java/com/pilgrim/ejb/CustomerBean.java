/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.pilgrim.ejb;

import com.pilgrim.entities.BookingMaster;
import com.pilgrim.entities.DiscountMaster;
import com.pilgrim.entities.FeedbackMaster;
import com.pilgrim.entities.PaymentMaster;
import com.pilgrim.entities.PilgrimMaster;
import com.pilgrim.entities.PilgrimTickets;
import com.pilgrim.entities.PilgrimTimeslotsDetails;
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
public class CustomerBean implements CustomerBeanLocal {
    
    @PersistenceContext(unitName = "PilgrimWorld1PU")
    EntityManager em;
    
    @Override
    public void addFeedback(FeedbackMaster feedback, Integer pilgrimId, Integer userId) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<FeedbackMaster> pilgrimFeedbacks = p.getFeedbackMasterCollection();
        
        UserMaster u = em.find(UserMaster.class, userId);
        Collection<FeedbackMaster> userFeedbacks = u.getFeedbackMasterCollection();
        
        feedback.setPilgrim(p);
        feedback.setUser(u);
        
        pilgrimFeedbacks.add(feedback);
        p.setFeedbackMasterCollection(pilgrimFeedbacks);
        
        userFeedbacks.add(feedback);
        u.setFeedbackMasterCollection(userFeedbacks);
        
        em.persist(feedback);
        em.merge(u);
    }

    @Override
    public void updateFeedback(FeedbackMaster feedback, Integer pilgrimId, Integer userId) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<FeedbackMaster> pilgrimFeedbacks = p.getFeedbackMasterCollection();
        
        UserMaster u = em.find(UserMaster.class, userId);
        Collection<FeedbackMaster> userFeedbacks = u.getFeedbackMasterCollection();
        
        feedback.setPilgrim(p);
        feedback.setUser(u);
        
        p.setFeedbackMasterCollection(pilgrimFeedbacks);
        u.setFeedbackMasterCollection(userFeedbacks);
        
        em.merge(feedback);
    }

    @Override
    public void removeFeedback(Integer feedbackId, Integer pilgrimId, Integer userId) {
        FeedbackMaster f = em.find(FeedbackMaster.class, feedbackId);
        
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<FeedbackMaster> pilgrimFeedbacks = p.getFeedbackMasterCollection();
        
        UserMaster u = em.find(UserMaster.class, userId);
        Collection<FeedbackMaster> userFeedbacks = u.getFeedbackMasterCollection();

        if(pilgrimFeedbacks.contains(f) && userFeedbacks.contains(f)){
            pilgrimFeedbacks.remove(f);
            p.setFeedbackMasterCollection(pilgrimFeedbacks);
            
            userFeedbacks.remove(f);
            u.setFeedbackMasterCollection(userFeedbacks);
            
            em.remove(f);
        }
    }
    
    @Override
    public Collection<FeedbackMaster> getFeedbacks() {
        Collection<FeedbackMaster> feedbacks = em.createNamedQuery("FeedbackMaster.findAll").getResultList();
        return feedbacks;
    }

    @Override
    public Collection<FeedbackMaster> getFeedbacksByPilgrim(PilgrimMaster pilgrim) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrim.getPilgrimId());
        Collection<FeedbackMaster> pilgrimFeedbacks = p.getFeedbackMasterCollection();
        return pilgrimFeedbacks;
    }

    @Override
    public Collection<FeedbackMaster> getFeedbacksByUser(UserMaster user) {
        UserMaster u = em.find(UserMaster.class, user.getUserId());
        Collection<FeedbackMaster> userFeedbacks = u.getFeedbackMasterCollection();
        return userFeedbacks;
    }

    @Override
    public void addBooking(BookingMaster booking, Integer userId, Integer pilgrimId, Integer timeslotsDetailsId, Integer ticketId, Integer discountId) {
        UserMaster u = em.find(UserMaster.class, userId);
        Collection<BookingMaster> userBookings = u.getBookingMasterCollection();
        
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<BookingMaster> pilgrimBookings = p.getBookingMasterCollection();
        
        PilgrimTimeslotsDetails tsd = em.find(PilgrimTimeslotsDetails.class, timeslotsDetailsId);
        Collection<BookingMaster> tsdBookings = tsd.getBookingMasterCollection();
        
        PilgrimTickets t = em.find(PilgrimTickets.class, ticketId);
        Collection<BookingMaster> ticketBookings = t.getBookingMasterCollection();
        
        DiscountMaster d = em.find(DiscountMaster.class, discountId);
        Collection<BookingMaster> discountBookings = d.getBookingMasterCollection();
        
        booking.setUser(u);
        booking.setPilgrim(p);
        booking.setTimeslotsDetails(tsd);
        booking.setTicket(t);
        booking.setDiscount(d);
        
        userBookings.add(booking);
        u.setBookingMasterCollection(userBookings);
        
        pilgrimBookings.add(booking);
        p.setBookingMasterCollection(pilgrimBookings);
        
        tsdBookings.add(booking);
        tsd.setBookingMasterCollection(tsdBookings);
        
        ticketBookings.add(booking);
        t.setBookingMasterCollection(ticketBookings);
        
        discountBookings.add(booking);
        d.setBookingMasterCollection(discountBookings);
        
        em.persist(booking);
        em.merge(u);
    }

    @Override
    public void updateBooking(BookingMaster booking, Integer userId, Integer pilgrimId, Integer timeslotsDetailsId, Integer ticketId, Integer discountId) {
        UserMaster u = em.find(UserMaster.class, userId);
        Collection<BookingMaster> userBookings = u.getBookingMasterCollection();
        
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<BookingMaster> pilgrimBookings = p.getBookingMasterCollection();
        
        PilgrimTimeslotsDetails tsd = em.find(PilgrimTimeslotsDetails.class, timeslotsDetailsId);
        Collection<BookingMaster> tsdBookings = tsd.getBookingMasterCollection();
        
        PilgrimTickets t = em.find(PilgrimTickets.class, ticketId);
        Collection<BookingMaster> ticketBookings = t.getBookingMasterCollection();
        
        DiscountMaster d = em.find(DiscountMaster.class, discountId);
        Collection<BookingMaster> discountBookings = d.getBookingMasterCollection();
        
        booking.setUser(u);
        booking.setPilgrim(p);
        booking.setTimeslotsDetails(tsd);
        booking.setTicket(t);
        booking.setDiscount(d);
        
        u.setBookingMasterCollection(userBookings);
        p.setBookingMasterCollection(pilgrimBookings);
        tsd.setBookingMasterCollection(tsdBookings);
        t.setBookingMasterCollection(ticketBookings);
        d.setBookingMasterCollection(discountBookings);
        
        em.merge(booking);
    }

    @Override
    public void removeBooking(Integer bookingId, Integer userId, Integer pilgrimId, Integer timeslotsDetailsId, Integer ticketId, Integer discountId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        BookingMaster b = em.find(BookingMaster.class, bookingId);
        
        UserMaster u = em.find(UserMaster.class, userId);
        Collection<BookingMaster> userBookings = u.getBookingMasterCollection();
        
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrimId);
        Collection<BookingMaster> pilgrimBookings = p.getBookingMasterCollection();
        
        PilgrimTimeslotsDetails tsd = em.find(PilgrimTimeslotsDetails.class, timeslotsDetailsId);
        Collection<BookingMaster> tsdBookings = tsd.getBookingMasterCollection();
        
        PilgrimTickets t = em.find(PilgrimTickets.class, ticketId);
        Collection<BookingMaster> ticketBookings = t.getBookingMasterCollection();
        
        DiscountMaster d = em.find(DiscountMaster.class, discountId);
        Collection<BookingMaster> discountBookings = d.getBookingMasterCollection();
        
        if(userBookings.contains(b) && pilgrimBookings.contains(b) && tsdBookings.contains(b) && ticketBookings.contains(b) && discountBookings.contains(b)){
            userBookings.remove(b);
            u.setBookingMasterCollection(userBookings);
            
            pilgrimBookings.remove(b);
            p.setBookingMasterCollection(pilgrimBookings);
            
            tsdBookings.remove(b);
            tsd.setBookingMasterCollection(tsdBookings);
            
            ticketBookings.remove(b);
            t.setBookingMasterCollection(ticketBookings);
            
            discountBookings.remove(b);
            d.setBookingMasterCollection(discountBookings);
            
            em.remove(b);
        }
    }

    @Override
    public Collection<BookingMaster> getBookings() {
        Collection<BookingMaster> bookings = em.createNamedQuery("BookingMaster.findAll").getResultList();
        return bookings;
    }

    @Override
    public Collection<BookingMaster> getBookingsByPilgrim(PilgrimMaster pilgrim) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrim.getPilgrimId());
        Collection<BookingMaster> pilgrimBookings = p.getBookingMasterCollection();
        return pilgrimBookings;
    }

    @Override
    public Collection<BookingMaster> getBookingByUser(UserMaster user) {
        UserMaster u = em.find(UserMaster.class, user.getUserId());
        Collection<BookingMaster> userBookings = u.getBookingMasterCollection();
        return userBookings;
    }

    @Override
    public void addPayment(PaymentMaster payment, Integer userId, Integer pilgrimId, Integer bookingId) {
        UserMaster u = em.find(UserMaster.class, userId);
        Collection<PaymentMaster> userPayments = u.getPaymentMasterCollection();
        
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, pilgrimId);
        Collection<PaymentMaster> pilgrimPayments = pilgrim.getPaymentMasterCollection();
        
        BookingMaster b = em.find(BookingMaster.class, bookingId);
        Collection<PaymentMaster> bookingPayments = b.getPaymentMasterCollection();
        
        payment.setUser(u);
        payment.setPilgrim(pilgrim);
        payment.setBooking(b);
        
        userPayments.add(payment);
        u.setPaymentMasterCollection(userPayments);
        
        pilgrimPayments.add(payment);
        pilgrim.setPaymentMasterCollection(pilgrimPayments);
        
        bookingPayments.add(payment);
        b.setPaymentMasterCollection(bookingPayments);
        
        em.persist(payment);
        em.merge(u);
    }

    @Override
    public void updatePayment(PaymentMaster payment, Integer userId, Integer pilgrimId, Integer bookingId) {
        UserMaster u = em.find(UserMaster.class, userId);
        Collection<PaymentMaster> userPayments = u.getPaymentMasterCollection();
        
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, pilgrimId);
        Collection<PaymentMaster> pilgrimPayments = pilgrim.getPaymentMasterCollection();
        
        BookingMaster b = em.find(BookingMaster.class, bookingId);
        Collection<PaymentMaster> bookingPayments = b.getPaymentMasterCollection();
        
        payment.setUser(u);
        payment.setPilgrim(pilgrim);
        payment.setBooking(b);

        u.setPaymentMasterCollection(userPayments);
        pilgrim.setPaymentMasterCollection(pilgrimPayments);
        b.setPaymentMasterCollection(bookingPayments);
        
        em.merge(payment);
    }

    @Override
    public void removePayment(Integer paymentId, Integer userId, Integer pilgrimId, Integer bookingId) {
        PaymentMaster p = em.find(PaymentMaster.class, paymentId);
        
        UserMaster u = em.find(UserMaster.class, userId);
        Collection<PaymentMaster> userPayments = u.getPaymentMasterCollection();
        
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, pilgrimId);
        Collection<PaymentMaster> pilgrimPayments = pilgrim.getPaymentMasterCollection();
        
        BookingMaster b = em.find(BookingMaster.class, bookingId);
        Collection<PaymentMaster> bookingPayments = b.getPaymentMasterCollection();
        
        if(userPayments.contains(p) && pilgrimPayments.contains(p) && bookingPayments.contains(p)){
            userPayments.remove(p);
            u.setPaymentMasterCollection(userPayments);
            
            pilgrimPayments.remove(p);
            pilgrim.setPaymentMasterCollection(pilgrimPayments);
            
            bookingPayments.remove(p);
            b.setPaymentMasterCollection(bookingPayments);
            
            em.remove(p);
        }
    }

    @Override
    public Collection<PaymentMaster> getPayments() {
        Collection<PaymentMaster> payments = em.createNamedQuery("PaymentMaster.findAll").getResultList();
        return payments;
    }

    @Override
    public Collection<PaymentMaster> getPaymentsByUser(UserMaster user) {
        UserMaster u = em.find(UserMaster.class, user.getUserId());
        Collection<PaymentMaster> userPayments = u.getPaymentMasterCollection();
        return userPayments;
    }

    @Override
    public Collection<PaymentMaster> getPaymentsByPilgrim(PilgrimMaster pilgrim) {
        PilgrimMaster p = em.find(PilgrimMaster.class, pilgrim.getPilgrimId());
        Collection<PaymentMaster> pilgrimPayments = p.getPaymentMasterCollection();
        return pilgrimPayments;
    }

    @Override
    public Collection<PaymentMaster> getPaymentsByBooking(BookingMaster booking) {
        BookingMaster b = em.find(BookingMaster.class, booking.getBookingId());
        Collection<PaymentMaster> bookingPayments = b.getPaymentMasterCollection();
        return bookingPayments;
    }
}
