/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pilgrim.helper;

import com.pilgrim.entities.UserMaster;
import com.pilgrim.jwt.JWTCredential;
import java.io.Serializable;
import javax.security.enterprise.identitystore.CredentialValidationResult.Status;

/**
 *
 * @author Dell
 */
public class SecurityData implements Serializable {
    
    private Status status;
    private String token;
    private UserMaster user;
    private JWTCredential credential;
    
    public SecurityData() {
    }

    public SecurityData(Status status, String token, UserMaster user, JWTCredential credential) {
        this.status = status;
        this.token = token;
        this.user = user;
        this.credential = credential;
    }

    public SecurityData(Status status, String token, UserMaster user) {
        this.status = status;
        this.token = token;
        this.user = user;
    }

    public SecurityData(Status status, JWTCredential credential) {
        this.status = status;
        this.credential = credential;
    }

    public SecurityData(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserMaster getUser() {
        return user;
    }

    public void setUser(UserMaster user) {
        this.user = user;
    }

    public JWTCredential getCredential() {
        return credential;
    }

    public void setCredential(JWTCredential credential) {
        this.credential = credential;
    }
}
