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
@Table(name = "pilgrim_timeslots")
@NamedQueries({
    @NamedQuery(name = "PilgrimTimeslots.findAll", query = "SELECT p FROM PilgrimTimeslots p"),
    @NamedQuery(name = "PilgrimTimeslots.findByTimeslotsId", query = "SELECT p FROM PilgrimTimeslots p WHERE p.timeslotsId = :timeslotsId"),
    @NamedQuery(name = "PilgrimTimeslots.findByWeekDate", query = "SELECT p FROM PilgrimTimeslots p WHERE p.weekDate = :weekDate"),
    @NamedQuery(name = "PilgrimTimeslots.findByCreatedDate", query = "SELECT p FROM PilgrimTimeslots p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "PilgrimTimeslots.findByUpdatedDate", query = "SELECT p FROM PilgrimTimeslots p WHERE p.updatedDate = :updatedDate")})
public class PilgrimTimeslots implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "timeslots_id")
    private Integer timeslotsId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "week_date")
    private int weekDate;
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
    private PilgrimMaster pilgrim;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timeslots")
    private Collection<PilgrimTimeslotsDetails> pilgrimTimeslotsDetailsCollection;

    public PilgrimTimeslots() {
    }

    public PilgrimTimeslots(Integer timeslotsId) {
        this.timeslotsId = timeslotsId;
    }

    public PilgrimTimeslots(Integer timeslotsId, int weekDate, Date createdDate, Date updatedDate) {
        this.timeslotsId = timeslotsId;
        this.weekDate = weekDate;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getTimeslotsId() {
        return timeslotsId;
    }

    public void setTimeslotsId(Integer timeslotsId) {
        this.timeslotsId = timeslotsId;
    }

    public int getWeekDate() {
        return weekDate;
    }

    public void setWeekDate(int weekDate) {
        this.weekDate = weekDate;
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

    public PilgrimMaster getPilgrim() {
        return pilgrim;
    }

    public void setPilgrim(PilgrimMaster pilgrim) {
        this.pilgrim = pilgrim;
    }
    
    @JsonbTransient
    public Collection<PilgrimTimeslotsDetails> getPilgrimTimeslotsDetailsCollection() {
        return pilgrimTimeslotsDetailsCollection;
    }

    public void setPilgrimTimeslotsDetailsCollection(Collection<PilgrimTimeslotsDetails> pilgrimTimeslotsDetailsCollection) {
        this.pilgrimTimeslotsDetailsCollection = pilgrimTimeslotsDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timeslotsId != null ? timeslotsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PilgrimTimeslots)) {
            return false;
        }
        PilgrimTimeslots other = (PilgrimTimeslots) object;
        if ((this.timeslotsId == null && other.timeslotsId != null) || (this.timeslotsId != null && !this.timeslotsId.equals(other.timeslotsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pilgrim.entities.PilgrimTimeslots[ timeslotsId=" + timeslotsId + " ]";
    }

}
