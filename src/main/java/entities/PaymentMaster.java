/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "payment_master")
@NamedQueries({
    @NamedQuery(name = "PaymentMaster.findAll", query = "SELECT p FROM PaymentMaster p"),
    @NamedQuery(name = "PaymentMaster.findByPaymentId", query = "SELECT p FROM PaymentMaster p WHERE p.paymentId = :paymentId"),
    @NamedQuery(name = "PaymentMaster.findByTotalPrice", query = "SELECT p FROM PaymentMaster p WHERE p.totalPrice = :totalPrice"),
    @NamedQuery(name = "PaymentMaster.findByCreatedDate", query = "SELECT p FROM PaymentMaster p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "PaymentMaster.findByUpdatedDate", query = "SELECT p FROM PaymentMaster p WHERE p.updatedDate = :updatedDate")})
public class PaymentMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "payment_id")
    private Integer paymentId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentId")
    private Collection<ProfitMaster> profitMasterCollection;
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    @ManyToOne(optional = false)
    private BookingMaster bookingId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pilgrimId")
    private Collection<PaymentMaster> paymentMasterCollection;
    @JoinColumn(name = "pilgrim_id", referencedColumnName = "payment_id")
    @ManyToOne(optional = false)
    private PaymentMaster pilgrimId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private UserMaster userId;

    public PaymentMaster() {
    }

    public PaymentMaster(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentMaster(Integer paymentId, float totalPrice, Date createdDate, Date updatedDate) {
        this.paymentId = paymentId;
        this.totalPrice = totalPrice;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
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

    public Collection<ProfitMaster> getProfitMasterCollection() {
        return profitMasterCollection;
    }

    public void setProfitMasterCollection(Collection<ProfitMaster> profitMasterCollection) {
        this.profitMasterCollection = profitMasterCollection;
    }

    public BookingMaster getBookingId() {
        return bookingId;
    }

    public void setBookingId(BookingMaster bookingId) {
        this.bookingId = bookingId;
    }

    public Collection<PaymentMaster> getPaymentMasterCollection() {
        return paymentMasterCollection;
    }

    public void setPaymentMasterCollection(Collection<PaymentMaster> paymentMasterCollection) {
        this.paymentMasterCollection = paymentMasterCollection;
    }

    public PaymentMaster getPilgrimId() {
        return pilgrimId;
    }

    public void setPilgrimId(PaymentMaster pilgrimId) {
        this.pilgrimId = pilgrimId;
    }

    public UserMaster getUserId() {
        return userId;
    }

    public void setUserId(UserMaster userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentId != null ? paymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentMaster)) {
            return false;
        }
        PaymentMaster other = (PaymentMaster) object;
        if ((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PaymentMaster[ paymentId=" + paymentId + " ]";
    }

}
