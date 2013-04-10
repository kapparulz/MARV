package com.marv.ui.process.components.helpers;

import com.marv.business.entities.Institution;

public class InstitutionHelper {

	private Institution institution;
	
	public InstitutionHelper(Institution institution) {
		this.institution = institution;
	}
	
	public String getName() {
		return institution.getName();
	}
}
