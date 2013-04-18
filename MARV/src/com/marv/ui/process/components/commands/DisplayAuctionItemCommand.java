package com.marv.ui.process.components.commands;

import java.io.IOException;

import javax.servlet.ServletException;

import com.marv.business.entities.AuctionItem;
import com.marv.business.entities.Institution;
import com.marv.ui.process.components.helpers.AuctionItemHelper;
import com.marv.ui.process.components.helpers.InstitutionHelper;
import com.marv.util.operationalmanagement.ApplicationException;

public class DisplayAuctionItemCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		AuctionItem item = null;
		String idStr = request.getParameter("id");
		if(idStr == null || idStr.equals("-1")) {
			throw new ApplicationException("Wrong or missing ID.");
		} else {
			long id = Long.parseLong(idStr);
			if(id > 0) {
				item = (AuctionItem) getStorage().find(id, AuctionItem.class);
			}
		}
		request.setAttribute("helper", new AuctionItemHelper(item));
		forward("/display-auction-item.jsp");
	}

	@Override
	public void processPost() throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
