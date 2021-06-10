package com.residencia.dell.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name= "orderlines")
public class Orderlines {
	

	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "orderlineid")
	    private Integer orderlineid;
	   
	  	 @ManyToOne
		@JsonBackReference
	  	 @JoinColumn(name = "orderid", referencedColumnName = "orderid")
		    private Orders orders;
	    
	    @JoinColumn(name = "prod_id", referencedColumnName = "prod_id")
	    @ManyToOne
	    private Products products;
	    
	    @Column(name = "quantity")
	    private Integer quantity;
	    
	    @Column(name = "orderdate")
	    private Calendar orderdate;

		
	    public Integer getOrderlineid() {
			return orderlineid;
		}

		public void setOrderlineid(Integer orderlineid) {
			this.orderlineid = orderlineid;
		}

		public Orders getOrders() {
			return orders;
		}

		public void setOrders(Orders orders) {
			this.orders = orders;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public Calendar getOrderdate() {
			return orderdate;
		}

		public void setOrderdate(Calendar orderdate) {
			this.orderdate = orderdate;
		}

		public Products getProducts() {
			return products;
		}

		public void setProducts(Products products) {
			this.products = products;
		}
		
}