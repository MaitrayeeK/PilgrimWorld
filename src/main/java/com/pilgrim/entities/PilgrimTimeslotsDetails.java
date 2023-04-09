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
@Table(name = "pilgrim_timeslots_details")
@NamedQueries({
    @NamedQuery(name = "PilgrimTimeslotsDetails.findAll", query = "SELECT p FROM PilgrimTimeslotsDetails p"),
    @NamedQuery(name = "PilgrimTimeslotsDetails.findByTimeslotsDetailsId", query = "SELECT p FROM PilgrimTimeslotsDetails p WHERE p.timeslotsDetailsId = :timeslotsDetailsId"),
    @NamedQuery(name = "PilgrimTimeslotsDetails.findByWeekday", query = "SELECT p FROM PilgrimTimeslotsDetails p WHERE p.weekday = :weekday"),
    @NamedQuery(name = "PilgrimTimeslotsDetails.findByFromDate", query = "SELECT p FROM PilgrimTimeslotsDetails p WHERE p.fromDate = :fromDate"),
    @NamedQuery(name = "PilgrimTimeslotsDetails.findByToDate", query = "SELECT p FROM PilgrimTimeslotsDetails p WHERE p.toDate = :toDate"),
    @NamedQuery(name = "PilgrimTimeslotsDetails.findByFromTime", query = "SELECT p FROM PilgrimTimeslotsDetails p WHERE p.fromTime = :fromTime"),
    @NamedQuery(name = "PilgrimTimeslotsDetails.findByToTime", query = "SELECT p FROM PilgrimTimeslotsDetails p WHERE p.toTime = :toTime"),
    @NamedQuery(name = "PilgrimTimeslotsDetails.findByCreatedDate", query = "SELECT p FROM PilgrimTimeslotsDetails p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "PilgrimTimeslotsDetails.findByUpdatedDate", query = "SELECT p FROM PilgrimTimeslotsDetails p WHERE p.updatedDate = :updatedDate")})
public class PilgrimTimeslotsDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "timeslots_details_id")
    private Integer timeslotsDetailsId;
    @Column(name = "weekday")
    private Integer weekday;
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "from_time")
    @Temporal(TemporalType.TIME)
    private Date fromTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "to_time")
    @Temporal(TemporalType.TIME)
    private Date toTime;
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
    @JoinColumn(name = "timeslots_id", referencedColumnName = "timeslots_id")
    @ManyToOne(optional = false)
    private PilgrimTimeslots timeslots;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timeslotsDetails")
    private Collection<PilgrimTickets> pilgrimTicketsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timeslotsDetails")
    private Collection<BookingMaster> bookingMasterCollection;

    public PilgrimTimeslotsDetails() {
    }

    public PilgrimTimeslotsDetails(Integer timeslotsDetailsId) {
        this.timeslotsDetailsId = timeslotsDetailsId;
    }

    public PilgrimTimeslotsDetails(Integer timeslotsDetailsId, Date fromTime, Date toTime, Date createdDate, Date updatedDate) {
        this.timeslotsDetailsId = timeslotsDetailsId;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getTimeslotsDetailsId() {
        return timeslotsDetailsId;
    }

    public void setTimeslotsDetailsId(Integer timeslotsDetailsId) {
        this.timeslotsDetailsId = timeslotsDetailsId;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
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

    public PilgrimTimeslots getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(PilgrimTimeslots timeslots) {
        this.timeslots = timeslots;
    }
    
    @JsonbTransient
    public Collection<PilgrimTickets> getPilgrimTicketsCollection() {
        return pilgrimTicketsCollection;
    }

    public void setPilgrimTicketsCollection(Collection<PilgrimTickets> pilgrimTicketsCollection) {
        this.pilgrimTicketsCollection = pilgrimTicketsCollection;
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
        hash += (timeslotsDetailsId != null ? timeslotsDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PilgrimTimeslotsDetails)) {
            return false;
        }
        PilgrimTimeslotsDetails other = (PilgrimTimeslotsDetails) object;
        if ((this.timeslotsDetailsId == null && other.timeslotsDetailsId != null) || (this.timeslotsDetailsId != null && !this.timeslotsDetailsId.equals(other.timeslotsDetailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pilgrim.entities.PilgrimTimeslotsDetails[ timeslotsDetailsId=" + timeslotsDetailsId + " ]";
    }

}
