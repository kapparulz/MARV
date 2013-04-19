package com.marv.ui.process.components.helpers;

import java.util.ArrayList;

import com.marv.business.entities.User;

public class ListUsersHelper {

	private ArrayList<User> users;

	public ListUsersHelper(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<User> getUsers() {
		return users;
	}
}
