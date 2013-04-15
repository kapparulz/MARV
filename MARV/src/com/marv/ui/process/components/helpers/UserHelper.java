package com.marv.ui.process.components.helpers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.marv.business.entities.DomainObject;
import com.marv.business.entities.User;

public class UserHelper implements Serializable{

	private User user;
	
	private Map<String, String> errors;
	
	public UserHelper() {
		this(new User());
	}
	
	public UserHelper(User user) {
		this.user = user;
	}
	
	public String getUsername() {
		if(user.getUsername() != null) {
			return user.getUsername();
		} else {
			return ""; 
		}
	}
	
	public void setUsername(String username) {
		try {
			user.setUsername(username);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			getErrors().put("username", e.getMessage());
		}
	}
	
	public String getPassword() {
		if(user.getPassword() != null) {
			return user.getPassword();
		} else {
			return ""; 
		}
	}
	
	public void setPassword(String password) {
		try {
			user.setUsername(password);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			getErrors().put("password", e.getMessage());
		}
	}
	
	public String getEmail() {
		if(user.getEmail() != null) {
			return user.getEmail();
		} else {
			return ""; 
		}
	}
	
	public void setEmail(String email) {
		try {
			user.setEmail(email);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			getErrors().put("email", e.getMessage());
		}
	}
	
	public String getPhone() {
		if(user.getPhone() != null) {
			return user.getPhone();
		} else {
			return ""; 
		}
	}
	
	public void setPhone(String phone) {
		try {
			user.setUsername(phone);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			getErrors().put("phone", e.getMessage());
		}
	}
	
	public String getAddress() {
		if(user.getAddress() != null) {
			return user.getAddress();
		} else {
			return ""; 
		}
	}
	
	public void setAddress(String address) {
		try {
			user.setAddress(address);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			getErrors().put("address", e.getMessage());
		}
	}
	
	public String getFirstName() {
		if(user.getFirstName() != null) {
			return user.getFirstName();
		} else {
			return ""; 
		}
	}
	
	public void setFirstName(String firstName) {
		try {
			user.setFirstName(firstName);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			getErrors().put("firstName", e.getMessage());
		}
	}
	
	public String getLastName() {
		if(user.getLastName() != null) {
			return user.getLastName();
		} else {
			return ""; 
		}
	}
	
	public void setLastName(String lastName) {
		try {
			user.setLastName(lastName);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			getErrors().put("lastName", e.getMessage());
		}
	}
	
	public String getId() {
		return "" + user.getId();
	}
	
	public void setId(String idStr) {
		try {
			long id = Long.parseLong(idStr);
			user.setId(id);
		} catch (IllegalArgumentException e) {
			getErrors().put("id", e.getMessage());
		}
	}

	public String getError(String fieldName) {
		if(errors == null || !errors.containsKey(fieldName)) {
			return "";
		} else {
			return errors.get(fieldName);
		}
	}
	
	public Map<String, String> getErrors() {
		if(errors == null) {
			errors = new HashMap<String, String>();
		}
		return errors;
	}

	public DomainObject getUser() {
		return user;
	}
}