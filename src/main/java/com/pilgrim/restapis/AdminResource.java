/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.pilgrim.restapis;

import com.pilgrim.ejb.AdminBeanLocal;
import com.pilgrim.entities.UserMaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.persistence.Entity;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author maitr
 */
@Path("admin")
@RequestScoped
public class AdminResource {
    
    @EJB AdminBeanLocal ejbBeanLocal;
    APIResponse response;
    
    public AdminResource() {
    }
    
    @POST
    @Path("add")
    @Consumes("application/json")
    @Produces("application/json")
    public Response adduser(UserMaster user, Integer groupId, Integer stateId, Integer cityId) {
        Object object = ejbBeanLocal.addUser(user, groupId, stateId, cityId);
        response = new APIResponse();
        response.setMessage("Record added!");
        response.setSingleObject(object);
        return Response.ok(response).build();
    }
    
    @POST
    @Path("update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateuser(UserMaster user, Integer groupId, Integer stateId, Integer cityId) {
        Object object = ejbBeanLocal.updateUser(user, groupId, stateId, cityId);
        response = new APIResponse();
        response.setMessage("Record added!");
        response.setSingleObject(object);
        return Response.ok(response).build();
    }
    
    @GET
    @Path("users")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getallusers() {
       Collection<UserMaster> entitys = ejbBeanLocal.getAllUser();
       return Response.status(Response.Status.OK).entity(entitys).build();
    }
    
}
