package com.marv.ui.process.components.helpers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.marv.business.entities.DomainObject;
import com.marv.business.entities.Institution;

public class InstitutionHelper implements Serializable {

	private Institution institution;
	
	private Map<String, String> errors;
	
	public InstitutionHelper() {
		this(new Institution());
	}
	
	public InstitutionHelper(Institution institution) {
		this.institution = institution;
	}
	
	public String getInstitutionName() {
		if(institution.getName() != null) {
			return institution.getName();
		} else {
			return ""; 
		}
	}
	
	public void setInstitutionName(String name) {
		try {
			institution.setName(name);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			getErrors().put("institutionName", e.getMessage());
		}
	}
	
	public String getId() {
		return "" + institution.getId();
	}
	
	public void setId(String idStr) {
		try {
			long id = Long.parseLong(idStr);
			institution.setId(id);
		} catch (IllegalArgumentException e) {
			getErrors().put("id", e.getMessage());
		}
	}

	public String getError(String fieldName) {
		if(errors == null || !errors.containsKey(fieldName)) {
			return "";
		} else {
			return errors.get(fieldName);
		}
	}
	
	public Map<String, String> getErrors() {
		if(errors == null) {
			errors = new HashMap<String, String>();
		}
		return errors;
	}

	public DomainObject getInstitution() {
		return institution;
	}
}
