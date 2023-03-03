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
 * @author Dell
 */
@Entity
@Table(name = "booking_master")
@NamedQueries({
    @NamedQuery(name = "BookingMaster.findAll", query = "SELECT b FROM BookingMaster b"),
    @NamedQuery(name = "BookingMaster.findByBookingId", query = "SELECT b FROM BookingMaster b WHERE b.bookingId = :bookingId"),
    @NamedQuery(name = "BookingMaster.findByNoOfPerson", query = "SELECT b FROM BookingMaster b WHERE b.noOfPerson = :noOfPerson"),
    @NamedQuery(name = "BookingMaster.findByTotalPrice", query = "SELECT b FROM BookingMaster b WHERE b.totalPrice = :totalPrice"),
    @NamedQuery(name = "BookingMaster.findByCreatedDate", query = "SELECT b FROM BookingMaster b WHERE b.createdDate = :createdDate"),
    @NamedQuery(name = "BookingMaster.findByUpdatedDate", query = "SELECT b FROM BookingMaster b WHERE b.updatedDate = :updatedDate")})
public class BookingMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "booking_id")
    private Integer bookingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_of_person")
    private int noOfPerson;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_price")
    private float totalPrice;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "booking")
    private Collection<PaymentMaster> paymentMasterCollection;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private UserMaster user;
    @JoinColumn(name = "discount_id", referencedColumnName = "discount_id")
    @ManyToOne(optional = false)
    private DiscountMaster discount;
    @JoinColumn(name = "pilgrim_id", referencedColumnName = "pilgrim_id")
    @ManyToOne(optional = false)
    private PilgrimMaster pilgrim;
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    @ManyToOne(optional = false)
    private PilgrimTickets ticket;
    @JoinColumn(name = "timeslots_details_id", referencedColumnName = "timeslots_details_id")
    @ManyToOne(optional = false)
    private PilgrimTimeslotsDetails timeslotsDetails;

    public BookingMaster() {
    }

    public BookingMaster(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public BookingMaster(Integer bookingId, int noOfPerson, float totalPrice, Date createdDate, Date updatedDate) {
        this.bookingId = bookingId;
        this.noOfPerson = noOfPerson;
        this.totalPrice = totalPrice;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public int getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(int noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
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
    public Collection<PaymentMaster> getPaymentMasterCollection() {
        return paymentMasterCollection;
    }

    public void setPaymentMasterCollection(Collection<PaymentMaster> paymentMasterCollection) {
        this.paymentMasterCollection = paymentMasterCollection;
    }

    public UserMaster getUser() {
        return user;
    }

    public void setUser(UserMaster userId) {
        this.user = userId;
    }

    public DiscountMaster getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountMaster discountId) {
        this.discount = discountId;
    }

    public PilgrimMaster getPilgrim() {
        return pilgrim;
    }

    public void setPilgrim(PilgrimMaster pilgrimId) {
        this.pilgrim = pilgrimId;
    }

    public PilgrimTickets getTicket() {
        return ticket;
    }

    public void setTicket(PilgrimTickets ticketId) {
        this.ticket = ticketId;
    }

    public PilgrimTimeslotsDetails getTimeslotsDetails() {
        return timeslotsDetails;
    }

    public void setTimeslotsDetails(PilgrimTimeslotsDetails timeslotsDetailsId) {
        this.timeslotsDetails = timeslotsDetailsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingId != null ? bookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingMaster)) {
            return false;
        }
        BookingMaster other = (BookingMaster) object;
        if ((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BookingMaster[ bookingId=" + bookingId + " ]";
    }
    
}
