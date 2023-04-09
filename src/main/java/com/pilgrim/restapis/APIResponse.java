/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pilgrim.restapis;

import java.util.Collection;
import javax.persistence.Entity;

/**
 *
 * @author Maitrayee
 */
public class APIResponse {
    String message;
    Collection<Object> data;
    Object singleObject;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Collection<Object> getData() {
        return data;
    }

    public void setData(Collection<Object> data) {
        this.data = data;
    }

    public Object getSingleObject() {
        return singleObject;
    }

    public void setSingleObject(Object singleObject) {
        this.singleObject = singleObject;
    }
    
    
}
