<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="helper"
	type="com.marv.ui.process.components.helpers.ListInstitutionsHelper"
	scope="request" />
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>List Institutions</title>
	<base href="<%= request.getContextPath() %>" />
	<style>
		<%@ include file="CSS/style.css" %>
	</style>
</head>
<body>
	<%@ include file="inc/header.jsp" %>
	<table>
		<caption>Institutions</caption>
		<tr>
			<th>ID</th>
			<th>Name</th>
		</tr>
		<% for(int i = 0; i < helper.getInstitutions().size(); i++) { %>
			<tr>
				<td><%= helper.getInstitutions().get(i).getId() %></td>
				<td><%= helper.getInstitutions().get(i).getName() %></td>
				<td>
					<a href="?command=Institution&id=<%= helper.getInstitutions().get(i).getId() %>">Edit</a>
				</td>
			</tr>
		<% } %>
	</table>
	<a href="?command=Institution">New Institution</a>
</body>
</html>