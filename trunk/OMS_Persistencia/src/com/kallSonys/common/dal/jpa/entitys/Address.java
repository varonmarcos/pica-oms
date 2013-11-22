package com.kallSonys.common.dal.jpa.entitys;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the ADDRESS database table.
 * 
 */
@Entity
@Table(name="ADDRESS")
@SequenceGenerator(name = "SEQ_ADDRESS_NAME", sequenceName = "SEQ_ADDRESS")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQ_ADDRESS_NAME")
	private String addrid;

	private String addresstype;

	private String city;

	private String country;

	@Column(name="\"STATE\"")
	private String state;

	private String street;

	private String zip;

	//bi-directional many-to-one association to CustomerAddress
	@OneToMany(mappedBy="address",cascade = CascadeType.ALL,targetEntity = CustomerAddress.class)	
	private Set<CustomerAddress> customerAddresses;

    public Address() {
    }

	public String getAddrid() {
		return this.addrid;
	}

	public void setAddrid(String addrid) {
		this.addrid = addrid;
	}

	public String getAddresstype() {
		return this.addresstype;
	}

	public void setAddresstype(String addresstype) {
		this.addresstype = addresstype;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Set<CustomerAddress> getCustomerAddresses() {
		return this.customerAddresses;
	}

	public void setCustomerAddresses(Set<CustomerAddress> customerAddresses) {
		this.customerAddresses = customerAddresses;
	}
	
}