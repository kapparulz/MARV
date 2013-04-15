<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="helper"
	type="com.marv.ui.process.components.helpers.ListInstitutionsHelper"
	scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>List Institutions</title>
	<base href="<%= request.getContextPath() %>" />
</head>
<body>
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