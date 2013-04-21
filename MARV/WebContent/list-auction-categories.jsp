<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="helper"
	type="com.marv.ui.process.components.helpers.ListAuctionCategoriesHelper"
	scope="request" />
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>List Auction Categories</title>
	<base href="<%= request.getContextPath() %>" />
	<style>
		<%@ include file="CSS/style.css" %>
	</style>
</head>
<body>
	<%@ include file="inc/header.jsp" %>
	<h1>Auction Categories</h1>
	<%= helper.printCategoriesTree() %>
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script>
		$(window).load(function() {
		 
		});
	</script>
</body>
</html>