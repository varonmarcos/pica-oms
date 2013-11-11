package com.kallSonys.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CUSTOMER_ADDRESS database table.
 * 
 */
@Entity
@Table(name="CUSTOMER_ADDRESS")
public class CustomerAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String custaddid;

	//bi-directional many-to-one association to Address
    @ManyToOne
	@JoinColumn(name="ADDRESSID")
	private Address address;

	//bi-directional many-to-one association to Customer
    @ManyToOne
	@JoinColumn(name="CUSTID")
	private Customer customer;

    public CustomerAddress() {
    }

	public String getCustaddid() {
		return this.custaddid;
	}

	public void setCustaddid(String custaddid) {
		this.custaddid = custaddid;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}