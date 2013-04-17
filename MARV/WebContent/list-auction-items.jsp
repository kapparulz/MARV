<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.marv.ui.process.components.helpers.AuctionItemHelper"%>
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
	<%@ include file="inc/header.jsp" %>
	<table>
		<caption>Auction Items</caption>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Start Price</th>
			<th>Buyout Price</th>
			<th>Start Date</th>
			<th>End Date</th>
		</tr>
		<% for(int i = 0; i < helper.getAuctionItems().size(); i++) { %>
			<tr>
				<td>
					<a href="?command=DisplayAuctionItem&id=<%= helper.getAuctionItems().get(i).getId() %>">
						<%= helper.getAuctionItems().get(i).getName() %>
					</a>
				</td>
				<td><%= helper.getAuctionItems().get(i).getDescription() %></td>
				<td><%= helper.getAuctionItems().get(i).getStartPrice() %></td>
				<td><%= helper.getAuctionItems().get(i).getByoutPrice() %></td>
				<td><%= AuctionItemHelper.formatDate(helper.getAuctionItems().get(i).getStartDate()) %></td>
				<td><%= AuctionItemHelper.formatDate(helper.getAuctionItems().get(i).getEndDate()) %></td>
			</tr>
		<% } %>
	</table>
</body>
</html>