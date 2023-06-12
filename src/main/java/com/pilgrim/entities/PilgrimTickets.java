/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pilgrim.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Maitrayee
 */
@Entity
@Table(name = "pilgrim_tickets")
@NamedQueries({
    @NamedQuery(name = "PilgrimTickets.findAll", query = "SELECT p FROM PilgrimTickets p"),
    @NamedQuery(name = "PilgrimTickets.findByTicketId", query = "SELECT p FROM PilgrimTickets p WHERE p.ticketId = :ticketId"),
    @NamedQuery(name = "PilgrimTickets.findByFromAge", query = "SELECT p FROM PilgrimTickets p WHERE p.fromAge = :fromAge"),
    @NamedQuery(name = "PilgrimTickets.findByToAge", query = "SELECT p FROM PilgrimTickets p WHERE p.toAge = :toAge"),
    @NamedQuery(name = "PilgrimTickets.findByPrice", query = "SELECT p FROM PilgrimTickets p WHERE p.price = :price"),
    @NamedQuery(name = "PilgrimTickets.findByCreatedDate", query = "SELECT p FROM PilgrimTickets p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "PilgrimTickets.findByUpdatedDate", query = "SELECT p FROM PilgrimTickets p WHERE p.updatedDate = :updatedDate")})
public class PilgrimTickets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ticket_id")
    private Integer ticketId;
    @Column(name = "from_age")
    private int fromAge;
    @Column(name = "to_age")
    private int toAge;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
    private Collection<CommissionMaster> commissionMasterCollection;
    @JoinColumn(name = "pilgrim_id", referencedColumnName = "pilgrim_id")
    @ManyToOne(optional = false)
    private PilgrimMaster pilgrim;
    @JoinColumn(name = "timeslots_details_id", referencedColumnName = "timeslots_details_id")
    @ManyToOne(optional = false)
    private PilgrimTimeslotsDetails timeslotsDetails;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
    private Collection<BookingMaster> bookingMasterCollection;

    public PilgrimTickets() {
    }

    public PilgrimTickets(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public PilgrimTickets(Integer ticketId, int fromAge, int toAge, float price, Date createdDate, Date updatedDate) {
        this.ticketId = ticketId;
        this.fromAge = fromAge;
        this.toAge = toAge;
        this.price = price;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public int getFromAge() {
        return fromAge;
    }

    public void setFromAge(int fromAge) {
        this.fromAge = fromAge;
    }

    public int getToAge() {
        return toAge;
    }

    public void setToAge(int toAge) {
        this.toAge = toAge;
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
    
    @JsonbTransient
    public Collection<CommissionMaster> getCommissionMasterCollection() {
        return commissionMasterCollection;
    }

    public void setCommissionMasterCollection(Collection<CommissionMaster> commissionMasterCollection) {
        this.commissionMasterCollection = commissionMasterCollection;
    }

    public PilgrimMaster getPilgrim() {
        return pilgrim;
    }

    public void setPilgrim(PilgrimMaster pilgrim) {
        this.pilgrim = pilgrim;
    }

    public PilgrimTimeslotsDetails getTimeslotsDetails() {
        return timeslotsDetails;
    }

    public void setTimeslotsDetails(PilgrimTimeslotsDetails timeslotsDetails) {
        this.timeslotsDetails = timeslotsDetails;
    }
    
    @JsonbTransient
    public Collection<BookingMaster> getBookingMasterCollection() {
        return bookingMasterCollection;
    }

    public void setBookingMasterCollection(Collection<BookingMaster> bookingMasterCollection) {
        this.bookingMasterCollection = bookingMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PilgrimTickets)) {
            return false;
        }
        PilgrimTickets other = (PilgrimTickets) object;
        if ((this.ticketId == null && other.ticketId != null) || (this.ticketId != null && !this.ticketId.equals(other.ticketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pilgrim.entities.PilgrimTickets[ ticketId=" + ticketId + " ]";
    }

}
