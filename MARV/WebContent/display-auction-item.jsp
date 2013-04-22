<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="helper"
	type="com.marv.ui.process.components.helpers.AuctionItemHelper"
	scope="request" />
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Auction Item</title>
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
			<h1>Auction Item</h1>
			<dl>
				<dt>Title</dt>
				<dd><%=helper.getAuctionItem().getName()%></dd>
				<dt>Description</dt>
				<dd><%=helper.getAuctionItem().getDescription()%></dd>
				<dt>Start Price</dt>
				<dd><%=helper.getAuctionItem().getStartPrice()%></dd>
				<dt>Byout Price</dt>
				<dd><%=helper.getAuctionItem().getByoutPrice()%></dd>
				<dt>Start Date</dt>
				<dd><%=helper.getAuctionItemStartDate()%></dd>
				<dt>End Date</dt>
				<dd><%=helper.getAuctionItemEndDate()%></dd>
			</dl>
			<h1>Bid</h1>
			<form action="?command=Bid" method="post">
				<label for="your-bid">Your bid: </label>
				<input type="text" name="institutionName" id="your-bid" />
				<input type="submit" value="Submit" />
			</form>
		</div>
	</div>
	<%@ include file="inc/scripts.jsp"%>
</body>
</html>
