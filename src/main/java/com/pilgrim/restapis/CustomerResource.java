/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.pilgrim.restapis;

import com.pilgrim.ejb.CustomerBeanLocal;
import com.pilgrim.entities.BookingMaster;
import com.pilgrim.entities.FeedbackMaster;
import com.pilgrim.entities.PaymentMaster;
import com.pilgrim.entities.PilgrimMaster;
import com.pilgrim.entities.UserMaster;
import com.pilgrim.helper.Request;
import com.pilgrim.helper.Response;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;

/**
 * REST Web Service
 *
 * @author Dell
 */
@Path("customer")
@RequestScoped
public class CustomerResource {

    @EJB
    CustomerBeanLocal customerBeanLocal;

    public CustomerResource() {
    }

    @GET
    @Path("feedbacks")
    @Produces("application/json")
    public Response<Collection<FeedbackMaster>> getFeedbacks() {
        Response response = new Response();
        try {
            response.setResult(customerBeanLocal.getFeedbacks());
            response.setMessage("Feedbacks fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Feedbacks!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("feedbacks/getByPilgrim")
    @Produces("application/json")
    @Consumes("application/json")
    public Response<Collection<FeedbackMaster>> getFeedbacksByPilgrim(Request<PilgrimMaster> requestbody) {
        Response response = new Response();
        try {
            PilgrimMaster pilgrim = requestbody.getData();
            response.setResult(customerBeanLocal.getFeedbacksByPilgrim(pilgrim.getPilgrimId()));
            response.setMessage("Feedbacks fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Feedbacks!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("feedbacks/getByUser")
    @Produces("application/json")
    @Consumes("application/json")
    public Response<Collection<FeedbackMaster>> getFeedbacksByUser(Request<UserMaster> requestbody) {
        Response response = new Response();
        try {
            UserMaster user = requestbody.getData();
            response.setResult(customerBeanLocal.getFeedbacksByUser(user.getUserId()));
            response.setMessage("Feedbacks fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Feedbacks!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("feedbacks/add")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addFeedback(Request<FeedbackMaster> requestbody) {
        Response response = new Response();
        try {
            FeedbackMaster feedback = requestbody.getData();
            customerBeanLocal.addFeedback(feedback);
            response.setMessage("Feedback added successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while adding Feedback!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("feedbacks/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateFeedback(Request<FeedbackMaster> requestbody) {
        Response response = new Response();
        try {
            FeedbackMaster feedback = requestbody.getData();
            customerBeanLocal.updateFeedback(feedback);
            response.setMessage("Feedback updated successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while updating Feedback!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("feedbacks/delete")
    @Consumes("application/json")
    @Produces("application/json")
    public Response removeFeedback(Request<FeedbackMaster> requestbody) {
        Response response = new Response();
        try {
            FeedbackMaster feedback = requestbody.getData();
            customerBeanLocal.removeFeedback(feedback.getFeedbackId());
            response.setMessage("Feedback deleted successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while deleting Feedback!");
            response.setStatus(false);
        }
        return response;
    }

    @GET
    @Path("bookings")
    @Produces("application/json")
    public Response<Collection<BookingMaster>> getBookings() {
        Response response = new Response();
        try {
            response.setResult(customerBeanLocal.getBookings());
            response.setMessage("Bookings fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Bookings!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("bookings/getByPilgrim")
    @Produces("application/json")
    @Consumes("application/json")
    public Response<Collection<BookingMaster>> getBookingsByPilgrim(Request<PilgrimMaster> requestbody) {
        Response response = new Response();
        try {
            PilgrimMaster pilgrim = requestbody.getData();
            response.setResult(customerBeanLocal.getBookingsByPilgrim(pilgrim.getPilgrimId()));
            response.setMessage("Bookings fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Bookings!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("bookings/getByUser")
    @Produces("application/json")
    @Consumes("application/json")
    public Response<Collection<BookingMaster>> getBookingByUser(Request<UserMaster> requestbody) {
        Response response = new Response();
        try {
            UserMaster user = requestbody.getData();
            response.setResult(customerBeanLocal.getBookingByUser(user.getUserId()));
            response.setMessage("Bookings fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Bookings!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("bookings/add")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addBooking(Request<BookingMaster> requestbody) {
        Response response = new Response();
        try {
            BookingMaster booking = requestbody.getData();
            customerBeanLocal.addBooking(booking);
            response.setMessage("Booking added successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while adding Booking!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("bookings/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateBooking(Request<BookingMaster> requestbody) {
        Response response = new Response();
        try {
            BookingMaster booking = requestbody.getData();
            customerBeanLocal.updateBooking(booking);
            response.setMessage("Booking updated successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while updating Booking!");
            response.setStatus(false);
        }
        return response;
    }

    @DELETE
    @Path("bookings/delete")
    @Consumes("application/json")
    @Produces("application/json")
    public Response removeBooking(Request<BookingMaster> requestbody) {
        Response response = new Response();
        try {
            BookingMaster booking = requestbody.getData();
            customerBeanLocal.removeBooking(booking.getBookingId());
            response.setMessage("Booking deleted successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while deleting Booking!");
            response.setStatus(false);
        }
        return response;
    }

    @GET
    @Path("payments")
    @Produces("application/json")
    public Response<Collection<PaymentMaster>> getPayments() {
        Response response = new Response();
        try {
            response.setResult(customerBeanLocal.getPayments());
            response.setMessage("Payments fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Payments!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("payments/getByUser")
    @Produces("application/json")
    @Consumes("application/json")
    public Response<Collection<PaymentMaster>> getPaymentsByUser(Request<UserMaster> requestbody) {
        Response response = new Response();
        try {
            UserMaster user = requestbody.getData();
            response.setResult(customerBeanLocal.getPaymentsByUser(user.getUserId()));
            response.setMessage("Payments fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Payments!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("payments/getByPilgrim")
    @Produces("application/json")
    @Consumes("application/json")
    public Response<Collection<PaymentMaster>> getPaymentsByPilgrim(Request<PilgrimMaster> requestbody) {
        Response response = new Response();
        try {
            PilgrimMaster pilgrim = requestbody.getData();
            response.setResult(customerBeanLocal.getPaymentsByPilgrim(pilgrim.getPilgrimId()));
            response.setMessage("Payments fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Payments!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("payments/getByBooking")
    @Produces("application/json")
    @Consumes("application/json")
    public Response<Collection<PaymentMaster>> getPaymentsByBooking(Request<BookingMaster> requestbody) {
        Response response = new Response();
        try {
            BookingMaster booking = requestbody.getData();
            response.setResult(customerBeanLocal.getPaymentsByBooking(booking.getBookingId()));
            response.setMessage("Payments fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Payments!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("payments/add")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addPayment(Request<PaymentMaster> requestbody) {
        Response response = new Response();
        try {
            PaymentMaster payment = requestbody.getData();
            customerBeanLocal.addPayment(payment);
            response.setMessage("Payment added successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while adding Payment!");
            response.setStatus(false);
        }
        return response;
    }
    
    @POST
    @Path("payments/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updatePayment(Request<PaymentMaster> requestbody) {
        Response response = new Response();
        try {
            PaymentMaster payment = requestbody.getData();
            customerBeanLocal.updatePayment(payment);
            response.setMessage("Payment updated successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while updating Payment!");
            response.setStatus(false);
        }
        return response;
    }
    
    @POST
    @Path("payments/delete")
    @Consumes("application/json")
    @Produces("application/json")
    public Response removePayment(Request<PaymentMaster> requestbody) {
        Response response = new Response();
        try {
            PaymentMaster payment = requestbody.getData();
            customerBeanLocal.removePayment(payment.getPaymentId());
            response.setMessage("Payment deleted successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while deleting Payment!");
            response.setStatus(false);
        }
        return response;
    }
}
