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
import javax.validation.constraints.Size;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "pilgrim_master")
@NamedQueries({
    @NamedQuery(name = "PilgrimMaster.findAll", query = "SELECT p FROM PilgrimMaster p"),
    @NamedQuery(name = "PilgrimMaster.findByPilgrimId", query = "SELECT p FROM PilgrimMaster p WHERE p.pilgrimId = :pilgrimId"),
    @NamedQuery(name = "PilgrimMaster.findByPilgrimName", query = "SELECT p FROM PilgrimMaster p WHERE p.pilgrimName = :pilgrimName"),
    @NamedQuery(name = "PilgrimMaster.findByAddress", query = "SELECT p FROM PilgrimMaster p WHERE p.address = :address"),
    @NamedQuery(name = "PilgrimMaster.findByPilgrimImage", query = "SELECT p FROM PilgrimMaster p WHERE p.pilgrimImage = :pilgrimImage"),
    @NamedQuery(name = "PilgrimMaster.findByCreatedDate", query = "SELECT p FROM PilgrimMaster p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "PilgrimMaster.findByUpdatedDate", query = "SELECT p FROM PilgrimMaster p WHERE p.updatedDate = :updatedDate")})
public class PilgrimMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pilgrim_id")
    private Integer pilgrimId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "pilgrim_name")
    private String pilgrimName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "pilgrim_image")
    private String pilgrimImage;
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
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false)
    private StateMaster state;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private CityMaster city;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private UserMaster user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pilgrim")
    private Collection<PilgrimTimeslots> pilgrimTimeslotsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pilgrim")
    private Collection<AdvertisementMaster> advertisementMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pilgrim")
    private Collection<FeedbackMaster> feedbackMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pilgrim")
    private Collection<CommissionMaster> commissionMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pilgrim")
    private Collection<PilgrimTickets> pilgrimTicketsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pilgrim")
    private Collection<PaymentMaster> paymentMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pilgrim")
    private Collection<PilgrimRooms> pilgrimRoomsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pilgrim")
    private Collection<BookingMaster> bookingMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pilgrim")
    private Collection<PilgrimImages> pilgrimImagesCollection;

    public PilgrimMaster() {
    }

    public PilgrimMaster(Integer pilgrimId) {
        this.pilgrimId = pilgrimId;
    }

    public PilgrimMaster(Integer pilgrimId, String pilgrimName, String address, String pilgrimImage, Date createdDate, Date updatedDate) {
        this.pilgrimId = pilgrimId;
        this.pilgrimName = pilgrimName;
        this.address = address;
        this.pilgrimImage = pilgrimImage;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getPilgrimId() {
        return pilgrimId;
    }

    public void setPilgrimId(Integer pilgrimId) {
        this.pilgrimId = pilgrimId;
    }

    public String getPilgrimName() {
        return pilgrimName;
    }

    public void setPilgrimName(String pilgrimName) {
        this.pilgrimName = pilgrimName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPilgrimImage() {
        return pilgrimImage;
    }

    public void setPilgrimImage(String pilgrimImage) {
        this.pilgrimImage = pilgrimImage;
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

    public StateMaster getState() {
        return state;
    }

    public void setState(StateMaster stateId) {
        this.state = stateId;
    }

    public CityMaster getCity() {
        return city;
    }

    public void setCity(CityMaster cityId) {
        this.city = cityId;
    }

    public UserMaster getUser() {
        return user;
    }

    public void setUser(UserMaster userId) {
        this.user = userId;
    }

    @JsonbTransient
    public Collection<PilgrimTimeslots> getPilgrimTimeslotsCollection() {
        return pilgrimTimeslotsCollection;
    }

    public void setPilgrimTimeslotsCollection(Collection<PilgrimTimeslots> pilgrimTimeslotsCollection) {
        this.pilgrimTimeslotsCollection = pilgrimTimeslotsCollection;
    }

    @JsonbTransient
    public Collection<AdvertisementMaster> getAdvertisementMasterCollection() {
        return advertisementMasterCollection;
    }

    public void setAdvertisementMasterCollection(Collection<AdvertisementMaster> advertisementMasterCollection) {
        this.advertisementMasterCollection = advertisementMasterCollection;
    }

    @JsonbTransient
    public Collection<FeedbackMaster> getFeedbackMasterCollection() {
        return feedbackMasterCollection;
    }

    public void setFeedbackMasterCollection(Collection<FeedbackMaster> feedbackMasterCollection) {
        this.feedbackMasterCollection = feedbackMasterCollection;
    }

    @JsonbTransient
    public Collection<CommissionMaster> getCommissionMasterCollection() {
        return commissionMasterCollection;
    }

    public void setCommissionMasterCollection(Collection<CommissionMaster> commissionMasterCollection) {
        this.commissionMasterCollection = commissionMasterCollection;
    }

    @JsonbTransient
    public Collection<PilgrimTickets> getPilgrimTicketsCollection() {
        return pilgrimTicketsCollection;
    }

    public void setPilgrimTicketsCollection(Collection<PilgrimTickets> pilgrimTicketsCollection) {
        this.pilgrimTicketsCollection = pilgrimTicketsCollection;
    }

    @JsonbTransient
    public Collection<PaymentMaster> getPaymentMasterCollection() {
        return paymentMasterCollection;
    }

    public void setPaymentMasterCollection(Collection<PaymentMaster> paymentMasterCollection) {
        this.paymentMasterCollection = paymentMasterCollection;
    }

    @JsonbTransient
    public Collection<PilgrimRooms> getPilgrimRoomsCollection() {
        return pilgrimRoomsCollection;
    }

    public void setPilgrimRoomsCollection(Collection<PilgrimRooms> pilgrimRoomsCollection) {
        this.pilgrimRoomsCollection = pilgrimRoomsCollection;
    }

    @JsonbTransient
    public Collection<BookingMaster> getBookingMasterCollection() {
        return bookingMasterCollection;
    }

    public void setBookingMasterCollection(Collection<BookingMaster> bookingMasterCollection) {
        this.bookingMasterCollection = bookingMasterCollection;
    }

    @JsonbTransient
    public Collection<PilgrimImages> getPilgrimImagesCollection() {
        return pilgrimImagesCollection;
    }

    public void setPilgrimImagesCollection(Collection<PilgrimImages> pilgrimImagesCollection) {
        this.pilgrimImagesCollection = pilgrimImagesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pilgrimId != null ? pilgrimId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PilgrimMaster)) {
            return false;
        }
        PilgrimMaster other = (PilgrimMaster) object;
        if ((this.pilgrimId == null && other.pilgrimId != null) || (this.pilgrimId != null && !this.pilgrimId.equals(other.pilgrimId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PilgrimMaster[ pilgrimId=" + pilgrimId + " ]";
    }
    
}
