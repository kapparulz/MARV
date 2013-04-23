package com.marv.ui.process.components.helpers;

import java.util.ArrayList;

import com.marv.business.entities.AuctionCategory;

public class ListAuctionCategoriesHelper {

	private ArrayList<AuctionCategory> categories;

	public ListAuctionCategoriesHelper(ArrayList<AuctionCategory> categories) {
		this.categories = categories;
	}

	public ArrayList<AuctionCategory> getCategories() {
		return categories;
	}
	
	public String printCategoriesTree() {
		return printCategoriesTree(categories);
	}
	
	/**
	 * Recursive method to print unordered list of links to auction category
	 * pages.
	 * 
	 * @param tree
	 *            a tree of auction category items.
	 * @return nested unordered html list.
	 */
	private String printCategoriesTree(ArrayList<AuctionCategory> tree) {
		String result = "";
		if (tree != null && tree.size() > 0) {
			result += "<ul class='categoriesTree resultsList'>";
			for (AuctionCategory category : tree) {
				result += "<li>";
				result += "<a class='fancybox' href='#inline' title=''>";
				result += "<a href='?command=ListAuctionItems&amp;category="
						+ category.getId() + "'>";
				result += "<i class=''></i> "
						+ category.getName();
				result += "</a>";
				result += printCategoriesTree(category.getChildren());
				result += "</a>";
				result += "</li>";
			}
			result += "</ul>";
		}
		return result;
	}
}
