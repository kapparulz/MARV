package com.marv.ui.process.components.helpers;

import java.util.ArrayList;

import com.marv.business.entities.AuctionItem;

public class ListAuctionItemsHelper {

	private ArrayList<AuctionItem> auctionItems;

	public ListAuctionItemsHelper(ArrayList<AuctionItem> auctionItems) {
		this.auctionItems = auctionItems;
	}

	public ArrayList<AuctionItem> getAuctionItems() {
		return auctionItems;
	}
	
}
