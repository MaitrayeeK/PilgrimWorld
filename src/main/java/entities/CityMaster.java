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
import javax.validation.constraints.Size;

/**
 *
 * @author Maitrayee
 */
@Entity
@Table(name = "city_master")
@NamedQueries({
    @NamedQuery(name = "CityMaster.findAll", query = "SELECT c FROM CityMaster c"),
    @NamedQuery(name = "CityMaster.findByCityId", query = "SELECT c FROM CityMaster c WHERE c.cityId = :cityId"),
    @NamedQuery(name = "CityMaster.findByCityName", query = "SELECT c FROM CityMaster c WHERE c.cityName = :cityName"),
    @NamedQuery(name = "CityMaster.findByCreatedDate", query = "SELECT c FROM CityMaster c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "CityMaster.findByUpdatedDate", query = "SELECT c FROM CityMaster c WHERE c.updatedDate = :updatedDate")})
public class CityMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "city_id")
    private Integer cityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "city_name")
    private String cityName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityId")
    private Collection<PilgrimMaster> pilgrimMasterCollection;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false)
    private StateMaster stateId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityId")
    private Collection<UserMaster> userMasterCollection;

    public CityMaster() {
    }

    public CityMaster(Integer cityId) {
        this.cityId = cityId;
    }

    public CityMaster(Integer cityId, String cityName, Date createdDate, Date updatedDate) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    public Collection<PilgrimMaster> getPilgrimMasterCollection() {
        return pilgrimMasterCollection;
    }

    public void setPilgrimMasterCollection(Collection<PilgrimMaster> pilgrimMasterCollection) {
        this.pilgrimMasterCollection = pilgrimMasterCollection;
    }

    public StateMaster getStateId() {
        return stateId;
    }

    public void setStateId(StateMaster stateId) {
        this.stateId = stateId;
    }

    public Collection<UserMaster> getUserMasterCollection() {
        return userMasterCollection;
    }

    public void setUserMasterCollection(Collection<UserMaster> userMasterCollection) {
        this.userMasterCollection = userMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityId != null ? cityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CityMaster)) {
            return false;
        }
        CityMaster other = (CityMaster) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CityMaster[ cityId=" + cityId + " ]";
    }

}
