/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pilgrim.config;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author Dell
 */

@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/pilgrimworldpool",
        callerQuery = "select password from user_master where username = ?",
        groupsQuery = "select group_name from user_master u join group_master g on g.group_id = u.group_id where u.username = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30
)

@ApplicationScoped
public class Config {
    
}
