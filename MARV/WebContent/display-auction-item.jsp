<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="helper"
	type="com.marv.ui.process.components.helpers.AuctionItemHelper"
	scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Auction Item</title>
	<base href="<%= request.getContextPath() %>" />
</head>
<body>
	<%@ include file="inc/header.jsp" %>
	<h1>Auction Item</h1>
	<dl>
		<dt>Title</dt>
		<dd><%= helper.getAuctionItem().getName() %></dd>
		<dt>Description</dt>
		<dd><%= helper.getAuctionItem().getDescription() %></dd>
		<dt>Start Price</dt>
		<dd><%= helper.getAuctionItem().getStartPrice() %></dd>
		<dt>Byout Price</dt>
		<dd><%= helper.getAuctionItem().getByoutPrice() %></dd>
		<dt>Start Date</dt>
		<dd><%= helper.getAuctionItemStartDate() %></dd>
		<dt>End Date</dt>
		<dd><%= helper.getAuctionItemEndDate() %></dd>
	</dl>
	<h1>Bid</h1>
	<form action="?command=Bid" method="post">
		<label for="your-bid">Your bid: </label>
		<input type="text" name="institutionName" id="your-bid" />
		<input type="submit" value="Submit" />
	</form>
</body>
</html>