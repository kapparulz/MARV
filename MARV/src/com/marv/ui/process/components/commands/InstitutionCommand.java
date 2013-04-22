package com.marv.ui.process.components.commands;

import java.io.IOException;

import javax.servlet.ServletException;

import com.marv.business.entities.Institution;
import com.marv.ui.process.components.helpers.InstitutionHelper;

public class InstitutionCommand extends FrontCommand {	

	@Override
	public void process() throws ServletException, IOException {
		Institution institution = null;
		String idStr = request.getParameter("id");
		if(idStr == null || idStr.equals("-1")) {
			institution = new Institution();
		} else {
			long id = Long.parseLong(idStr);
			if(id > 0) {
				institution = (Institution) getStorage().find(id, Institution.class);
				if(institution == null) {
					forward("/missing-record.jsp");
					return;
				}
			}
		}
		request.setAttribute("helper", new InstitutionHelper(institution));
		forward("/institution.jsp");
	}

	@Override
	public void processPost() throws ServletException, IOException {
		Institution institution = new Institution();
		InstitutionHelper helper = new InstitutionHelper(institution);
		helper.setId(request.getParameter("id"));
		helper.setInstitutionName(request.getParameter("institutionName"));
		if(helper.getErrors().isEmpty()) {
			// Save institution
			if(getStorage().save(helper.getInstitution())) {
				response.sendRedirect(request.getContextPath());
				return;
			}
		}
		// return to form
		request.setAttribute("helper", helper);
		forward("/institution.jsp");
	}
}
