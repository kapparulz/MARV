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
			<form action="" method="post">
				<input type="hidden" name="id" value="<%= helper.getId() %>" />
				<span class="error"><%= helper.getError("id") %></span>
				<label for="institution-name">Institution: </label>
				<input type="text" name="institutionName" id="institution-name" 
						value="<%= helper.getInstitutionName() %>" />
				<span class="error"><%= helper.getError("institutionName") %></span>
				<input type="submit" value="Save" class="btn-success"/>
			</form>
			<form action="?command=DeleteInstitution" method="post">
				<input type="hidden" name="id" value="<%= helper.getId() %>" />
				<input type="submit" value="Delete" class="btn-danger"/>
			</form>
		</div>
	</div>	
	<%@ include file="inc/scripts.jsp" %>
</body>
</html>
