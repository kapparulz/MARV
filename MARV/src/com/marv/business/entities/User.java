package com.marv.business.entities;

import java.util.ArrayList;

public class User extends DomainObject {
	
	public enum UserType {
		TUTOR,
		STUDENT
	}
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String phone;
	
	private String address;
	
	private String firstName;
	
	private String lastName;
	
	private Institution institution;
	
	private UserType type;
	
	private ArrayList<AuctionItem> auctionItems;
	
	private ArrayList<Bid> bids;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public ArrayList<AuctionItem> getAuctionItems() {
		return auctionItems;
	}

	public void setAuctionItems(ArrayList<AuctionItem> auctionItems) {
		this.auctionItems = auctionItems;
	}

	public ArrayList<Bid> getBids() {
		return bids;
	}

	public void setBids(ArrayList<Bid> bids) {
		this.bids = bids;
	}
}
