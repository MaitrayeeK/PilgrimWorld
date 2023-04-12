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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import com.pilgrim.helper.Request;
import com.pilgrim.helper.Response;

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

//    @GET
//    @Path("users")
//    @Produces("application/json")
//    public Response getAllCitiesByState() {
//        return Response.status(200).build();
//    }
//
//    @GET
//    @Path("users")
//    @Produces("application/json")
//    public Response getAllState() {
//        return Response.status(200).build();
//    }
//
//    @GET
//    @Path("users")
//    @Produces("application/json")
//    public Response getAllGroups() {
//        return Response.status(200).build();
//    }
//
//    @POST
//    @Path("adduser")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response addCommission(CommissionMaster commission) {
//        return Response.status(200).build();
//    }
//
//    @POST
//    @Path("adduser")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response updateCommission(CommissionMaster commission) {
//        return Response.status(200).build();
//    }
//
//    public Response removeCommission(CommissionMaster commission) {
//        return Response.status(200).build();
//    }
//
//    @GET
//    @Path("users")
//    @Produces("application/json")
//    public Response getAllCommissions() {
//        return Response.status(200).build();
//    }
//
//    @POST
//    @Path("adduser")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response addMenu(MenuMaster menu) {
//        return Response.status(200).build();
//    }
//
//    @POST
//    @Path("adduser")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response updateMenu(MenuMaster menu) {
//        return Response.status(200).build();
//    }
//
//    public Response removeMenu(MenuMaster menu) {
//        return Response.status(200).build();
//    }
//
//    @GET
//    @Path("users")
//    @Produces("application/json")
//    public Response getAllMenu() {
//        return Response.status(200).build();
//    }
//
//    @POST
//    @Path("adduser")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response addProfit(ProfitMaster profit) {
//        return Response.status(200).build();
//    }
//
//    @POST
//    @Path("adduser")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response updateProfit(ProfitMaster profit) {
//        return Response.status(200).build();
//    }
//
//    public Response removeProfit(ProfitMaster profit) {
//        return Response.status(200).build();
//    }
//
//    @GET
//    @Path("users")
//    @Produces("application/json")
//    public Response getAllProfits() {
//        return Response.status(200).build();
//    }
//
//    @POST
//    @Path("adduser")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response addUserrights(UserrightsMaster userrights) {
//        return Response.status(200).build();
//    }
//
//    @POST
//    @Path("adduser")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response updateUserrights(UserrightsMaster userrights) {
//        return Response.status(200).build();
//    }
//
//    public Response removeUserrights(UserrightsMaster userrights) {
//        return Response.status(200).build();
//    }
//
//    @GET
//    @Path("users")
//    @Produces("application/json")
//    public Response getAllUserrights() {
//        return Response.status(200).build();
//    }
//
    @POST
    @Path("user/add")
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
    @Path("user/update")
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
