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
@Table(name = "pilgrim_rooms")
@NamedQueries({
    @NamedQuery(name = "PilgrimRooms.findAll", query = "SELECT p FROM PilgrimRooms p"),
    @NamedQuery(name = "PilgrimRooms.findByPilgrimRoomId", query = "SELECT p FROM PilgrimRooms p WHERE p.pilgrimRoomId = :pilgrimRoomId"),
    @NamedQuery(name = "PilgrimRooms.findByNoOfRooms", query = "SELECT p FROM PilgrimRooms p WHERE p.noOfRooms = :noOfRooms"),
    @NamedQuery(name = "PilgrimRooms.findByRoomType", query = "SELECT p FROM PilgrimRooms p WHERE p.roomType = :roomType"),
    @NamedQuery(name = "PilgrimRooms.findByPrice", query = "SELECT p FROM PilgrimRooms p WHERE p.price = :price"),
    @NamedQuery(name = "PilgrimRooms.findByCreatedDate", query = "SELECT p FROM PilgrimRooms p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "PilgrimRooms.findByUpdatedDate", query = "SELECT p FROM PilgrimRooms p WHERE p.updatedDate = :updatedDate")})
public class PilgrimRooms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pilgrim_room_id")
    private Integer pilgrimRoomId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_of_rooms")
    private int noOfRooms;
    @Basic(optional = false)
    @NotNull
    @Column(name = "room_type")
    private int roomType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private float price;
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
    @JoinColumn(name = "pilgrim_id", referencedColumnName = "pilgrim_id")
    @ManyToOne(optional = false)
    private PilgrimMaster pilgrim;

    public PilgrimRooms() {
    }

    public PilgrimRooms(Integer pilgrimRoomId) {
        this.pilgrimRoomId = pilgrimRoomId;
    }

    public PilgrimRooms(Integer pilgrimRoomId, int noOfRooms, int roomType, float price, Date createdDate, Date updatedDate) {
        this.pilgrimRoomId = pilgrimRoomId;
        this.noOfRooms = noOfRooms;
        this.roomType = roomType;
        this.price = price;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getPilgrimRoomId() {
        return pilgrimRoomId;
    }

    public void setPilgrimRoomId(Integer pilgrimRoomId) {
        this.pilgrimRoomId = pilgrimRoomId;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    public PilgrimMaster getPilgrim() {
        return pilgrim;
    }

    public void setPilgrim(PilgrimMaster pilgrimId) {
        this.pilgrim = pilgrimId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pilgrimRoomId != null ? pilgrimRoomId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PilgrimRooms)) {
            return false;
        }
        PilgrimRooms other = (PilgrimRooms) object;
        if ((this.pilgrimRoomId == null && other.pilgrimRoomId != null) || (this.pilgrimRoomId != null && !this.pilgrimRoomId.equals(other.pilgrimRoomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PilgrimRooms[ pilgrimRoomId=" + pilgrimRoomId + " ]";
    }
    
}
