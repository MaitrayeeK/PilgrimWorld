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
@Table(name = "commission_master")
@NamedQueries({
    @NamedQuery(name = "CommissionMaster.findAll", query = "SELECT c FROM CommissionMaster c"),
    @NamedQuery(name = "CommissionMaster.findByCommissionId", query = "SELECT c FROM CommissionMaster c WHERE c.commissionId = :commissionId"),
    @NamedQuery(name = "CommissionMaster.findByCommissionPerPerson", query = "SELECT c FROM CommissionMaster c WHERE c.commissionPerPerson = :commissionPerPerson"),
    @NamedQuery(name = "CommissionMaster.findByCreatedDate", query = "SELECT c FROM CommissionMaster c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "CommissionMaster.findByUpdatedDate", query = "SELECT c FROM CommissionMaster c WHERE c.updatedDate = :updatedDate")})
public class CommissionMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "commission_id")
    private Integer commissionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "commission_per_person")
    private float commissionPerPerson;
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
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    @ManyToOne(optional = false)
    private PilgrimTickets ticket;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commission")
    private Collection<ProfitMaster> profitMasterCollection;

    public CommissionMaster() {
    }

    public CommissionMaster(Integer commissionId) {
        this.commissionId = commissionId;
    }

    public CommissionMaster(Integer commissionId, float commissionPerPerson, Date createdDate, Date updatedDate) {
        this.commissionId = commissionId;
        this.commissionPerPerson = commissionPerPerson;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getCommissionId() {
        return commissionId;
    }

    public void setCommissionId(Integer commissionId) {
        this.commissionId = commissionId;
    }

    public float getCommissionPerPerson() {
        return commissionPerPerson;
    }

    public void setCommissionPerPerson(float commissionPerPerson) {
        this.commissionPerPerson = commissionPerPerson;
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

    public PilgrimTickets getTicket() {
        return ticket;
    }

    public void setTicket(PilgrimTickets ticket) {
        this.ticket = ticket;
    }
    
    @JsonbTransient
    public Collection<ProfitMaster> getProfitMasterCollection() {
        return profitMasterCollection;
    }

    public void setProfitMasterCollection(Collection<ProfitMaster> profitMasterCollection) {
        this.profitMasterCollection = profitMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commissionId != null ? commissionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommissionMaster)) {
            return false;
        }
        CommissionMaster other = (CommissionMaster) object;
        if ((this.commissionId == null && other.commissionId != null) || (this.commissionId != null && !this.commissionId.equals(other.commissionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pilgrim.entities.CommissionMaster[ commissionId=" + commissionId + " ]";
    }

}
