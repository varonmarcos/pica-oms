/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Frank
 */
@Entity
@Table(name = "CUSTOMER_ADDRESS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerAddress.findAll", query = "SELECT c FROM CustomerAddress c"),
    @NamedQuery(name = "CustomerAddress.findByCustaddid", query = "SELECT c FROM CustomerAddress c WHERE c.custaddid = :custaddid")})
public class CustomerAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CUSTADDID")
    private String custaddid;
    @JoinColumn(name = "CUSTID", referencedColumnName = "CUSTID")
    @ManyToOne(optional = false)
    private Customer custid;
    @JoinColumn(name = "ADDRESSID", referencedColumnName = "ADDRID")
    @ManyToOne(optional = false)
    private Address addressid;

    public CustomerAddress() {
    }

    public CustomerAddress(String custaddid) {
        this.custaddid = custaddid;
    }

    public String getCustaddid() {
        return custaddid;
    }

    public void setCustaddid(String custaddid) {
        this.custaddid = custaddid;
    }

    public Customer getCustid() {
        return custid;
    }

    public void setCustid(Customer custid) {
        this.custid = custid;
    }

    public Address getAddressid() {
        return addressid;
    }

    public void setAddressid(Address addressid) {
        this.addressid = addressid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (custaddid != null ? custaddid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerAddress)) {
            return false;
        }
        CustomerAddress other = (CustomerAddress) object;
        if ((this.custaddid == null && other.custaddid != null) || (this.custaddid != null && !this.custaddid.equals(other.custaddid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kallSonys.common.dal.jpa.CustomerAddress[ custaddid=" + custaddid + " ]";
    }
    
}
