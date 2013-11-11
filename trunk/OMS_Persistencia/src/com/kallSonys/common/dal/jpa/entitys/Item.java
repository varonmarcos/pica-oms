package com.kallSonys.common.dal.jpa.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ITEMS database table.
 * 
 */
@Entity
@Table(name="ITEMS")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String itemid;

	private String partnum;

	private BigDecimal price;

	private BigDecimal prodid;

	private String productname;

	private BigDecimal quantity;

	//bi-directional many-to-one association to Order
    @ManyToOne
	@JoinColumn(name="ORDERID")
	private Order order;

    public Item() {
    }

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getPartnum() {
		return this.partnum;
	}

	public void setPartnum(String partnum) {
		this.partnum = partnum;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getProdid() {
		return this.prodid;
	}

	public void setProdid(BigDecimal prodid) {
		this.prodid = prodid;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}