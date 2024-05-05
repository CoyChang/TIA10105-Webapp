package com.order.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderVO implements Serializable {
	private Integer orderNumber;
	private Integer userNumber;
	private Integer orderStatus;
	private Timestamp establishmentTime;
	private String note;
	private Timestamp shippingTime;
	private String receiver;
	private String shippingAddress;
	private BigDecimal deliveryFee;
	private BigDecimal total;
	
	public OrderVO() {
		super();
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(Integer userNumber) {
		this.userNumber = userNumber;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Timestamp getEstablishmentTime() {
		return establishmentTime;
	}

	public void setEstablishmentTime(Timestamp establishmentTime) {
		this.establishmentTime = establishmentTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Timestamp getShippingTime() {
		return shippingTime;
	}

	public void setShippingTime(Timestamp shippingTime) {
		this.shippingTime = shippingTime;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public BigDecimal getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(BigDecimal deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	

}
