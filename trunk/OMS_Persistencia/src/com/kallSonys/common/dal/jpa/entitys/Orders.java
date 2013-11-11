package com.kallSonys.common.dal.jpa.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



/**
 * The persistent class for the ORDERS database table.
 * 
 */
@Entity
@Table(name="ORDERS")
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String ordid;

	private String comments;

    @Temporal( TemporalType.DATE)
	private Date orderdate;

	private BigDecimal price;

	private String status;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="order")
	private List<Items> items;

	//bi-directional many-to-one association to Customer
    @ManyToOne
	@JoinColumn(name="CUSTID")
	private Customer customer;

    public Orders() {
    }

	public String getOrdid() {
		return this.ordid;
	}

	public void setOrdid(String ordid) {
		this.ordid = ordid;
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

	public List<Items> getItems() {
		return this.items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}