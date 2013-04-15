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

	private long institutionId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		if(username.length() < 1) {
			throw new IllegalArgumentException("Username must not be empty.");
		}
		if(username.length() > 12) {
			throw new IllegalArgumentException("Username must not be longer than 12 characters.");
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		if(password.length() < 1) {
			throw new IllegalArgumentException("PW must not be empty.");
		}
		if(password.length() > 255) {
			throw new IllegalArgumentException("PW must not be longer than 255 characters.");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		if(email.length() > 50) {
			throw new IllegalArgumentException("Email must not be longer than 50 characters.");
		}
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
		if(phone.length() > 12) {
			throw new IllegalArgumentException("Phone must not be longer than 12 characters.");
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
		if(address.length() < 1) {
			throw new IllegalArgumentException("Address must not be empty.");
		}
		if(address.length() > 250) {
			throw new IllegalArgumentException("Address must not be longer than 250 characters.");
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		if(firstName.length() < 1) {
			throw new IllegalArgumentException("Firstname must not be empty.");
		}
		if(firstName.length() > 150) {
			throw new IllegalArgumentException("Firstname must not be longer than 150 characters.");
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		if(lastName.length() < 1) {
			throw new IllegalArgumentException("Lastname must not be empty.");
		}
		if(lastName.length() > 150) {
			throw new IllegalArgumentException("Lastname must not be longer than 150 characters.");
		}
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

	public void setInstitutionId(long institutionId) {
		this.institutionId=institutionId;
		if(institutionId < -1L || institutionId == 0) {
			throw new IllegalArgumentException("Institution ID cannot be less than -1 or 0.");
		}
	}

	public long getInstitutionId() {
		return institutionId;
	}
	
	public String toString() {
		return "[" + address + ", " + email + ", " + firstName + ", "
				+ institutionId + ", " + lastName + ", " + password + ", "
				+ phone + ", " + type.toString() + ", " + username + "]";
	}
}
