package com.marv.business.entities;

import java.util.ArrayList;
import java.util.Calendar;

public class AuctionItem extends DomainObject {

	private String name;
	
	private String description;
	
	private double startPrice;
	
	private double byoutPrice;
	
	private Calendar startDate;
	
	private Calendar endDate;
	
	private String picture;
	
	private boolean isSold;
	
	private AuctionCategory auctionCategory;
	
	private User user;
	
	private ArrayList<Bid> bids;

	private long auctionCategoryId;

	private long userId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(double startPrice) {
		this.startPrice = startPrice;
	}

	public double getByoutPrice() {
		return byoutPrice;
	}

	public void setByoutPrice(double byoutPrice) {
		this.byoutPrice = byoutPrice;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public boolean isSold() {
		return isSold;
	}

	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}

	public AuctionCategory getAuctionCategory() {
		return auctionCategory;
	}

	public void setAuctionCategory(AuctionCategory auctionCategory) {
		this.auctionCategory = auctionCategory;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Bid> getBids() {
		return bids;
	}

	public void setBids(ArrayList<Bid> bids) {
		this.bids = bids;
	}
	
	public String getCategoryName() {
		if(auctionCategory != null) {
			return auctionCategory.getName();
		} else {
			return null;
		}
	}
	
	public String getUserName() {
		if(user != null) {
			return user.getUsername();
		} else {
			return null;
		}
	}

	public void setAuctionCategoryId(long auctionCategoryId) {
		this.auctionCategoryId = auctionCategoryId;
	}
	
	public long getAuctionCategoryId() {
		return auctionCategoryId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getUserId() {
		return userId;
	}
}
