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
@Table(name = "state_master")
@NamedQueries({
    @NamedQuery(name = "StateMaster.findAll", query = "SELECT s FROM StateMaster s"),
    @NamedQuery(name = "StateMaster.findByStateId", query = "SELECT s FROM StateMaster s WHERE s.stateId = :stateId"),
    @NamedQuery(name = "StateMaster.findByStateName", query = "SELECT s FROM StateMaster s WHERE s.stateName = :stateName"),
    @NamedQuery(name = "StateMaster.findByCreatedDate", query = "SELECT s FROM StateMaster s WHERE s.createdDate = :createdDate"),
    @NamedQuery(name = "StateMaster.findByUpdatedDate", query = "SELECT s FROM StateMaster s WHERE s.updatedDate = :updatedDate")})
public class StateMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "state_id")
    private Integer stateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "state_name")
    private String stateName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "state")
    private Collection<PilgrimMaster> pilgrimMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "state")
    private Collection<CityMaster> cityMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "state")
    private Collection<UserMaster> userMasterCollection;

    public StateMaster() {
    }

    public StateMaster(Integer stateId) {
        this.stateId = stateId;
    }

    public StateMaster(Integer stateId, String stateName, Date createdDate, Date updatedDate) {
        this.stateId = stateId;
        this.stateName = stateName;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
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
    public Collection<CityMaster> getCityMasterCollection() {
        return cityMasterCollection;
    }

    public void setCityMasterCollection(Collection<CityMaster> cityMasterCollection) {
        this.cityMasterCollection = cityMasterCollection;
    }
    
    @JsonbTransient
    public Collection<UserMaster> getUserMasterCollection() {
        return userMasterCollection;
    }

    public void setUserMasterCollection(Collection<UserMaster> userMasterCollection) {
        this.userMasterCollection = userMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateId != null ? stateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StateMaster)) {
            return false;
        }
        StateMaster other = (StateMaster) object;
        if ((this.stateId == null && other.stateId != null) || (this.stateId != null && !this.stateId.equals(other.stateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pilgrim.entities.StateMaster[ stateId=" + stateId + " ]";
    }

}
