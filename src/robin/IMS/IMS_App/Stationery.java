/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robin.IMS.IMS_App;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Devgan's
 */
@Entity
@Table(name = "stationery", catalog = "robin", schema = "")
@NamedQueries({
    @NamedQuery(name = "Stationery.findAll", query = "SELECT s FROM Stationery s")
    , @NamedQuery(name = "Stationery.findById", query = "SELECT s FROM Stationery s WHERE s.id = :id")
    , @NamedQuery(name = "Stationery.findByItemName", query = "SELECT s FROM Stationery s WHERE s.itemName = :itemName")
    , @NamedQuery(name = "Stationery.findByManufacturer", query = "SELECT s FROM Stationery s WHERE s.manufacturer = :manufacturer")
    , @NamedQuery(name = "Stationery.findByQuantity", query = "SELECT s FROM Stationery s WHERE s.quantity = :quantity")
    , @NamedQuery(name = "Stationery.findByDateAdded", query = "SELECT s FROM Stationery s WHERE s.dateAdded = :dateAdded")})
public class Stationery implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "itemName")
    private String itemName;
    @Basic(optional = false)
    @Column(name = "manufacturer")
    private String manufacturer;
    @Basic(optional = false)
    @Column(name = "quantity")
    private String quantity;
    @Basic(optional = false)
    @Column(name = "dateAdded")
    private String dateAdded;

    public Stationery() {
    }

    public Stationery(Integer id) {
        this.id = id;
    }

    public Stationery(Integer id, String itemName, String manufacturer, String quantity, String dateAdded) {
        this.id = id;
        this.itemName = itemName;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.dateAdded = dateAdded;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        String oldItemName = this.itemName;
        this.itemName = itemName;
        changeSupport.firePropertyChange("itemName", oldItemName, itemName);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        String oldManufacturer = this.manufacturer;
        this.manufacturer = manufacturer;
        changeSupport.firePropertyChange("manufacturer", oldManufacturer, manufacturer);
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        String oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        String oldDateAdded = this.dateAdded;
        this.dateAdded = dateAdded;
        changeSupport.firePropertyChange("dateAdded", oldDateAdded, dateAdded);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stationery)) {
            return false;
        }
        Stationery other = (Stationery) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "robin.IMS.IMS_App.Stationery[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
