package com.kallSonys.common.dal.jpa.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CUSTOMER_ADDRESS database table.
 * 
 */
@Entity
@Table(name="CUSTOMER_ADDRESS")
@SequenceGenerator(name = "SEQ_CUSTOMER_ADDRESS_NAME", sequenceName = "SEQ_CUSTOMER_ADDRESS")
public class CustomerAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQ_CUSTOMER_ADDRESS_NAME")
	private String custaddid;

	//bi-directional many-to-one association to Address
    @ManyToOne//(cascade=CascadeType.PERSIST,targetEntity=Address.class)
	@JoinColumn(name="ADDRESSID")
	private Address address;

	//bi-directional many-to-one association to Customer
    @ManyToOne(cascade=CascadeType.PERSIST, targetEntity=Customer.class)
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