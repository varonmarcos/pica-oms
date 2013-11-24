package com.kallSonys.common.dal.jpa.entitys;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the ORDERS database table.
 * 
 */
@Entity
@Table(name="ORDERS")
@SequenceGenerator(name = "SEQ_ORDERS_NAME", sequenceName = "SEQ_ORDERS")
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQ_ORDERS_NAME")
	private String orderid;

	private String comments;

    @Temporal( TemporalType.DATE)
	private Date orderdate;

	private BigDecimal price;

	private String status;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="order",cascade = CascadeType.ALL,targetEntity = Item.class)
	private Set<Item> items;

	//bi-directional many-to-one association to Customer
    @ManyToOne
	@JoinColumn(name="CUSTID")
	private Customer customer;

    public Orders() {
    }

	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Item> getItems() {
		return this.items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}