package com.marv.ui.process.components.commands;

import java.io.IOException;

import javax.servlet.ServletException;

import com.marv.business.entities.Institution;

public class DeleteInstitutionCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	public void processPost() throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		if(id > 0) {
			Institution institution = new Institution();
			institution.setId(id);
			if(getStorage().delete(institution) > 0) {
				response.sendRedirect(request.getContextPath());
			} else {
				response.sendRedirect(request.getHeader("referer"));
			}
		}
	}

}
