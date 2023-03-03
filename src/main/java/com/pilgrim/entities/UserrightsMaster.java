/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pilgrim.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "userrights_master")
@NamedQueries({
    @NamedQuery(name = "UserrightsMaster.findAll", query = "SELECT u FROM UserrightsMaster u"),
    @NamedQuery(name = "UserrightsMaster.findByUserrightsId", query = "SELECT u FROM UserrightsMaster u WHERE u.userrightsId = :userrightsId"),
    @NamedQuery(name = "UserrightsMaster.findByIsAllow", query = "SELECT u FROM UserrightsMaster u WHERE u.isAllow = :isAllow"),
    @NamedQuery(name = "UserrightsMaster.findByCreatedDate", query = "SELECT u FROM UserrightsMaster u WHERE u.createdDate = :createdDate"),
    @NamedQuery(name = "UserrightsMaster.findByUpdatedDate", query = "SELECT u FROM UserrightsMaster u WHERE u.updatedDate = :updatedDate")})
public class UserrightsMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userrights_id")
    private Integer userrightsId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_allow")
    private int isAllow;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne(optional = false)
    private GroupMaster group;
    @JoinColumn(name = "menu_id", referencedColumnName = "menu_id")
    @ManyToOne(optional = false)
    private MenuMaster menu;

    public UserrightsMaster() {
    }

    public UserrightsMaster(Integer userrightsId) {
        this.userrightsId = userrightsId;
    }

    public UserrightsMaster(Integer userrightsId, int isAllow, Date createdDate, Date updatedDate) {
        this.userrightsId = userrightsId;
        this.isAllow = isAllow;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getUserrightsId() {
        return userrightsId;
    }

    public void setUserrightsId(Integer userrightsId) {
        this.userrightsId = userrightsId;
    }

    public int getIsAllow() {
        return isAllow;
    }

    public void setIsAllow(int isAllow) {
        this.isAllow = isAllow;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public GroupMaster getGroup() {
        return group;
    }

    public void setGroup(GroupMaster groupId) {
        this.group = groupId;
    }

    public MenuMaster getMenu() {
        return menu;
    }

    public void setMenu(MenuMaster menuId) {
        this.menu = menuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userrightsId != null ? userrightsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserrightsMaster)) {
            return false;
        }
        UserrightsMaster other = (UserrightsMaster) object;
        if ((this.userrightsId == null && other.userrightsId != null) || (this.userrightsId != null && !this.userrightsId.equals(other.userrightsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserrightsMaster[ userrightsId=" + userrightsId + " ]";
    }
    
}
