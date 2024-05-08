package com.promotionproject.model;

import java.io.*;
import java.sql.Date;

public class PromotionProjectVO implements Serializable  {
	private Integer promotionProjectNumber;
	private String promotionProjectName;
	private Date promotionStartDate;
	private Date promotionLastDate;
	private String title;
	private String content;
	private byte[] picture;
			
	public PromotionProjectVO() {
		super();
	}
	
	
	public Integer getPromotionProjectNumber() {
		return promotionProjectNumber;
	}
	public void setPromotionProjectNumber(Integer promotionProjectNumber) {
		this.promotionProjectNumber = promotionProjectNumber;
	}
	public String getPromotionProjectName() {
		return promotionProjectName;
	}
	public void setPromotionProjectName(String promotionProjectName) {
		this.promotionProjectName = promotionProjectName;
	}
	public Date getPromotionStartDate() {
		return promotionStartDate;
	}
	public void setPromotionStartDate(Date promotionStartDate) {
		this.promotionStartDate = promotionStartDate;
	}
	public Date getPromotionLastDate() {
		return promotionLastDate;
	}
	public void setPromotionLastDate(Date promotionLastDate) {
		this.promotionLastDate = promotionLastDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	

}
