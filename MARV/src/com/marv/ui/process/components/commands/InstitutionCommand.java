package com.marv.ui.process.components.commands;

import java.io.IOException;

import javax.servlet.ServletException;

import com.marv.business.entities.Institution;
import com.marv.ui.process.components.helpers.InstitutionHelper;
import com.marv.ui.process.components.helpers.UserHelper;

public class InstitutionCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		Institution institution = (Institution) getStorage().find(id, Institution.class);
		request.setAttribute("helper", new InstitutionHelper(institution));
		forward("/institution.jsp");
	}

}
