package com.kallSonys.common.dal.jpa.entitys;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;
import org.eclipse.persistence.annotations.NamedStoredProcedureQueries;
import org.eclipse.persistence.annotations.StoredProcedureParameter;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@NamedStoredProcedureQuery(name="GETCUSTOMERS_BY_IDPRODUCT",procedureName="GETCUSTOMERS_BY_IDPRODUCT",
     parameters={@StoredProcedureParameter(direction= Direction.IN,name="IDPRODUCT",queryParameter="IDPRODUCT"),
               @StoredProcedureParameter(direction= Direction.OUT_CURSOR,name="customers",queryParameter="customers")})
@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	private String custid;

	private String creditcardnumer;

	private String creditcardtype;

	private String email;

	private String fname;

	private String lname;

	private String passwordd;

	private String phonenumber;

	private String status;
	
	@Transient
	private String price;

	//bi-directional many-to-one association to Customertype
    @ManyToOne
	@JoinColumn(name="TYPEID")
	private Customertype customertype;

	//bi-directional many-to-one association to CustomerAddress	
	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL,targetEntity = CustomerAddress.class, fetch=FetchType.EAGER)
	private Set<CustomerAddress> customerAddresses;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="customer")
	private Set<Orders> orders;

    public Customer() {
    }

	public String getCustid() {
		return this.custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getCreditcardnumer() {
		return this.creditcardnumer;
	}

	public void setCreditcardnumer(String creditcardnumer) {
		this.creditcardnumer = creditcardnumer;
	}

	public String getCreditcardtype() {
		return this.creditcardtype;
	}

	public void setCreditcardtype(String creditcardtype) {
		this.creditcardtype = creditcardtype;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPasswordd() {
		return this.passwordd;
	}

	public void setPasswordd(String passwordd) {
		this.passwordd = passwordd;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customertype getCustomertype() {
		return this.customertype;
	}

	public void setCustomertype(Customertype customertype) {
		this.customertype = customertype;
	}
	
	public Set<CustomerAddress> getCustomerAddresses() {
		return this.customerAddresses;
	}

	public void setCustomerAddresses(Set<CustomerAddress> customerAddresses) {
		this.customerAddresses = customerAddresses;
	}
	
	public Set<Orders> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}