<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="helper" 
	type="com.marv.ui.process.components.helpers.UserHelper" 
	scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>User</title>
	<base href="<%= request.getContextPath() %>" />
</head>
<body>
	<%@ include file="inc/header.jsp" %>
	<form action="" method="post">
		<input type="hidden" name="id" value="<%= helper.getId() %>" />
		<span class="error"><%= helper.getError("id") %></span>
		
		<input type="hidden" name="type" value="0" />
		<span class="error"><%= helper.getError("type") %></span>
		
		<label for="user-name">User: </label>
		<input type="text" name="username" id="user-name" value="<%= helper.getUsername() %>" />
		<span class="error"><%= helper.getError("username") %></span>
		
		<label for="pass-word">Password: </label>
		<input type="password" name="password" id="pass-word" value="<%= helper.getPassword() %>" />
		<span class="error"><%= helper.getError("password") %></span>
		
		<label for="e-mail">Email: </label>
		<input type="text" name="email" id="e-mail" value="<%= helper.getEmail() %>" />
		<span class="error"><%= helper.getError("email") %></span>
		
		<label for="telephone">Phone: </label>
		<input type="text" name="phone" id="telephone" value="<%= helper.getPhone() %>" />
		<span class="error"><%= helper.getError("phone") %></span>
		
		<label for="address">Address: </label>
		<input type="text" name="address" id="address" value="<%= helper.getAddress() %>" />
		<span class="error"><%= helper.getError("address") %></span>
		
		<label for="first-name">First Name: </label>
		<input type="text" name="firstName" id="first-name" value="<%= helper.getFirstName() %>" />
		<span class="error"><%= helper.getError("firstName") %></span>
		
		<label for="last-name">Last Name: </label>
		<input type="text" name="lastName" id="last-name" value="<%= helper.getLastName() %>" />
		<span class="error"><%= helper.getError("lastName") %></span>
		
		<label for="institutions">Institutions: </label>
		<select id="institutions" name="institutions">
			<% for(int i = 0; i < helper.getInstitutions().size(); i++) { %>
				<option value="<%= helper.getInstitutions().get(i).getId() %>">
					<%= helper.getInstitutions().get(i).getName() %>
				</option>			
			<% } %>
		</select>
		<span class="error"><%= helper.getError("institutions") %></span>
		
		<input type="submit" value="Save" />
	</form>
	<form action="?command=DeleteInstitution" method="post">
		<input type="hidden" name="id" value="<%= helper.getId() %>" />
		<input type="submit" value="Delete" />
	</form>
	 <jsp:getProperty property="username" name="helper"/>
</body>
</html>