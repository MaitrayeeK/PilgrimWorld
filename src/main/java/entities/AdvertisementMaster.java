/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entities;

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
import javax.validation.constraints.Size;

/**
 *
 * @author Maitrayee
 */
@Entity
@Table(name = "advertisement_master")
@NamedQueries({
    @NamedQuery(name = "AdvertisementMaster.findAll", query = "SELECT a FROM AdvertisementMaster a"),
    @NamedQuery(name = "AdvertisementMaster.findByAdvertisementId", query = "SELECT a FROM AdvertisementMaster a WHERE a.advertisementId = :advertisementId"),
    @NamedQuery(name = "AdvertisementMaster.findByAdImage", query = "SELECT a FROM AdvertisementMaster a WHERE a.adImage = :adImage"),
    @NamedQuery(name = "AdvertisementMaster.findByCreatedDate", query = "SELECT a FROM AdvertisementMaster a WHERE a.createdDate = :createdDate"),
    @NamedQuery(name = "AdvertisementMaster.findByUpdatedDate", query = "SELECT a FROM AdvertisementMaster a WHERE a.updatedDate = :updatedDate")})
public class AdvertisementMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "advertisement_id")
    private Integer advertisementId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ad_image")
    private String adImage;
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
    private PilgrimMaster pilgrimId;

    public AdvertisementMaster() {
    }

    public AdvertisementMaster(Integer advertisementId) {
        this.advertisementId = advertisementId;
    }

    public AdvertisementMaster(Integer advertisementId, String adImage, Date createdDate, Date updatedDate) {
        this.advertisementId = advertisementId;
        this.adImage = adImage;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Integer advertisementId) {
        this.advertisementId = advertisementId;
    }

    public String getAdImage() {
        return adImage;
    }

    public void setAdImage(String adImage) {
        this.adImage = adImage;
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

    public PilgrimMaster getPilgrimId() {
        return pilgrimId;
    }

    public void setPilgrimId(PilgrimMaster pilgrimId) {
        this.pilgrimId = pilgrimId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (advertisementId != null ? advertisementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdvertisementMaster)) {
            return false;
        }
        AdvertisementMaster other = (AdvertisementMaster) object;
        if ((this.advertisementId == null && other.advertisementId != null) || (this.advertisementId != null && !this.advertisementId.equals(other.advertisementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AdvertisementMaster[ advertisementId=" + advertisementId + " ]";
    }

}
