package com.marv.ui.process.components.helpers;

import com.marv.business.entities.User;

public class UserHelper {

	private User user;
	
	public UserHelper(User user) {
		this.user = user;
	}
	
	public String getUsername() {
		return user.getUsername();
	}
}
