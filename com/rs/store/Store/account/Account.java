package com.rs.store.Store.account;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sellId;
	private Date date;
	private String type;
	private float totalSell;
	private int quantity;
	
	
	
	public Account() {
		super();
	}

	

	public Account(int sellId,Date date,String type, float totalSell, int quantity) {
		super();
		this.sellId = sellId;
		this.date = date;
		this.type = type;
		this.totalSell = totalSell;
		this.quantity = quantity;
	}
	
	public int getsellId() {
		return sellId;
	}
	public void setsellId(int sellId) {
		this.sellId = sellId;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getTotalSell() {
		return totalSell;
	}
	public void setTotalSell(float totalSell) {
		this.totalSell = totalSell;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
