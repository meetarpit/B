package com.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//This model class is used to map all below defined fields with table tbl_offer
@Entity
public class Offer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	public enum Currency {
        INR, USD;
    }
	private String offerName;
	private String description;
	private boolean isActive;
	private boolean isExpired;
	private String expiryDate;
	private Currency currency;
	private String stripeEmail;
	private String stripeToken;
	@Column(name = "datecreated", nullable = false, updatable=false)
	private String dateCreated;
	private String dateUpdated;
	private String startdate;
	private String enddate;
	private int price;
	
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public String getStripeEmail() {
		return stripeEmail;
	}
	public void setStripeEmail(String stripeEmail) {
		this.stripeEmail = stripeEmail;
	}
	public String getStripeToken() {
		return stripeToken;
	}
	public void setStripeToken(String stripeToken) {
		this.stripeToken = stripeToken;
	}
	
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public boolean getIsExpired() {
		return isExpired;
	}
	public void setIsExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Offer [id=" + id + ", offerName=" + offerName + ", dateCreated=" + dateCreated + ", dateUpdated="
				+ dateUpdated + ", startdate=" + startdate + ", enddate=" + enddate + ", price=" + price + "]";
	}
	
	
}
