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
import javax.ws.rs.PathParam;

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

    @GET
    @Path("feedbacks/getByPilgrim/{pilgrimid}")
    @Produces("application/json")
    public Response<Collection<FeedbackMaster>> getFeedbacksByPilgrim(@PathParam("pilgrimid") Integer pilgrimid) {
        Response response = new Response();
        try {
            response.setResult(customerBeanLocal.getFeedbacksByPilgrim(pilgrimid));
            response.setMessage("Feedbacks fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Feedbacks!");
            response.setStatus(false);
        }
        return response;
    }

    @GET
    @Path("feedbacks/getByUser/{userid}")
    @Produces("application/json")
    public Response<Collection<FeedbackMaster>> getFeedbacksByUser(@PathParam("userid") Integer userid) {
        Response response = new Response();
        try {
            response.setResult(customerBeanLocal.getFeedbacksByUser(userid));
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

    @DELETE
    @Path("feedbacks/delete/{feedbackid}")
    @Produces("application/json")
    public Response removeFeedback(@PathParam("feedbackid") Integer feedbackid) {
        Response response = new Response();
        try {
            customerBeanLocal.removeFeedback(feedbackid);
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

    @GET
    @Path("bookings/getByPilgrim/{pilgrimid}")
    @Produces("application/json")
    public Response<Collection<BookingMaster>> getBookingsByPilgrim(@PathParam("pilgrimid") Integer pilgrimid) {
        Response response = new Response();
        try {
            response.setResult(customerBeanLocal.getBookingsByPilgrim(pilgrimid));
            response.setMessage("Bookings fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Bookings!");
            response.setStatus(false);
        }
        return response;
    }

    @GET
    @Path("bookings/getByUser/{userid}")
    @Produces("application/json")
    public Response<Collection<BookingMaster>> getBookingByUser(@PathParam("userid") Integer userid) {
        Response response = new Response();
        try {
            response.setResult(customerBeanLocal.getBookingByUser(userid));
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
    @Path("bookings/delete/{bookingid}")
    @Produces("application/json")
    public Response removeBooking(@PathParam("bookingid") Integer bookingid) {
        Response response = new Response();
        try {
            customerBeanLocal.removeBooking(bookingid);
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
