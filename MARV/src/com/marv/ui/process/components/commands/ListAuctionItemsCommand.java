package com.marv.ui.process.components.commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import com.marv.business.entities.AuctionItem;
import com.marv.ui.process.components.helpers.ListAuctionItemsHelper;
import com.marv.util.operationalmanagement.ApplicationException;

public class ListAuctionItemsCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		long categoryId;
		try {
			categoryId = Long.parseLong(request.getParameter("category"));
		} catch (NumberFormatException e) {
			throw new ApplicationException("Invalid auction item category.", e);
		}
		ArrayList<AuctionItem> items = 
				getStorage().findAllAuctionItemsByCategory(categoryId);
		request.setAttribute("helper", new ListAuctionItemsHelper(items));
		forward("/list-auction-items.jsp");
	}

	@Override
	public void processPost() throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
