/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pilgrim.security;

import com.pilgrim.ejb.AdminBeanLocal;
import com.pilgrim.entities.UserMaster;
import com.pilgrim.helper.SecurityData;
import com.pilgrim.jwt.JWTCredential;
import com.pilgrim.jwt.TokenProvider;
import io.jsonwebtoken.ExpiredJwtException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.CredentialValidationResult.Status;
import javax.security.enterprise.identitystore.IdentityStoreHandler;

/**
 *
 * @author Dell
 */
public class Security {
    
    @EJB
    AdminBeanLocal adminBeanLocal;

    @Inject
    IdentityStoreHandler handler;

    @Inject
    TokenProvider tokenProvider;

    //for validating user
    public SecurityData validateUser(SecurityData securitydata) {

        UserMaster user = securitydata.getUser();
        String token;

        System.out.println("EJB " + user.getUsername());

        Credential credential = new UsernamePasswordCredential(user.getUsername(), new Password(user.getPassword()));
        CredentialValidationResult result = handler.validate(credential);
        System.out.println("result ejb " + result.getStatus());
        
        if (result.getStatus() == Status.VALID) {
            
            //generate token
            token = tokenProvider.createToken(result.getCallerPrincipal().getName(), result.getCallerGroups(), false);
            
            System.out.println("Token: " + token);
            
            UserMaster validatedUser = adminBeanLocal.getUserByUsername(result.getCallerPrincipal().getName());
            
            SecurityData security = new SecurityData(result.getStatus(), token, validatedUser);
            return security;
        }
        else{
            SecurityData security = new SecurityData(result.getStatus());
            return security;
        }
    }

    //for validating token
    public SecurityData validateToken(SecurityData securityData) {

        try {
            if (tokenProvider.validateToken(securityData.getToken())) {
//                JWTCredential credential = tokenProvider.getCredential(securityData.getToken());
                System.out.println("In SecureAuthentication - In validateToken() method - Token Validated!!!");
                return new SecurityData(Status.VALID);
            }
            //token invalid
            return new SecurityData(Status.INVALID);
//            return context.responseUnauthorized();
        } catch (ExpiredJwtException ex) {
            return new SecurityData(Status.INVALID);
        }
    }
}