package com.kallSonys.common.dal.jpa.entitys;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;



/**
 * The persistent class for the CUSTOMERTYPE database table.
 * 
 */
@Entity
public class Customertype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String code;

	private String description;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="customertype")
	private List<Customer> customers;

    public Customertype() {
    }

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
}