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

/**
 *
 * @author Maitrayee
 */
@Entity
@Table(name = "profit_master")
@NamedQueries({
    @NamedQuery(name = "ProfitMaster.findAll", query = "SELECT p FROM ProfitMaster p"),
    @NamedQuery(name = "ProfitMaster.findByProfitId", query = "SELECT p FROM ProfitMaster p WHERE p.profitId = :profitId"),
    @NamedQuery(name = "ProfitMaster.findByProfit", query = "SELECT p FROM ProfitMaster p WHERE p.profit = :profit"),
    @NamedQuery(name = "ProfitMaster.findByCreatedDate", query = "SELECT p FROM ProfitMaster p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "ProfitMaster.findByUpdatedDate", query = "SELECT p FROM ProfitMaster p WHERE p.updatedDate = :updatedDate")})
public class ProfitMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "profit_id")
    private Integer profitId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "profit")
    private float profit;
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
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    @ManyToOne(optional = false)
    private PaymentMaster paymentId;
    @JoinColumn(name = "commission_id", referencedColumnName = "commission_id")
    @ManyToOne(optional = false)
    private CommissionMaster commissionId;

    public ProfitMaster() {
    }

    public ProfitMaster(Integer profitId) {
        this.profitId = profitId;
    }

    public ProfitMaster(Integer profitId, float profit, Date createdDate, Date updatedDate) {
        this.profitId = profitId;
        this.profit = profit;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getProfitId() {
        return profitId;
    }

    public void setProfitId(Integer profitId) {
        this.profitId = profitId;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
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

    public PaymentMaster getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(PaymentMaster paymentId) {
        this.paymentId = paymentId;
    }

    public CommissionMaster getCommissionId() {
        return commissionId;
    }

    public void setCommissionId(CommissionMaster commissionId) {
        this.commissionId = commissionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profitId != null ? profitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfitMaster)) {
            return false;
        }
        ProfitMaster other = (ProfitMaster) object;
        if ((this.profitId == null && other.profitId != null) || (this.profitId != null && !this.profitId.equals(other.profitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProfitMaster[ profitId=" + profitId + " ]";
    }

}
