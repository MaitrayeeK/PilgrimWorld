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
import com.pilgrim.entities.PilgrimRooms;
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
    public void addFeedback(FeedbackMaster feedback) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, feedback.getPilgrim().getPilgrimId());
        Collection<FeedbackMaster> pilgrimFeedbacks = pilgrim.getFeedbackMasterCollection();
        
        UserMaster user = em.find(UserMaster.class, feedback.getUser().getUserId());
        Collection<FeedbackMaster> userFeedbacks = user.getFeedbackMasterCollection();
        
        feedback.setPilgrim(pilgrim);
        feedback.setUser(user);
        
        pilgrimFeedbacks.add(feedback);
        pilgrim.setFeedbackMasterCollection(pilgrimFeedbacks);
        
        userFeedbacks.add(feedback);
        user.setFeedbackMasterCollection(userFeedbacks);
        
        em.persist(feedback);
        em.merge(user);
    }

    @Override
    public void updateFeedback(FeedbackMaster feedback) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, feedback.getPilgrim().getPilgrimId());
        UserMaster user = em.find(UserMaster.class, feedback.getUser().getUserId());
        
        feedback.setPilgrim(pilgrim);
        feedback.setUser(user);
        
        em.merge(feedback);
    }

    @Override
    public void removeFeedback(Integer feedbackId) {
        FeedbackMaster feedback = em.find(FeedbackMaster.class, feedbackId);
        
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, feedback.getPilgrim().getPilgrimId());
        Collection<FeedbackMaster> pilgrimFeedbacks = pilgrim.getFeedbackMasterCollection();
        
        UserMaster user = em.find(UserMaster.class, feedback.getUser().getUserId());
        Collection<FeedbackMaster> userFeedbacks = user.getFeedbackMasterCollection();

        if(pilgrimFeedbacks.contains(feedback) && userFeedbacks.contains(feedback)){
            pilgrimFeedbacks.remove(feedback);
            userFeedbacks.remove(feedback);
            em.remove(feedback);
        }
    }
    
    @Override
    public Collection<FeedbackMaster> getFeedbacks() {
        Collection<FeedbackMaster> feedbacks = em.createNamedQuery("FeedbackMaster.findAll").getResultList();
        return feedbacks;
    }

    @Override
    public Collection<FeedbackMaster> getFeedbacksByPilgrim(Integer pilgrimId) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, pilgrimId);
        Collection<FeedbackMaster> pilgrimFeedbacks = pilgrim.getFeedbackMasterCollection();
        return pilgrimFeedbacks;
    }

    @Override
    public Collection<FeedbackMaster> getFeedbacksByUser(Integer userId) {
        UserMaster user = em.find(UserMaster.class, userId);
        Collection<FeedbackMaster> userFeedbacks = user.getFeedbackMasterCollection();
        return userFeedbacks;
    }

    @Override
    public void addBooking(BookingMaster booking) {
        UserMaster user = em.find(UserMaster.class, booking.getUser().getUserId());
        Collection<BookingMaster> userBookings = user.getBookingMasterCollection();
        
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, booking.getPilgrim().getPilgrimId());
        Collection<BookingMaster> pilgrimBookings = pilgrim.getBookingMasterCollection();
        
        PilgrimTimeslotsDetails timeslotsdetails = em.find(PilgrimTimeslotsDetails.class, booking.getTimeslotsDetails().getTimeslotsDetailsId());
        Collection<BookingMaster> tsdBookings = timeslotsdetails.getBookingMasterCollection();
        
        PilgrimTickets pticket = em.find(PilgrimTickets.class, booking.getTicket().getTicketId());
        Collection<BookingMaster> ticketBookings = pticket.getBookingMasterCollection();
        
        DiscountMaster discount = em.find(DiscountMaster.class, booking.getDiscount().getDiscountId());
        Collection<BookingMaster> discountBookings = discount.getBookingMasterCollection();
        
        PilgrimRooms rooms = em.find(PilgrimRooms.class, booking.getPilgrimRoom().getPilgrimRoomId());
        Collection<BookingMaster> roomsBooking = rooms.getBookingMasterCollection();
        
        booking.setUser(user);
        booking.setPilgrim(pilgrim);
        booking.setTimeslotsDetails(timeslotsdetails);
        booking.setTicket(pticket);
        booking.setDiscount(discount);
        booking.setPilgrimRoom(rooms);
        
        userBookings.add(booking);
        user.setBookingMasterCollection(userBookings);
        
        pilgrimBookings.add(booking);
        pilgrim.setBookingMasterCollection(pilgrimBookings);
        
        tsdBookings.add(booking);
        timeslotsdetails.setBookingMasterCollection(tsdBookings);
        
        ticketBookings.add(booking);
        pticket.setBookingMasterCollection(ticketBookings);
        
        discountBookings.add(booking);
        discount.setBookingMasterCollection(discountBookings);
        
        roomsBooking.add(booking);
        rooms.setBookingMasterCollection(roomsBooking);
        
        em.persist(booking);
        em.merge(user);
    }

    @Override
    public void updateBooking(BookingMaster booking) {
        UserMaster user = em.find(UserMaster.class, booking.getUser().getUserId());
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, booking.getPilgrim().getPilgrimId());
        PilgrimTimeslotsDetails timeslotsdetails = em.find(PilgrimTimeslotsDetails.class, booking.getTimeslotsDetails().getTimeslotsDetailsId());
        PilgrimTickets pticket = em.find(PilgrimTickets.class, booking.getTicket().getTicketId());
        DiscountMaster discount = em.find(DiscountMaster.class, booking.getDiscount().getDiscountId());
        PilgrimRooms rooms = em.find(PilgrimRooms.class, booking.getPilgrimRoom().getPilgrimRoomId());
        
        booking.setUser(user);
        booking.setPilgrim(pilgrim);
        booking.setTimeslotsDetails(timeslotsdetails);
        booking.setTicket(pticket);
        booking.setDiscount(discount);
        booking.setPilgrimRoom(rooms);
        
        em.merge(booking);
    }

    @Override
    public void removeBooking(Integer bookingId) {
        BookingMaster booking = em.find(BookingMaster.class, bookingId);
        
        UserMaster user = em.find(UserMaster.class, booking.getUser().getUserId());
        Collection<BookingMaster> userBookings = user.getBookingMasterCollection();
        
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, booking.getPilgrim().getPilgrimId());
        Collection<BookingMaster> pilgrimBookings = pilgrim.getBookingMasterCollection();
        
        PilgrimTimeslotsDetails timeslotsdetails = em.find(PilgrimTimeslotsDetails.class, booking.getTimeslotsDetails().getTimeslotsDetailsId());
        Collection<BookingMaster> tsdBookings = timeslotsdetails.getBookingMasterCollection();
        
        PilgrimTickets pticket = em.find(PilgrimTickets.class, booking.getTicket().getTicketId());
        Collection<BookingMaster> ticketBookings = pticket.getBookingMasterCollection();
        
        DiscountMaster discount = em.find(DiscountMaster.class, booking.getDiscount().getDiscountId());
        Collection<BookingMaster> discountBookings = discount.getBookingMasterCollection();
        
        PilgrimRooms rooms = em.find(PilgrimRooms.class, booking.getPilgrimRoom().getPilgrimRoomId());
        Collection<BookingMaster> roomsBooking = rooms.getBookingMasterCollection();
        
        if(userBookings.contains(booking) && pilgrimBookings.contains(booking) && tsdBookings.contains(booking) && ticketBookings.contains(booking) && discountBookings.contains(booking) && roomsBooking.contains(booking)){
            userBookings.remove(booking);
            pilgrimBookings.remove(booking);
            tsdBookings.remove(booking);
            ticketBookings.remove(booking);
            discountBookings.remove(booking);
            roomsBooking.remove(booking);
            
            em.remove(booking);
        }
    }

    @Override
    public Collection<BookingMaster> getBookings() {
        Collection<BookingMaster> bookings = em.createNamedQuery("BookingMaster.findAll").getResultList();
        return bookings;
    }

    @Override
    public Collection<BookingMaster> getBookingsByPilgrim(Integer pilgrimId) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, pilgrimId);
        Collection<BookingMaster> pilgrimBookings = pilgrim.getBookingMasterCollection();
        return pilgrimBookings;
    }

    @Override
    public Collection<BookingMaster> getBookingByUser(Integer userId) {
        UserMaster user = em.find(UserMaster.class, userId);
        Collection<BookingMaster> userBookings = user.getBookingMasterCollection();
        return userBookings;
    }

    @Override
    public void addPayment(PaymentMaster payment) {
        UserMaster user = em.find(UserMaster.class, payment.getUser().getUserId());
        Collection<PaymentMaster> userPayments = user.getPaymentMasterCollection();
        
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, payment.getPilgrim().getPilgrimId());
        Collection<PaymentMaster> pilgrimPayments = pilgrim.getPaymentMasterCollection();
        
        BookingMaster booking = em.find(BookingMaster.class, payment.getBooking().getBookingId());
        Collection<PaymentMaster> bookingPayments = booking.getPaymentMasterCollection();
        
        payment.setUser(user);
        payment.setPilgrim(pilgrim);
        payment.setBooking(booking);
        
        userPayments.add(payment);
        user.setPaymentMasterCollection(userPayments);
        
        pilgrimPayments.add(payment);
        pilgrim.setPaymentMasterCollection(pilgrimPayments);
        
        bookingPayments.add(payment);
        booking.setPaymentMasterCollection(bookingPayments);
        
        em.persist(payment);
        em.merge(user);
    }

    @Override
    public void updatePayment(PaymentMaster payment) {
        UserMaster user = em.find(UserMaster.class, payment.getUser().getUserId());
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, payment.getPilgrim().getPilgrimId());
        BookingMaster booking = em.find(BookingMaster.class, payment.getBooking().getBookingId());
        
        payment.setUser(user);
        payment.setPilgrim(pilgrim);
        payment.setBooking(booking);
        
        em.merge(payment);
    }

    @Override
    public void removePayment(Integer paymentId) {
        PaymentMaster payment = em.find(PaymentMaster.class, paymentId);
        
        UserMaster user = em.find(UserMaster.class, payment.getUser().getUserId());
        Collection<PaymentMaster> userPayments = user.getPaymentMasterCollection();
        
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, payment.getPilgrim().getPilgrimId());
        Collection<PaymentMaster> pilgrimPayments = pilgrim.getPaymentMasterCollection();
        
        BookingMaster booking = em.find(BookingMaster.class, payment.getBooking().getBookingId());
        Collection<PaymentMaster> bookingPayments = booking.getPaymentMasterCollection();
        
        if(userPayments.contains(payment) && pilgrimPayments.contains(payment) && bookingPayments.contains(payment)){
            userPayments.remove(payment);
            pilgrimPayments.remove(payment);
            bookingPayments.remove(payment);
            
            em.remove(payment);
        }
    }

    @Override
    public Collection<PaymentMaster> getPayments() {
        Collection<PaymentMaster> payments = em.createNamedQuery("PaymentMaster.findAll").getResultList();
        return payments;
    }

    @Override
    public Collection<PaymentMaster> getPaymentsByUser(Integer userId) {
        UserMaster user = em.find(UserMaster.class, userId);
        Collection<PaymentMaster> userPayments = user.getPaymentMasterCollection();
        return userPayments;
    }

    @Override
    public Collection<PaymentMaster> getPaymentsByPilgrim(Integer pilgrimId) {
        PilgrimMaster pilgrim = em.find(PilgrimMaster.class, pilgrimId);
        Collection<PaymentMaster> pilgrimPayments = pilgrim.getPaymentMasterCollection();
        return pilgrimPayments;
    }

    @Override
    public Collection<PaymentMaster> getPaymentsByBooking(Integer bookingId) {
        BookingMaster booking = em.find(BookingMaster.class, bookingId);
        Collection<PaymentMaster> bookingPayments = booking.getPaymentMasterCollection();
        return bookingPayments;
    }
}
