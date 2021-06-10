package com.residencia.dell.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orders")
public class Orders {
	 
	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "orderid")
	    private Integer orderid;
	
	
	@Column(name = "orderdate")
	    private Calendar orderdate;
 
	@OneToMany(mappedBy = "orders", cascade = {CascadeType.PERSIST})
	@JsonManagedReference
		private List<Orderlines> listOrderlines;
	
	@JsonIgnore
	@ManyToOne
	  @JoinColumn(name = "customerid", referencedColumnName = "customerid")
	    private Customers customers;
	  
	  @Column(name = "netamount")
	    private BigDecimal netAmount;
	  
	  
	  @Column(name = "totalamount")
	    private BigDecimal totalAmount;
	 
	  
	  @Column(name = "tax")
	    private BigDecimal tax;


	public Integer getOrderid() {
		return orderid;
	}


	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}


	public Calendar getOrderdate() {
		return orderdate;
	}


	public void setOrderdate(Calendar orderdate) {
		this.orderdate = orderdate;
	}


	public List<Orderlines> getListOrderlines() {
		return listOrderlines;
	}


	public void setListOrderlines(List<Orderlines> listOrderlines) {
		this.listOrderlines = listOrderlines;
	}


	public Customers getCustomers() {
		return customers;
	}


	public void setCustomers(Customers customers) {
		this.customers = customers;
	}


	public BigDecimal getNetAmount() {
		return netAmount;
	}


	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}


	public BigDecimal getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}


	public BigDecimal getTax() {
		return tax;
	}


	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	  
	  

}
