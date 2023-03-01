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
@Table(name = "pilgrim_imaged")
@NamedQueries({
    @NamedQuery(name = "PilgrimImaged.findAll", query = "SELECT p FROM PilgrimImaged p"),
    @NamedQuery(name = "PilgrimImaged.findByPilgrimImageId", query = "SELECT p FROM PilgrimImaged p WHERE p.pilgrimImageId = :pilgrimImageId"),
    @NamedQuery(name = "PilgrimImaged.findByImages", query = "SELECT p FROM PilgrimImaged p WHERE p.images = :images"),
    @NamedQuery(name = "PilgrimImaged.findByCreatedDate", query = "SELECT p FROM PilgrimImaged p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "PilgrimImaged.findByUpdatedDate", query = "SELECT p FROM PilgrimImaged p WHERE p.updatedDate = :updatedDate")})
public class PilgrimImaged implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pilgrim_image_id")
    private Integer pilgrimImageId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "images")
    private String images;
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

    public PilgrimImaged() {
    }

    public PilgrimImaged(Integer pilgrimImageId) {
        this.pilgrimImageId = pilgrimImageId;
    }

    public PilgrimImaged(Integer pilgrimImageId, String images, Date createdDate, Date updatedDate) {
        this.pilgrimImageId = pilgrimImageId;
        this.images = images;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getPilgrimImageId() {
        return pilgrimImageId;
    }

    public void setPilgrimImageId(Integer pilgrimImageId) {
        this.pilgrimImageId = pilgrimImageId;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
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
        hash += (pilgrimImageId != null ? pilgrimImageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PilgrimImaged)) {
            return false;
        }
        PilgrimImaged other = (PilgrimImaged) object;
        if ((this.pilgrimImageId == null && other.pilgrimImageId != null) || (this.pilgrimImageId != null && !this.pilgrimImageId.equals(other.pilgrimImageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PilgrimImaged[ pilgrimImageId=" + pilgrimImageId + " ]";
    }

}
