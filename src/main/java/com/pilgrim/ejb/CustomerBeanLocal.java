/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.pilgrim.ejb;

import com.pilgrim.entities.BookingMaster;
import com.pilgrim.entities.FeedbackMaster;
import com.pilgrim.entities.PaymentMaster;
import com.pilgrim.entities.PilgrimMaster;
import com.pilgrim.entities.UserMaster;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Dell
 */
@Local
public interface CustomerBeanLocal {
    
    //operations for feedback_master
    public void addFeedback(FeedbackMaster feedback, Integer pilgrimId, Integer userId);
    public void updateFeedback(FeedbackMaster feedback, Integer pilgrimId, Integer userId);
    public void removeFeedback(Integer feedbackId, Integer pilgrimId, Integer userId);
    
    Collection<FeedbackMaster> getFeedbacks();
    Collection<FeedbackMaster> getFeedbacksByPilgrim(PilgrimMaster pilgrim);
    Collection<FeedbackMaster> getFeedbacksByUser(UserMaster user);
    
    //operations for booking_master
    public void addBooking(BookingMaster booking, Integer userId, Integer pilgrimId, Integer timeslotsDetailsId, Integer ticketId, Integer discountId);
    public void updateBooking(BookingMaster booking, Integer userId, Integer pilgrimId, Integer timeslotsDetailsId, Integer ticketId, Integer discountId);
    public void removeBooking(Integer bookingId, Integer userId, Integer pilgrimId, Integer timeslotsDetailsId, Integer ticketId, Integer discountId);
    
    Collection<BookingMaster> getBookings();
    Collection<BookingMaster> getBookingsByPilgrim(PilgrimMaster pilgrim);
    Collection<BookingMaster> getBookingByUser(UserMaster user);
    
    //collections for payment_master
    public void addPayment(PaymentMaster payment, Integer userId, Integer pilgrimId, Integer bookingId);
    public void updatePayment(PaymentMaster payment, Integer userId, Integer pilgrimId, Integer bookingId);
    public void removePayment(Integer paymentId, Integer userId, Integer pilgrimId, Integer bookingId);
    
    Collection<PaymentMaster> getPayments();
    Collection<PaymentMaster> getPaymentsByUser(UserMaster user);
    Collection<PaymentMaster> getPaymentsByPilgrim(PilgrimMaster pilgrim);
    Collection<PaymentMaster> getPaymentsByBooking(BookingMaster booking);
}
