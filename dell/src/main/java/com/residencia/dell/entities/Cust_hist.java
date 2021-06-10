package com.residencia.dell.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "cust_hist")
public class Cust_hist {

	
	@Id
	@Column(name = "prod_id")
    private Integer prodId;
	
    @Column(name = "customerid")
    private Integer custumerId;
   
    @Column(name = "orderid")
    private Integer orderId;

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public Integer getCustumerId() {
		return custumerId;
	}

	public void setCustumerId(Integer custumerId) {
		this.custumerId = custumerId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}



}
