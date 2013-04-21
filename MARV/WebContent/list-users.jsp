<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="helper"
	type="com.marv.ui.process.components.helpers.ListUsersHelper"
	scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>List Users</title>
	<base href="<%= request.getContextPath() %>" />
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/style.css" />
</head>
<body>
	<%@ include file="inc/header.jsp" %>
	<table class="table table-striped table-hover">
		<caption>Users</caption>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Actions</th>
		</tr>
		<% for(int i = 0; i < helper.getUsers().size(); i++) { %>
			<tr>
				<td><%= helper.getUsers().get(i).getId() %></td>
				<td><%= helper.getUsers().get(i).getUsername() %></td>
				<td>
					<a class="btn btn-primary btn-small" href="?command=User&id=<%= helper.getUsers().get(i).getId() %>">Edit</a>
				</td>
			</tr>
		<% } %>
	</table>
	<a class="btn btn-primary" href="?command=User">New User</a>
</body>
</html>