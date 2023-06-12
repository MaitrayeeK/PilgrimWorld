/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.pilgrim.restapis;

import com.pilgrim.ejb.ClientBeanLocal;
import com.pilgrim.entities.AdvertisementMaster;
import com.pilgrim.entities.DiscountMaster;
import com.pilgrim.entities.PilgrimImages;
import com.pilgrim.entities.PilgrimMaster;
import com.pilgrim.entities.PilgrimRooms;
import com.pilgrim.entities.PilgrimTickets;
import com.pilgrim.entities.PilgrimTimeslots;
import com.pilgrim.entities.PilgrimTimeslotsDetails;
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
@Path("client")
@RequestScoped
public class ClientResource {

    @EJB
    ClientBeanLocal clientBeanLocal;

    public ClientResource() {
    }

    @GET
    @Path("pilgrims")
    @Produces("application/json")
    public Response<Collection<PilgrimMaster>> getPilgrims() {
        Response response = new Response();
        try {
            response.setResult(clientBeanLocal.getPilgrims());
            response.setMessage("Pilgrims fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching pilgrims!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("pilgrims/add")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addPilgrim(Request<PilgrimMaster> requestbody) {
        Response response = new Response();
        try {
            PilgrimMaster pilgrim = requestbody.getData();
            clientBeanLocal.addPilgrim(pilgrim);
            response.setMessage("Pilgrim added successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while adding pilgrim!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("pilgrims/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updatePilgrim(Request<PilgrimMaster> requestbody) {
        Response response = new Response();
        try {
            PilgrimMaster pilgrim = requestbody.getData();
            clientBeanLocal.updatePilgrim(pilgrim);
            response.setMessage("Pilgrim updated successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while updating pilgrim!");
            response.setStatus(false);
        }
        return response;
    }

    @DELETE
    @Path("pilgrims/delete/{pilgrimid}")
    @Produces("application/json")
    public Response removePilgrim(@PathParam("pilgrimid") Integer pilgrimid) {
        Response response = new Response();
        try {
            clientBeanLocal.removePilgrim(pilgrimid);
            response.setMessage("Pilgrim deleted successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while deleting pilgrim!");
            response.setStatus(false);
        }
        return response;
    }
    
    @GET
    @Path("pilgrims/{pilgrimid}")
    @Produces("application/json")
    public Response<Collection<PilgrimMaster>> getPilgrimsById(@PathParam("pilgrimid") Integer pilgrimid) {
        Response response = new Response();
        try {
            response.setResult(clientBeanLocal.getPilgrimById(pilgrimid));
            response.setMessage("Pilgrims fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Pilgrims!");
            response.setStatus(false);
        }
        return response;
    }
    
    @GET
    @Path("pilgrims/getByState/{stateid}")
    @Produces("application/json")
    public Response<Collection<PilgrimMaster>> getPilgrimsByState(@PathParam("stateid") Integer stateid) {
        Response response = new Response();
        try {
            response.setResult(clientBeanLocal.getPilgrimsByState(stateid));
            response.setMessage("Pilgrims fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Pilgrims!");
            response.setStatus(false);
        }
        return response;
    }
    
    @GET
    @Path("pilgrims/getByCity/{cityid}")
    @Produces("application/json")
    public Response<Collection<PilgrimMaster>> getPilgrimsByCity(@PathParam("cityid") Integer cityid) {
        Response response = new Response();
        try {
            response.setResult(clientBeanLocal.getPilgrimsByCity(cityid));
            response.setMessage("Pilgrims fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Pilgrims!");
            response.setStatus(false);
        }
        return response;
    }
    
    @GET
    @Path("pilgrims/getByStateCity/{stateid}/{cityid}")
    @Produces("application/json")
    public Response<Collection<PilgrimMaster>> getPilgrimsByStateCity(@PathParam("stateid") Integer stateid, @PathParam("cityid") Integer cityid) {
        Response response = new Response();
        try {
            response.setResult(clientBeanLocal.getPilgrimsByStateCity(stateid, cityid));
            response.setMessage("Pilgrims fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Pilgrims!");
            response.setStatus(false);
        }
        return response;
    }

    @GET
    @Path("pilgrimImages/{pilgrimid}")
    @Produces("application/json")
    public Response<Collection<PilgrimImages>> getPilgrimImages(@PathParam("pilgrimid") Integer pilgrimid) {
        Response response = new Response();
        try {
            response.setResult(clientBeanLocal.getPilgrimImages(pilgrimid));
            response.setMessage("Pilgrim Images fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Pilgrim Images!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("pilgrimImages/add")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addPilgrimImages(Request<PilgrimImages> requestbody) {
        Response response = new Response();
        try {
            PilgrimImages pilgrimImages = requestbody.getData();
            clientBeanLocal.addPilgrimImages(pilgrimImages);
            response.setMessage("Pilgrim Images added successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while adding Pilgrim Images!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("pilgrimImages/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updatePilgrimImages(Request<PilgrimImages> requestbody) {
        Response response = new Response();
        try {
            PilgrimImages pilgrimImages = requestbody.getData();
            clientBeanLocal.updatePilgrimImages(pilgrimImages);
            response.setMessage("Pilgrim Images updated successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while updating Pilgrim Images!");
            response.setStatus(false);
        }
        return response;
    }

    @DELETE
    @Path("pilgrimImages/delete/{pimagesid}")
    @Produces("application/json")
    public Response removePilgrimImages(@PathParam("pimagesid") Integer pimagesid) {
        Response response = new Response();
        try {
            clientBeanLocal.removePilgrim(pimagesid);
            response.setMessage("Pilgrim Images deleted successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while deleting Pilgrim Images!");
            response.setStatus(false);
        }
        return response;
    }

    @GET
    @Path("pilgrimRooms/{pilgrimid}")
    @Produces("application/json")
    public Response<Collection<PilgrimRooms>> getPilgrimRooms(@PathParam("pilgrimid") Integer pilgrimid) {
        Response response = new Response();
        try {
            response.setResult(clientBeanLocal.getPilgrimRooms(pilgrimid));
            response.setMessage("Pilgrim Rooms fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Pilgrim Rooms!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("pilgrimRooms/add")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addPilgrimRooms(Request<PilgrimRooms> requestbody) {
        Response response = new Response();
        try {
            PilgrimRooms pilgrimRooms = requestbody.getData();
            clientBeanLocal.addPilgrimRooms(pilgrimRooms);
            response.setMessage("Pilgrim Rooms added successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while adding Pilgrim Rooms!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("pilgrimRooms/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updatePilgrimRooms(Request<PilgrimRooms> requestbody) {
        Response response = new Response();
        try {
            PilgrimRooms pilgrimRooms = requestbody.getData();
            clientBeanLocal.updatePilgrimRooms(pilgrimRooms);
            response.setMessage("Pilgrim Rooms updated successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while updating Pilgrim Rooms!");
            response.setStatus(false);
        }
        return response;
    }

    @DELETE
    @Path("pilgrimRooms/delete/{proomsid}")
    @Produces("application/json")
    public Response removePilgrimRooms(@PathParam("proomsid") Integer proomsid) {
        Response response = new Response();
        try {
            clientBeanLocal.removePilgrimRooms(proomsid);
            response.setMessage("Pilgrim Rooms deleted successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while deleting Pilgrim Rooms!");
            response.setStatus(false);
        }
        return response;
    }

    @GET
    @Path("pilgrimTimeslots/{pilgrimid}")
    @Produces("application/json")
    public Response<Collection<PilgrimTimeslots>> getPilgrimTimeslots(@PathParam("pilgrimid") Integer pilgrimid) {
        Response response = new Response();
        try {
            response.setResult(clientBeanLocal.getPilgrimTimeslots(pilgrimid));
            response.setMessage("Pilgrim Timeslots fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Pilgrim Timeslots!");
            response.setStatus(false);
        }
        return response;
    }
    
    @POST
    @Path("pilgrimTimeslots/add")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addPilgrimTimeslots(Request<PilgrimTimeslots> requestbody) {
        Response response = new Response();
        try {
            PilgrimTimeslots pilgrimTimeslots = requestbody.getData();
            clientBeanLocal.addPilgrimTimeslots(pilgrimTimeslots);
            response.setMessage("Pilgrim Timeslots added successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while adding Pilgrim Timeslots!");
            response.setStatus(false);
        }
        return response;
    }
    
    @POST
    @Path("pilgrimTimeslots/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updatePilgrimTimeslots(Request<PilgrimTimeslots> requestbody) {
        Response response = new Response();
        try {
            PilgrimTimeslots pilgrimTimeslots = requestbody.getData();
            clientBeanLocal.updatePilgrimTimeslots(pilgrimTimeslots);
            response.setMessage("Pilgrim Timeslots updated successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while updating Pilgrim Timeslots!");
            response.setStatus(false);
        }
        return response;
    }
    
    @DELETE
    @Path("pilgrimTimeslots/delete/{ptimeslotsid}")
    @Produces("application/json")
    public Response removePilgrimTimeslots(@PathParam("ptimeslotsid") Integer ptimeslotsid) {
        Response response = new Response();
        try {
            clientBeanLocal.removePilgrimTimeslots(ptimeslotsid);
            response.setMessage("Pilgrim Timeslots deleted successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while deleting Pilgrim Timeslots!");
            response.setStatus(false);
        }
        return response;
    }
    
    @GET
    @Path("pilgrimTimeslotsDetails/{ptimeslotsid}")
    @Produces("application/json")
    public Response<Collection<PilgrimTimeslotsDetails>> getPilgrimTimeslotsDetails(@PathParam("ptimeslotsid") Integer ptimeslotsid) {
        Response response = new Response();
        try {
            response.setResult(clientBeanLocal.getPilgrimTimeslotsDetails(ptimeslotsid));
            response.setMessage("Pilgrim Timeslots Details fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Pilgrim Timeslots Details!");
            response.setStatus(false);
        }
        return response;
    }
    
    @POST
    @Path("pilgrimTimeslotsDetails/add")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addPilgrimTimeslotsDetails(Request<PilgrimTimeslotsDetails> requestbody) {
        Response response = new Response();
        try {
            PilgrimTimeslotsDetails pilgrimTimeslotsDetails = requestbody.getData();
            clientBeanLocal.addPilgrimTimeslotsDetails(pilgrimTimeslotsDetails);
            response.setMessage("Pilgrim Timeslots Details added successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while adding Pilgrim Timeslots Details!");
            response.setStatus(false);
        }
        return response;
    }
    
    @POST
    @Path("pilgrimTimeslotsDetails/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updatepilgrimTimeslotsDetails(Request<PilgrimTimeslotsDetails> requestbody) {
        Response response = new Response();
        try {
            PilgrimTimeslotsDetails pilgrimTimeSlotsDetails = requestbody.getData();
            clientBeanLocal.updatepilgrimTimeslotsDetails(pilgrimTimeSlotsDetails);
            response.setMessage("Pilgrim Timeslots Details updated successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while updating Pilgrim Timeslots Details!");
            response.setStatus(false);
        }
        return response;
    }
    
    @DELETE
    @Path("pilgrimTimeslotsDetails/delete/{ptimeslotsdetailsid}")
    @Produces("application/json")
    public Response removePilgrimTimeslotsDetails(@PathParam("ptimeslotsdetailsid") Integer ptimeslotsdetailsid) {
        Response response = new Response();
        try {
            clientBeanLocal.removePilgrimTimeslotsDetails(ptimeslotsdetailsid);
            response.setMessage("Pilgrim Timeslots Details deleted successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while deleting Pilgrim Timeslots Details!");
            response.setStatus(false);
        }
        return response;
    }
    
    @GET
    @Path("discounts")
    @Produces("application/json")
    public Response<Collection<DiscountMaster>> getDiscounts() {
        Response response = new Response();
        try {
            response.setResult(clientBeanLocal.getDiscounts());
            response.setMessage("Discounts fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Discounts!");
            response.setStatus(false);
        }
        return response;
    }
    
    @POST
    @Path("discounts/add")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addDiscount(Request<DiscountMaster> requestbody) {
        Response response = new Response();
        try {
            DiscountMaster discount = requestbody.getData();
            clientBeanLocal.addDiscount(discount);
            response.setMessage("Discount added successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while adding Discount!");
            response.setStatus(false);
        }
        return response;
    }
    
    @POST
    @Path("discounts/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateDiscount(Request<DiscountMaster> requestbody) {
        Response response = new Response();
        try {
            DiscountMaster discount = requestbody.getData();
            clientBeanLocal.updateDiscount(discount);
            response.setMessage("Discount updated successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while updating Discount!");
            response.setStatus(false);
        }
        return response;
    }
    
    @DELETE
    @Path("discounts/delete/{discountid}")
    @Produces("application/json")
    public Response removeDiscount(@PathParam("discountid") Integer discountid) {
        Response response = new Response();
        try {
            clientBeanLocal.removeDiscount(discountid);
            response.setMessage("Discount deleted successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while deleting Discount!");
            response.setStatus(false);
        }
        return response;
    }
    
    @GET
    @Path("pilgrimTickets/{pilgrimid}")
    @Produces("application/json")
    public Response<Collection<PilgrimTickets>> getTicketsByPilgrim(@PathParam("pilgrimid") Integer pilgrimid) {
        Response response = new Response();
        try {
            response.setResult(clientBeanLocal.getTicketsByPilgrim(pilgrimid));
            response.setMessage("Pilgrim Tickets fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Pilgrim Tickets!");
            response.setStatus(false);
        }
        return response;
    }
    
    @GET
    @Path("pilgrimTickets/getByPTimeSlotsDetails/{ptimeslotsdetailsid}")
    @Produces("application/json")
    public Response<PilgrimTickets> getTicketsByPTimeSlotsDetails(@PathParam("ptimeslotsdetailsid") Integer ptimeslotsdetailsid) {
        Response response = new Response();
        try {
            response.setResult(clientBeanLocal.getTicketsByPTimeSlotsDetails(ptimeslotsdetailsid));
            response.setMessage("Pilgrim Tickets fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Pilgrim Tickets!");
            response.setStatus(false);
        }
        return response;
    }
    
    @POST
    @Path("pilgrimTickets/add")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addPilgrimTicket(Request<PilgrimTickets> requestbody) {
        Response response = new Response();
        try {
            PilgrimTickets pilgrimTickets = requestbody.getData();
            clientBeanLocal.addPilgrimTicket(pilgrimTickets);
            response.setMessage("Pilgrim Tickets added successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while adding Pilgrim Tickets!");
            response.setStatus(false);
        }
        return response;
    }
    
    @POST
    @Path("pilgrimTickets/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updatePilgrimTicket(Request<PilgrimTickets> requestbody) {
        Response response = new Response();
        try {
            PilgrimTickets pilgrimTickets = requestbody.getData();
            clientBeanLocal.updatePilgrimTicket(pilgrimTickets);
            response.setMessage("Pilgrim Tickets updated successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while updating Pilgrim Tickets!");
            response.setStatus(false);
        }
        return response;
    }
    
    @DELETE
    @Path("pilgrimTickets/delete/{pticketid}")
    @Produces("application/json")
    public Response removePilgrimTicket(@PathParam("pticketid") Integer pticketid) {
        Response response = new Response();
        try {
            clientBeanLocal.removePilgrimTicket(pticketid);
            response.setMessage("Pilgrim Tickets deleted successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while deleted Pilgrim Tickets!");
            response.setStatus(false);
        }
        return response;
    }
    
    @GET
    @Path("advertisements")
    @Produces("application/json")
    public Response<Collection<AdvertisementMaster>> getAdvertisements() {
        Response response = new Response();
        try {
            response.setResult(clientBeanLocal.getAdvertisements());
            response.setMessage("Advertisements fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Advertisements!");
            response.setStatus(false);
        }
        return response;
    }
    
    @GET
    @Path("advertisements/getByPilgrim/{pilgrimid}")
    @Produces("application/json")
    public Response<Collection<AdvertisementMaster>> getAdvertisementByPilgrim(@PathParam("pilgrimid") Integer pilgrimid) {
        Response response = new Response();
        try {
            response.setResult(clientBeanLocal.getAdvertisementByPilgrim(pilgrimid));
            response.setMessage("Pilgrim Advertisements fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Pilgrim Advertisements!");
            response.setStatus(false);
        }
        return response;
    }
    
    @POST
    @Path("advertisements/add")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addAdvertisement(Request<AdvertisementMaster> requestbody) {
        Response response = new Response();
        try {
            AdvertisementMaster advertisements = requestbody.getData();
            clientBeanLocal.addAdvertisement(advertisements);
            response.setMessage("Pilgrim Advertisements added successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while adding Pilgrim Advertisements!");
            response.setStatus(false);
        }
        return response;
    }
    
    @POST
    @Path("advertisements/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateAdvertisement(Request<AdvertisementMaster> requestbody) {
        Response response = new Response();
        try {
            AdvertisementMaster advertisements = requestbody.getData();
            clientBeanLocal.updateAdvertisement(advertisements);
            response.setMessage("Pilgrim Advertisements updated successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while updating Pilgrim Advertisements!");
            response.setStatus(false);
        }
        return response;
    }
    
    @DELETE
    @Path("advertisements/delete/{advertisementid}")
    @Produces("application/json")
    public Response removeAdvertisement(@PathParam("advertisementid") Integer advertisementid) {
        Response response = new Response();
        try {
            clientBeanLocal.removeAdvertisement(advertisementid);
            response.setMessage("Pilgrim Advertisements deleted successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while deleting Pilgrim Advertisements!");
            response.setStatus(false);
        }
        return response;
    }
}
