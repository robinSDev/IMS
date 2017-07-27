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
@Table(name = "cafetaria", catalog = "robin", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cafetaria.findAll", query = "SELECT c FROM Cafetaria c")
    , @NamedQuery(name = "Cafetaria.findById", query = "SELECT c FROM Cafetaria c WHERE c.id = :id")
    , @NamedQuery(name = "Cafetaria.findByItemName", query = "SELECT c FROM Cafetaria c WHERE c.itemName = :itemName")
    , @NamedQuery(name = "Cafetaria.findByManufacturer", query = "SELECT c FROM Cafetaria c WHERE c.manufacturer = :manufacturer")
    , @NamedQuery(name = "Cafetaria.findByQuantity", query = "SELECT c FROM Cafetaria c WHERE c.quantity = :quantity")
    , @NamedQuery(name = "Cafetaria.findByDateAdded", query = "SELECT c FROM Cafetaria c WHERE c.dateAdded = :dateAdded")})
public class Cafetaria implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "itemName")
    private String itemName;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "dateAdded")
    private String dateAdded;

    public Cafetaria() {
    }

    public Cafetaria(Integer id) {
        this.id = id;
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
        if (!(object instanceof Cafetaria)) {
            return false;
        }
        Cafetaria other = (Cafetaria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "robin.IMS.IMS_App.Cafetaria[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
