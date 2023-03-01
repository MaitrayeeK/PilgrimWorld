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
@Table(name = "discount_master")
@NamedQueries({
    @NamedQuery(name = "DiscountMaster.findAll", query = "SELECT d FROM DiscountMaster d"),
    @NamedQuery(name = "DiscountMaster.findByDiscountId", query = "SELECT d FROM DiscountMaster d WHERE d.discountId = :discountId"),
    @NamedQuery(name = "DiscountMaster.findByDiscountType", query = "SELECT d FROM DiscountMaster d WHERE d.discountType = :discountType"),
    @NamedQuery(name = "DiscountMaster.findByDiscount", query = "SELECT d FROM DiscountMaster d WHERE d.discount = :discount"),
    @NamedQuery(name = "DiscountMaster.findByCreatedDate", query = "SELECT d FROM DiscountMaster d WHERE d.createdDate = :createdDate"),
    @NamedQuery(name = "DiscountMaster.findByUpdatedDate", query = "SELECT d FROM DiscountMaster d WHERE d.updatedDate = :updatedDate")})
public class DiscountMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "discount_id")
    private Integer discountId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount_type")
    private int discountType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private int discount;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discountId")
    private Collection<BookingMaster> bookingMasterCollection;

    public DiscountMaster() {
    }

    public DiscountMaster(Integer discountId) {
        this.discountId = discountId;
    }

    public DiscountMaster(Integer discountId, int discountType, int discount, Date createdDate, Date updatedDate) {
        this.discountId = discountId;
        this.discountType = discountType;
        this.discount = discount;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public int getDiscountType() {
        return discountType;
    }

    public void setDiscountType(int discountType) {
        this.discountType = discountType;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
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

    public Collection<BookingMaster> getBookingMasterCollection() {
        return bookingMasterCollection;
    }

    public void setBookingMasterCollection(Collection<BookingMaster> bookingMasterCollection) {
        this.bookingMasterCollection = bookingMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (discountId != null ? discountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiscountMaster)) {
            return false;
        }
        DiscountMaster other = (DiscountMaster) object;
        if ((this.discountId == null && other.discountId != null) || (this.discountId != null && !this.discountId.equals(other.discountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DiscountMaster[ discountId=" + discountId + " ]";
    }

}
