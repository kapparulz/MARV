package com.marv.business.entities;

public abstract class DomainObject {

	private static final long PLACEHOLDER_ID = -1;
	
	private long id = PLACEHOLDER_ID;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public boolean isNew() {
		return id == PLACEHOLDER_ID;
	}
}
