package com.marv.business.entities;


public class Institution extends DomainObject {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		if(name.length() < 1) {
			throw new IllegalArgumentException("Name must not be empty.");
		}
		if(name.length() > 255) {
			throw new IllegalArgumentException("Name must not be longer than 255 characters.");
		}
	}

}
