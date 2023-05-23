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
 * @author Maitrayee
 */
@Entity
@Table(name = "user_master")
@NamedQueries({
    @NamedQuery(name = "UserMaster.findAll", query = "SELECT u FROM UserMaster u"),
    @NamedQuery(name = "UserMaster.findByUserId", query = "SELECT u FROM UserMaster u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserMaster.findByFirstname", query = "SELECT u FROM UserMaster u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "UserMaster.findByLastname", query = "SELECT u FROM UserMaster u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "UserMaster.findByUsername", query = "SELECT u FROM UserMaster u WHERE u.username = :username"),
    @NamedQuery(name = "UserMaster.findByEmail", query = "SELECT u FROM UserMaster u WHERE u.email = :email"),
    @NamedQuery(name = "UserMaster.findByPassword", query = "SELECT u FROM UserMaster u WHERE u.password = :password"),
    @NamedQuery(name = "UserMaster.findByAddress", query = "SELECT u FROM UserMaster u WHERE u.address = :address"),
    @NamedQuery(name = "UserMaster.findByCreatedDate", query = "SELECT u FROM UserMaster u WHERE u.createdDate = :createdDate"),
    @NamedQuery(name = "UserMaster.findByUpdatedDate", query = "SELECT u FROM UserMaster u WHERE u.updatedDate = :updatedDate")})
public class UserMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "username")
    private String username;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user_image")
    private String userImage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "address")
    private String address;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<PilgrimMaster> pilgrimMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<FeedbackMaster> feedbackMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<PaymentMaster> paymentMasterCollection;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private CityMaster city;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne(optional = false)
    private GroupMaster group;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false)
    private StateMaster state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<BookingMaster> bookingMasterCollection;

    public UserMaster() {
    }

    public UserMaster(Integer userId) {
        this.userId = userId;
    }

    public UserMaster(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserMaster(Integer userId, String firstname, String lastname, String username, String email, String password, String userImage, String address, Date createdDate, Date updatedDate) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userImage = userImage;
        this.address = address;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    public Collection<PilgrimMaster> getPilgrimMasterCollection() {
        return pilgrimMasterCollection;
    }

    public void setPilgrimMasterCollection(Collection<PilgrimMaster> pilgrimMasterCollection) {
        this.pilgrimMasterCollection = pilgrimMasterCollection;
    }

    @JsonbTransient
    public Collection<FeedbackMaster> getFeedbackMasterCollection() {
        return feedbackMasterCollection;
    }

    public void setFeedbackMasterCollection(Collection<FeedbackMaster> feedbackMasterCollection) {
        this.feedbackMasterCollection = feedbackMasterCollection;
    }

    @JsonbTransient
    public Collection<PaymentMaster> getPaymentMasterCollection() {
        return paymentMasterCollection;
    }

    public void setPaymentMasterCollection(Collection<PaymentMaster> paymentMasterCollection) {
        this.paymentMasterCollection = paymentMasterCollection;
    }

    public CityMaster getCity() {
        return city;
    }

    public void setCity(CityMaster city) {
        this.city = city;
    }

    public GroupMaster getGroup() {
        return group;
    }

    public void setGroup(GroupMaster group) {
        this.group = group;
    }

    public StateMaster getState() {
        return state;
    }

    public void setState(StateMaster state) {
        this.state = state;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserMaster)) {
            return false;
        }
        UserMaster other = (UserMaster) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pilgrim.entities.UserMaster[ userId=" + userId + " ]";
    }

}
