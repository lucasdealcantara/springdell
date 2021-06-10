package com.residencia.dell.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "reorder")
public class Reorder {

    @Id
    
    @Column(name = "prod_id")
    private Integer prodId;

    @Column(name = "data_low")
    private Calendar dataLow;

    @Column(name = "quan_low")
    private Integer quanLow;

    @Column(name = "date_reordered")
    private Calendar dateReordered;

    @Column(name = "quan_reordered")
    private Integer quanReordered;

    @Column(name = "date_expected")
    private Integer dateExpected;

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public Calendar getDataLow() {
		return dataLow;
	}

	public void setDataLow(Calendar dataLow) {
		this.dataLow = dataLow;
	}

	public Integer getQuanLow() {
		return quanLow;
	}

	public void setQuanLow(Integer quanLow) {
		this.quanLow = quanLow;
	}

	public Calendar getDateReordered() {
		return dateReordered;
	}

	public void setDateReordered(Calendar dateReordered) {
		this.dateReordered = dateReordered;
	}

	public Integer getQuanReordered() {
		return quanReordered;
	}

	public void setQuanReordered(Integer quanReordered) {
		this.quanReordered = quanReordered;
	}

	public Integer getDateExpected() {
		return dateExpected;
	}

	public void setDateExpected(Integer dateExpected) {
		this.dateExpected = dateExpected;
	}

}
