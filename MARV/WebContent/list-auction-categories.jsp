<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="helper"
	type="com.marv.ui.process.components.helpers.ListAuctionCategoriesHelper"
	scope="request" />
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>List Auction Categories</title>
	<base href="<%= request.getContextPath() %>/" />
	<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/bootstrap-combined.min.css" rel="stylesheet">
	<link href="//netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="CSS/style2.css" />
</head>
<body>
	<%@ include file="inc/header.jsp" %>
	<%@ include file="inc/aboveheader.jsp" %>
	<div class="content">
		<%@ include file="inc/sidebar.jsp" %>
		<div class="mainbar">	
			<h1>Auction Categories</h1>	
			<%= helper.printCategoriesTree() %>	
		</div>
		<!-- END OF MAINBAR -->
	</div>
	<!-- END OF CONTENT -->
	<%@ include file="inc/scripts.jsp" %>
</body>
</html>