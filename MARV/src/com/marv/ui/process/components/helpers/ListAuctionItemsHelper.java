package com.marv.ui.process.components.helpers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
