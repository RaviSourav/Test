package com.rs.store.Store.customer;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String type;
	private int unitPrice;
	private Date date;
	private int quantity;
	private String name;
	
	
	public Customer() {
		super();
	}
	
	
	public Customer(int customerId,String type, int unitPrice, Date date, int quantity, String name) {
		super();
		this.customerId = customerId;
		this.type = type;
		this.unitPrice = unitPrice;
		this.date = date;
		this.quantity = quantity;
		this.name = name;
	}
	
	public int getcustomerId() {
		return customerId;
	}
	public void setcustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String gettype() {
		return type;
	}
	public void settype(String type) {
		this.type = type;
	}
	public int getunitPrice() {
		return unitPrice;
	}
	public void setunitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getquantity() {
		return quantity;
	}
	public void setquantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
