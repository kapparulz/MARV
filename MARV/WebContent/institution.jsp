<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="helper"
	class="com.marv.ui.process.components.helpers.InstitutionHelper"
	scope="request" />
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Institution</title>
	<base href="<%= request.getContextPath() %>" />
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/style.css" />
</head>
<body>
	<%@ include file="inc/header.jsp" %>
	<form action="" method="post">
		<input type="hidden" name="id" value="<%= helper.getId() %>" />
		<span class="error"><%= helper.getError("id") %></span>
		<label for="institution-name">Institution: </label>
		<input type="text" name="institutionName" id="institution-name" value="<%= helper.getInstitutionName() %>" />
		<span class="error"><%= helper.getError("institutionName") %></span>
		<input type="submit" value="Save" />
	</form>
	<form action="?command=DeleteInstitution" method="post">
		<input type="hidden" name="id" value="<%= helper.getId() %>" />
		<input type="submit" value="Delete" />
	</form>
</body>
</html>