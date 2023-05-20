/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.pilgrim.restapis;

import com.pilgrim.entities.UserMaster;
import com.pilgrim.helper.Response;
import com.pilgrim.security.Security;
import com.pilgrim.helper.SecurityData;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.security.enterprise.identitystore.CredentialValidationResult.Status;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author Dell
 */
@Path("auth")
@RequestScoped
public class AuthResource {

    @Inject
    Security security;

    public AuthResource() {
    }

    @POST
    @Path("validateUser")
    @Consumes("application/json")
    @Produces("application/json")
    public Response<SecurityData> validateUser(SecurityData securityData) {
        Response response = new Response();
        try {
//            SecurityData securityData = requestbody.getData();
            UserMaster user = securityData.getUser();
            System.out.println("security rest : " + user.getUsername() + " " + user.getPassword());

            SecurityData resSecurity = security.validateUser(securityData);

            response.setResult(resSecurity);

            if (resSecurity.getStatus() == Status.VALID) {
                response.setMessage("User validated successfully!");
                response.setStatus(true);
            } else if (resSecurity.getStatus() == Status.INVALID) {
                response.setMessage("User is not validated!");
                response.setStatus(false);
            }

            System.out.println("result rest : " + response.getResult().toString());
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while validating user!");
            response.setStatus(false);
        }
        return response;
    }

    @POST
    @Path("validateToken")
    @Consumes("application/json")
    @Produces("application/json")
    public Response<SecurityData> validateToken(SecurityData requestbody) {
        Response response = new Response();
        try {
//            SecurityData data = requestbody.getData();

            SecurityData resSecurityData = security.validateToken(requestbody);

            if (resSecurityData.getStatus() == Status.VALID) {
                response.setMessage("Token validated successfully!");
                response.setStatus(true);
            } else if (resSecurityData.getStatus() == Status.INVALID) {
                response.setMessage("Token is invalid or token is expired!");
                response.setStatus(false);
            }
        } catch (Exception e) {
            response.setResult(e);
            response.setMessage("Failed while validating token!");
            response.setStatus(false);
        }
        return response;
    }
}
