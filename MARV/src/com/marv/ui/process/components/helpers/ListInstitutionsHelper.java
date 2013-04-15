package com.marv.ui.process.components.helpers;

import java.io.Serializable;
import java.util.ArrayList;

import com.marv.business.entities.Institution;

public class ListInstitutionsHelper implements Serializable {

	private ArrayList<Institution> institutions;

	public ListInstitutionsHelper(ArrayList<Institution> institutions) {
		this.institutions = institutions;
	}

	public ArrayList<Institution> getInstitutions() {
		return institutions;
	}
}
