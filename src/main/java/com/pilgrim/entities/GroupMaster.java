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
@Table(name = "group_master")
@NamedQueries({
    @NamedQuery(name = "GroupMaster.findAll", query = "SELECT g FROM GroupMaster g"),
    @NamedQuery(name = "GroupMaster.findByGroupId", query = "SELECT g FROM GroupMaster g WHERE g.groupId = :groupId"),
    @NamedQuery(name = "GroupMaster.findByGroupName", query = "SELECT g FROM GroupMaster g WHERE g.groupName = :groupName"),
    @NamedQuery(name = "GroupMaster.findByCreatedDate", query = "SELECT g FROM GroupMaster g WHERE g.createdDate = :createdDate"),
    @NamedQuery(name = "GroupMaster.findByUpdateDate", query = "SELECT g FROM GroupMaster g WHERE g.updateDate = :updateDate")})
public class GroupMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "group_id")
    private Integer groupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "group_name")
    private String groupName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Collection<UserrightsMaster> userrightsMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Collection<UserMaster> userMasterCollection;

    public GroupMaster() {
    }

    public GroupMaster(Integer groupId) {
        this.groupId = groupId;
    }

    public GroupMaster(Integer groupId, String groupName, Date createdDate, Date updateDate) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @JsonbTransient
    public Collection<UserrightsMaster> getUserrightsMasterCollection() {
        return userrightsMasterCollection;
    }

    public void setUserrightsMasterCollection(Collection<UserrightsMaster> userrightsMasterCollection) {
        this.userrightsMasterCollection = userrightsMasterCollection;
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
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupMaster)) {
            return false;
        }
        GroupMaster other = (GroupMaster) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pilgrim.entities.GroupMaster[ groupId=" + groupId + " ]";
    }

}
