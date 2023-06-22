/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.pilgrim.ejb;

import com.pilgrim.entities.BookingMaster;
import com.pilgrim.entities.FeedbackMaster;
import com.pilgrim.entities.PaymentMaster;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Dell
 */
@Local
public interface CustomerBeanLocal {
    
    //operations for feedback_master
    public void addFeedback(FeedbackMaster feedback);
    public void updateFeedback(FeedbackMaster feedback);
    public void removeFeedback(Integer feedbackId);
    
    Collection<FeedbackMaster> getFeedbacks();
    Collection<FeedbackMaster> getFeedbacksByPilgrim(Integer pilgrimId);
    Collection<FeedbackMaster> getFeedbacksByUser(Integer userId);
    
    //operations for booking_master
    public void addBooking(BookingMaster booking);
    public void updateBooking(BookingMaster booking);
    public void removeBooking(Integer bookingId);
    
    Collection<BookingMaster> getBookings();
    Collection<BookingMaster> getBookingsByPilgrim(Integer pilgrimId);
    Collection<BookingMaster> getBookingByUser(Integer userId);
    
    //collections for payment_master
    public void addPayment(PaymentMaster payment);
    public void updatePayment(PaymentMaster payment);
    public void removePayment(Integer paymentId);
    
    Collection<PaymentMaster> getPayments();
    Collection<PaymentMaster> getPaymentsByUser(Integer userId);
    Collection<PaymentMaster> getPaymentsByPilgrim(Integer pilgrimId);
    Collection<PaymentMaster> getPaymentsByBooking(Integer bookingId);
    Float getPaymentRevenue();
}
