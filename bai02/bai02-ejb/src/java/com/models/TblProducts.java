/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hoangnd
 */
@Entity
@Table(name = "tblProducts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProducts.findAll", query = "SELECT t FROM TblProducts t")
    , @NamedQuery(name = "TblProducts.findById", query = "SELECT t FROM TblProducts t WHERE t.id = :id")
    , @NamedQuery(name = "TblProducts.findByProductName", query = "SELECT t FROM TblProducts t WHERE t.productName = :productName")
    , @NamedQuery(name = "TblProducts.findByQuantity", query = "SELECT t FROM TblProducts t WHERE t.quantity = :quantity")})
public class TblProducts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "productName")
    private String productName;
    @Column(name = "quantity")
    private Integer quantity;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;

    public TblProducts() {
    }

    public TblProducts(Integer id) {
        this.id = id;
    }

    public TblProducts(Integer id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof TblProducts)) {
            return false;
        }
        TblProducts other = (TblProducts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.models.TblProducts[ id=" + id + " ]";
    }
    
}
