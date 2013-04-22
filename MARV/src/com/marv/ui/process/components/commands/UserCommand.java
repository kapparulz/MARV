package com.marv.ui.process.components.commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import com.marv.business.entities.DomainObject;
import com.marv.business.entities.Institution;
import com.marv.business.entities.User;
import com.marv.ui.process.components.helpers.UserHelper;

public class UserCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		User user = null;
		String idStr = request.getParameter("id");
		if(idStr == null || idStr.equals("-1")) {
			user = new User();
		} else {
			long id = Long.parseLong(idStr);
			if(id > 0) {
				user = (User) getStorage().find(id, User.class);
			}
		}
		@SuppressWarnings("unchecked")
		ArrayList<Institution> institutions = (ArrayList<Institution>) getStorage().findAll(Institution.class);
		request.setAttribute("helper", new UserHelper(user, institutions));
		forward("/user.jsp");
	}

	@Override
	public void processPost() throws ServletException, IOException {
		User user = new User();
		
		@SuppressWarnings("unchecked")
		ArrayList<Institution> institutions = (ArrayList<Institution>) getStorage().findAll(Institution.class);
		
		UserHelper helper = new UserHelper(user, institutions);
		helper.setId(request.getParameter("id"));
		helper.setUsername(request.getParameter("username"));
		helper.setPassword(request.getParameter("password"));
		helper.setType(request.getParameter("type"));
		helper.setEmail(request.getParameter("email"));
		helper.setPhone(request.getParameter("phone"));
		helper.setAddress(request.getParameter("address"));
		helper.setFirstName(request.getParameter("firstName"));
		helper.setLastName(request.getParameter("lastName"));
		helper.setInstitutionId(request.getParameter("institutions"));
		
		if(helper.getErrors().isEmpty()) {
			if(getStorage().save(helper.getUser())) {
				response.sendRedirect(request.getContextPath());
				return;
			}	
		}
		// return to form
		request.setAttribute("helper", helper);
		forward("/user.jsp");
	}
}

