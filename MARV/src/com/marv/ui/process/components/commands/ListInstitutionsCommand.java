package com.marv.ui.process.components.commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import com.marv.business.entities.Institution;
import com.marv.ui.process.components.helpers.ListInstitutionsHelper;

public class ListInstitutionsCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		ArrayList<Institution> institutions = 
				(ArrayList<Institution>) getStorage().findAll(Institution.class);
		System.out.println(institutions.size());
		request.setAttribute("helper", new ListInstitutionsHelper(institutions));
		forward("/list-institutions.jsp");
	}

	@Override
	public void processPost() throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
