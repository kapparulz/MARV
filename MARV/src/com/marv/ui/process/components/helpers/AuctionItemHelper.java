package com.marv.ui.process.components.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.marv.business.entities.AuctionItem;

public class AuctionItemHelper {

	private AuctionItem auctionItem;

	public AuctionItemHelper(AuctionItem item) {
		this.auctionItem = item;
	}

	public AuctionItem getAuctionItem() {
		return auctionItem;
	}
	
	public String getAuctionItemStartDate() {
		return formatDate(auctionItem.getStartDate());
	}
	
	public String getAuctionItemEndDate() {
		return formatDate(auctionItem.getEndDate());
	}
	
	public static String formatDate(Calendar calendar) {
		String result = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (calendar != null) {
			result = sdf.format(calendar.getTime());
		}
		return result;
	}
}
