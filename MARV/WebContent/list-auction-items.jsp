<%@page import="com.marv.ui.process.components.helpers.AuctionItemHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="helper"
	type="com.marv.ui.process.components.helpers.ListAuctionItemsHelper"
	scope="request" />
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>List Auction Items</title>
	<base href="<%=request.getContextPath()%>/" />
	<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/bootstrap-combined.min.css" rel="stylesheet">
	<link href="//netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="CSS/style2.css" />
</head>
<body>
	<%@ include file="inc/header.jsp"%>
	<%@ include file="inc/aboveheader.jsp"%>
	<div class="content">
		<%@ include file="inc/sidebar.jsp"%>
		<div class="mainbar">
			<table class="table">
				<caption>Auction Items</caption>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Start Price</th>
					<th>Buyout Price</th>
					<th>Start Date</th>
					<th>End Date</th>
				</tr>
				<% for (int i = 0; i < helper.getAuctionItems().size(); i++) { %>
					<tr>
						<td>
							<a href="?command=DisplayAuctionItem&id=<%=helper.getAuctionItems().get(i).getId()%>">
								<%=helper.getAuctionItems().get(i).getName()%>
							</a>
						</td>
						<td><%=helper.getAuctionItems().get(i).getDescription()%></td>
						<td><%=helper.getAuctionItems().get(i).getStartPrice()%></td>
						<td><%=helper.getAuctionItems().get(i).getByoutPrice()%></td>
						<td><%=AuctionItemHelper.formatDate(helper.getAuctionItems().get(i).getStartDate())%></td>
						<td><%=AuctionItemHelper.formatDate(helper.getAuctionItems().get(i).getEndDate())%></td>
					</tr>
				<% } %>
			</table>
		</div>
	</div>
	<%@ include file="inc/scripts.jsp"%>
</body>
</html>
