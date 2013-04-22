<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="helper"
	type="com.marv.ui.process.components.helpers.ListUsersHelper"
	scope="request" />
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>List Users</title>
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
			<table class="table table-striped table-hover">
				<caption>Users</caption>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Actions</th>
				</tr>
				<% for (int i = 0; i < helper.getUsers().size(); i++) { %>
				<tr>
					<td><%=helper.getUsers().get(i).getId()%></td>
					<td><%=helper.getUsers().get(i).getUsername()%></td>
					<td><a class="btn btn-primary btn-small"
						href="?command=User&id=<%=helper.getUsers().get(i).getId()%>">Edit</a>
					</td>
				</tr>
				<% } %>
			</table>
			<a class="btn btn-primary" href="?command=User">New User</a>
		</div>
	</div>
	<%@ include file="inc/scripts.jsp"%>
</body>
</html>