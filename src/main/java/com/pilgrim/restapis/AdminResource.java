/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.pilgrim.restapis;

import com.pilgrim.ejb.AdminBeanLocal;
import com.pilgrim.entities.StateMaster;
import com.pilgrim.entities.UserMaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import com.pilgrim.helper.Request;
import com.pilgrim.helper.Response;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author maitr
 */
@Path("admin")
@RequestScoped
public class AdminResource {

    @EJB
    AdminBeanLocal adminBeanLocal;

    public AdminResource() {
    }

    @GET
    @Path("cities/{stateid}")
    @Produces("application/json")
    public Response getAllCitiesByState(@PathParam("stateid") Integer state) {
        Response response = new Response();
        try {
            response.setResult(adminBeanLocal.getAllCitiesByState(state));
            response.setMessage("Cities fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setMessage("Failed fetching cities!");
            response.setStatus(false);
            response.setResult(e);
        }
        return response;
    }

    @GET
    @Path("states")
    @Produces("application/json")
    public Response<Collection<StateMaster>> getAllState() {
        Response response = new Response();
        try {
            response.setResult(adminBeanLocal.getAllState());
            response.setMessage("States fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setMessage("Failed fetching states!");
            response.setStatus(false);
            response.setResult(e);
        }
        return response;
    }

    @POST
    @Path("users/add")
    @Consumes("application/json")
    @Produces("application/json")
    public Response adduser(Request<UserMaster> requestbody) {
        Response response = new Response();
        try {
            UserMaster user = requestbody.getData();
            adminBeanLocal.addUser(user);
            response.setMessage("User added successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setMessage("Failed adding user!");
            response.setStatus(false);
            response.setResult(e);
        }
        return response;
    }

    @POST
    @Path("users/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateuser(Request<UserMaster> requestbody) {
        Response response = new Response();
        try {
            UserMaster user = requestbody.getData();
            adminBeanLocal.updateUser(user);
            response.setMessage("User updated successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setMessage("Failed updating user!");
            response.setStatus(false);
            response.setResult(e);
        }
        return response;
    }

    @GET
    @Path("users")
    @Produces("application/json")
    public Response<Collection<UserMaster>> getallusers() {
            Response response = new Response();
        try {
            response.setResult(adminBeanLocal.getAllUser());
            response.setMessage("Users data fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setMessage("Failed fetching users!");
            response.setStatus(false);
            response.setResult(e);
        }
        return response;
    }

}
