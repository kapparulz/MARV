package com.marv.ui.process.components.commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import com.marv.business.entities.User;
import com.marv.ui.process.components.helpers.ListUsersHelper;

public class ListUsersCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		ArrayList<User> users = 
				(ArrayList<User>) getStorage().findAll(User.class);
		request.setAttribute("helper", new ListUsersHelper(users));
		forward("/list-users.jsp");
	}

	@Override
	public void processPost() throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
