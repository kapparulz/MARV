package com.marv.ui.process.components.commands;

import java.io.IOException;

import javax.servlet.ServletException;

import com.marv.business.entities.User;
import com.marv.ui.process.components.helpers.UserHelper;

public class UserCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		//User user = User.findIdentified(Long.parseLong(request.getParameter("id")));
//		User user = new User();
//		user.setUsername(request.getParameter("username"));
		long id = Long.parseLong(request.getParameter("id"));
		User user = (User) getStorage().find(id, User.class);
		request.setAttribute("helper", new UserHelper(user));
		forward("/user.jsp");
	}

	@Override
	public void processPost() throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
