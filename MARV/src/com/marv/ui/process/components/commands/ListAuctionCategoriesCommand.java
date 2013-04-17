package com.marv.ui.process.components.commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import com.marv.business.entities.AuctionCategory;
import com.marv.ui.process.components.helpers.ListAuctionCategoriesHelper;

public class ListAuctionCategoriesCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		ArrayList<AuctionCategory> categories = 
				(ArrayList<AuctionCategory>) getStorage().findAll(AuctionCategory.class);
		request.setAttribute("helper", new ListAuctionCategoriesHelper(categories));
		forward("/list-auction-categories.jsp");
	}

	@Override
	public void processPost() throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
