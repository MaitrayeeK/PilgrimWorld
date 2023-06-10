/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.pilgrim.restapis;

import com.pilgrim.ejb.AdminBeanLocal;
import com.pilgrim.entities.CommissionMaster;
import com.pilgrim.entities.PilgrimMaster;
import com.pilgrim.entities.ProfitMaster;
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
import javax.ws.rs.DELETE;
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
            response.setResult(adminBeanLocal.getAllStates());
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
            System.out.println("request body : " + requestbody.toString());
            UserMaster user = requestbody.getData();
            System.out.println("username : " + user.getFirstname());
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
    public Response updateuser(UserMaster user) {
        Response response = new Response();
        try {
//            UserMaster user = requestbody.getData();
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

    @DELETE
    @Path("users/delete/{userid}")
    @Produces("application/json")
    public Response removeUser(@PathParam("userid") Integer userid) {
        Response response = new Response();
        try {
            adminBeanLocal.removeUser(userid);
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

    @GET
    @Path("users/getByUsername/{username}")
    @Produces("application/json")
    public Response<UserMaster> getUserByUsername(@PathParam("username") String username) {
        Response response = new Response();
        try {
            response.setResult(adminBeanLocal.getUserByUsername(username));
            response.setMessage("Users data fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setMessage("Failed while fetching users!");
            response.setStatus(false);
            response.setResult(e);
        }
        return response;
    }

    @GET
    @Path("users/checkifUsernameExists/{username}")
    @Produces("application/json")
    public Response<Boolean> checkifUsernameExists(@PathParam("username") String username) {
        Response response = new Response();
        try {
            Boolean usernameExists = adminBeanLocal.checkifUsernameExists(username);
            response.setResult(usernameExists);

            if (usernameExists) {
                response.setMessage("Username alredy exists!");
                response.setStatus(false);
            } else {
                response.setMessage("Username is available!");
                response.setStatus(true);
            }
        } catch (Exception e) {
            response.setMessage("Failed while fetching users!");
            response.setStatus(false);
            response.setResult(e);
        }
        return response;
    }
    
    @GET
    @Path("users/checkifEmailExists/{email}")
    @Produces("application/json")
    public Response<Boolean> checkifEmailExists(@PathParam("email") String email) {
        Response response = new Response();
        try {
            Boolean emailExists = adminBeanLocal.checkifEmailExists(email);
            response.setResult(emailExists);

            if (emailExists) {
                response.setMessage("Email alredy exists!");
                response.setStatus(false);
            } else {
                response.setMessage("Email is available!");
                response.setStatus(true);
            }
        } catch (Exception e) {
            response.setMessage("Failed while fetching users!");
            response.setStatus(false);
            response.setResult(e);
        }
        return response;
    }

    @GET
    @Path("users/getByGroup/{groupid}")
    @Produces("application/json")
    public Response<Collection<UserMaster>> getUserByGroup(@PathParam("groupid") Integer groupid) {
        Response response = new Response();
        try {
            response.setResult(adminBeanLocal.getUsersByGroup(groupid));
            response.setMessage("Users data fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setMessage("Failed while fetching users!");
            response.setStatus(false);
            response.setResult(e);
        }
        return response;
    }

    @GET
    @Path("commissions")
    @Produces("application/json")
    public Response<Collection<CommissionMaster>> getAllCommissions() {
        Response response = new Response();
        try {
            response.setResult(adminBeanLocal.getAllCommissions());
            response.setMessage("Commissions fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Commissions!");
            response.setStatus(false);
        }
        return response;
    }

    @GET
    @Path("commissions/getByPilgrim/{pilgrimid}")
    @Produces("application/json")
    public Response<Collection<CommissionMaster>> getCommissionsByPilgrim(@PathParam("pilgrimid") Integer pilgrimid) {
        Response response = new Response();
        try {
            response.setResult(adminBeanLocal.getCommissionsByPilgrim(pilgrimid));
            response.setMessage("Commissions fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while fetching Commissions!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("commissions/add")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addCommission(Request<CommissionMaster> requestbody) {
        Response response = new Response();
        try {
            CommissionMaster commission = requestbody.getData();
            adminBeanLocal.addCommission(commission);
            response.setMessage("Commission added successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setMessage("Failed while adding Commission!");
            response.setStatus(false);
            response.setResult(e);
        }
        return response;
    }

    @POST
    @Path("commissions/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateCommission(Request<CommissionMaster> requestbody) {
        Response response = new Response();
        try {
            CommissionMaster commission = requestbody.getData();
            adminBeanLocal.updateCommission(commission);
            response.setMessage("Commission updated successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setMessage("Failed while updating Commission!");
            response.setStatus(false);
            response.setResult(e);
        }
        return response;
    }

    @DELETE
    @Path("commissions/delete/{commissionid}")
    @Produces("application/json")
    public Response removeCommission(@PathParam("commissionid") Integer commissionid) {
        Response response = new Response();
        try {
            adminBeanLocal.removeCommission(commissionid);
            response.setMessage("Commission deleted successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setMessage("Failed while deleting Commission!");
            response.setStatus(false);
            response.setResult(e);
        }
        return response;
    }

    @GET
    @Path("profits")
    @Produces("application/json")
    public Response<Collection<ProfitMaster>> getAllProfits() {
        Response response = new Response();
        try {
            response.setResult(adminBeanLocal.getAllProfits());
            response.setMessage("Profits data fetched successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setMessage("Failed while fetching Profits!");
            response.setStatus(false);
            response.setResult(e);
        }
        return response;
    }

    @POST
    @Path("profits/add")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addProfit(Request<ProfitMaster> requestbody) {
        Response response = new Response();
        try {
            ProfitMaster profit = requestbody.getData();
            adminBeanLocal.addProfit(profit);
            response.setMessage("Profit added successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setMessage("Failed while adding Profit!");
            response.setStatus(false);
            response.setResult(e);
        }
        return response;
    }

    @POST
    @Path("profits/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateProfit(Request<ProfitMaster> requestbody) {
        Response response = new Response();
        try {
            ProfitMaster profit = requestbody.getData();
            adminBeanLocal.updateProfit(profit);
            response.setMessage("Profit updated successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setMessage("Failed while updating Profit!");
            response.setStatus(false);
            response.setResult(e);
        }
        return response;
    }

    @DELETE
    @Path("profits/delete/{profitid}")
    @Produces("application/json")
    public Response removeProfit(@PathParam("profitid") Integer profitid) {
        Response response = new Response();
        try {
            adminBeanLocal.removeProfit(profitid);
            response.setMessage("Profit deleted successfully!");
            response.setStatus(true);
        } catch (Exception e) {
            response.setMessage("Failed while deleting Profit!");
            response.setStatus(false);
            response.setResult(e);
        }
        return response;
    }

}
