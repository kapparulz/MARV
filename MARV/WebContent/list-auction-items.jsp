<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="helper"
	type="com.marv.ui.process.components.helpers.ListAuctionItemsHelper"
	scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>List Auction Items</title>
	<base href="<%= request.getContextPath() %>" />
</head>
<body>
	<table>
		<caption>Auction Items</caption>
		<tr>
			<th>ID</th>
			<th>Category</th>
			<th>User</th>
			<th>Name</th>
			<th>Description</th>
			<th>Start Price</th>
			<th>Buyout Price</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Picture</th>
			<th>Is Sold</th>
		</tr>
		<% for(int i = 0; i < helper.getAuctionItems().size(); i++) { %>
			<tr>
				<td><%= helper.getAuctionItems().get(i).getId() %></td>
				<td><%= helper.getAuctionItems().get(i).getCategoryName() %></td>
				<td><%= helper.getAuctionItems().get(i).getUserName() %></td>
				<td><%= helper.getAuctionItems().get(i).getName() %></td>
				<td><%= helper.getAuctionItems().get(i).getStartPrice() %></td>
				<td><%= helper.getAuctionItems().get(i).getByoutPrice() %></td>
				<td><%= helper.getAuctionItems().get(i).getStartDate().getTime() %></td>
				<td><%= helper.getAuctionItems().get(i).getEndDate().getTime() %></td>
				<td><%= helper.getAuctionItems().get(i).isSold() %></td>
				<td>
					<a href="?command=AuctionItem&id=<%= helper.getAuctionItems().get(i).getId() %>">Edit</a>
				</td>
			</tr>
		<% } %>
	</table>
	<a href="?command=AuctionItem">New Auction Item</a>
</body>
</html>