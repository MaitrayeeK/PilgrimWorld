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
import javax.validation.constraints.Size;

/**
 *
 * @author Maitrayee
 */
@Entity
@Table(name = "menu_master")
@NamedQueries({
    @NamedQuery(name = "MenuMaster.findAll", query = "SELECT m FROM MenuMaster m"),
    @NamedQuery(name = "MenuMaster.findByMenuId", query = "SELECT m FROM MenuMaster m WHERE m.menuId = :menuId"),
    @NamedQuery(name = "MenuMaster.findByMenuName", query = "SELECT m FROM MenuMaster m WHERE m.menuName = :menuName"),
    @NamedQuery(name = "MenuMaster.findByParentMenuId", query = "SELECT m FROM MenuMaster m WHERE m.parentMenuId = :parentMenuId"),
    @NamedQuery(name = "MenuMaster.findByCreatedDate", query = "SELECT m FROM MenuMaster m WHERE m.createdDate = :createdDate"),
    @NamedQuery(name = "MenuMaster.findByUpdatedDate", query = "SELECT m FROM MenuMaster m WHERE m.updatedDate = :updatedDate")})
public class MenuMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "menu_id")
    private Integer menuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "parent_menu_id")
    private Integer parentMenuId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuId")
    private Collection<UserrightsMaster> userrightsMasterCollection;

    public MenuMaster() {
    }

    public MenuMaster(Integer menuId) {
        this.menuId = menuId;
    }

    public MenuMaster(Integer menuId, String menuName, Date createdDate, Date updatedDate) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(Integer parentMenuId) {
        this.parentMenuId = parentMenuId;
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

    public Collection<UserrightsMaster> getUserrightsMasterCollection() {
        return userrightsMasterCollection;
    }

    public void setUserrightsMasterCollection(Collection<UserrightsMaster> userrightsMasterCollection) {
        this.userrightsMasterCollection = userrightsMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuId != null ? menuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuMaster)) {
            return false;
        }
        MenuMaster other = (MenuMaster) object;
        if ((this.menuId == null && other.menuId != null) || (this.menuId != null && !this.menuId.equals(other.menuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MenuMaster[ menuId=" + menuId + " ]";
    }

}
