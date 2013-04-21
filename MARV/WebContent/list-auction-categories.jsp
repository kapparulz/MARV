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
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>List Auction Categories</title>
	<base href="<%= request.getContextPath() %>" />
	<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet">
	<link href="http://bootswatch.com/cosmo/bootstrap.css" rel="stylesheet">
	<link href="//netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" rel="stylesheet">
	

	<style>
* {
	border-radius: 0 !important;
	box-shadow: none !important;
	filter: progid:DXImageTransform.Microsoft.gradient(enabled = false) !important;
	text-shadow: none !important;
	font-family: "Open Sans", Arial, Helvetica, sans-serif;
	font-weight: 400;
}

body .container{
	width: 97%;
	padding-left: 1.5%;
	padding-right: 1.5%;
}
	
/* Navbar */

.navbar *{
	text-shadow:none !important;
}

.navbar{
	background: ;
}

.navbar .brand{
	color: #eee !important;
}

.navbar .container{
	width: 97% !important;
}

.navbar .nav > li > a{
	font-size: 13px !important;
	color: #fff !important;
}

.navbar i{
	margin-right: 3px;
}

.navbar .caret{
	border-top-color:#fff !important;
	border-bottom-color:#fff !important;
}

.navbar .nav-user-pic{
	width: 20px;
	margin-right: 10px;
}

.navbar .badge{
	margin-left: 5px;
}

/* Responsive */

@media (max-width: 480px){

}

@media (max-width: 767px){
	body{
		margin: 0 auto;
	}
	body .container{
		width: 95%;
		padding-left: 2.5%;
		padding-right: 2.5%;
	}	
	.content{
		margin-left: -20px;
		margin-right: -20px;
	}
}

@media (min-width: 768px) and (max-width: 979px){

}
	</style>
</head>
<body>
	<%@ include file="inc/aboveheader.jsp" %>
	<%@ include file="inc/header.jsp" %>
	<h1>Auction Categories</h1>
	<%= helper.printCategoriesTree() %>
	
	
	
	<%@ include file="inc/scripts.jsp" %>
</body>
</html>