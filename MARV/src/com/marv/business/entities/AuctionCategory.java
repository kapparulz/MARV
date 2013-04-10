package com.marv.business.entities;

import java.util.ArrayList;

public class AuctionCategory extends DomainObject {

	private String name;
	
	private AuctionCategory parent;
	
	private ArrayList<AuctionCategory> children;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AuctionCategory getParent() {
		return parent;
	}

	public void setParent(AuctionCategory parent) {
		this.parent = parent;
	}

	public ArrayList<AuctionCategory> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<AuctionCategory> children) {
		this.children = children;
	}
}
