<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="helper" 
	type="com.marv.ui.process.components.helpers.UserHelper" 
	scope="request" />
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>User</title>
	<base href="<%=request.getContextPath()%>/" />
	<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/bootstrap-combined.min.css" rel="stylesheet">
	<link href="//netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="CSS/style2.css" />
</head>
<body>
	<%@ include file="inc/header.jsp" %>
	<%@ include file="inc/aboveheader.jsp" %>
	<div class="content">
		<%@ include file="inc/sidebar.jsp"%>
		<div class="mainbar">
			<form action="" method="post" class="form-horizontal">
				<fieldset>
					<legend>Add institution</legend>
					<input type="hidden" name="id" value="<%=helper.getId()%>" /> <span
						class="error"><%=helper.getError("id")%></span> <input
						type="hidden" name="type" value="0" /> <span class="error"><%=helper.getError("type")%></span>

					<div class="control-group">
						<label class="control-label" for="user-name">User:</label>
						<div class="controls">
							<input type="text" name="username" id="user-name"
								value="<%=helper.getUsername()%>" placeholder="User" /> <span
								class="help-inline error"><%=helper.getError("username")%></span>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="pass-word">Password: </label>
						<div class="controls">
							<input type="password" name="password" id="pass-word"
								value="<%=helper.getPassword()%>" placeholder="Password" /> <span
								class="help-inline error"><%=helper.getError("password")%></span>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="e-mail">Email: </label>
						<div class="controls">
							<input type="text" name="email" id="e-mail"
								value="<%=helper.getEmail()%>" placeholder="E-mail" /> <span
								class="help-inline error"><%=helper.getError("email")%></span>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="telephone">Phone: </label>
						<div class="controls">
							<input type="text" name="phone" id="telephone"
								value="<%=helper.getPhone()%>" placeholder="Phone" /> <span
								class="help-inline error"><%=helper.getError("phone")%></span>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="address">Address: </label>
						<div class="controls">
							<input type="text" name="address" id="address"
								value="<%=helper.getAddress()%>" placeholder="Adress" /> <span
								class="help-inline error"><%=helper.getError("address")%></span>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="first-name">First Name:
						</label>
						<div class="controls">
							<input type="text" name="firstName" id="first-name"
								value="<%=helper.getFirstName()%>" placeholder="First Name" />
							<span class="help-inline error"><%=helper.getError("firstName")%></span>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="last-name">Last Name: </label>
						<div class="controls">
							<input type="text" name="lastName" id="last-name"
								value="<%=helper.getLastName()%>" placeholder="Last Name" />
							<span class="help-inline error"><%=helper.getError("lastName")%></span>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="institutions">Institutions:
						</label>
						<div class="controls">
							<select id="institutions" name="institutions">
								<% for (int i = 0; i < helper.getInstitutions().size(); i++) { %>
								<option value="<%=helper.getInstitutions().get(i).getId()%>">
									<%=helper.getInstitutions().get(i).getName()%>
								</option>
								<% } %>
							</select> <span class="help-inline error"><%=helper.getError("institutions")%></span>
						</div>
					</div>

					<div class="form-actions">
						<input type="submit" value="Save" class="btn-success" />
					</div>
				</fieldset>
			</form>
			<form class="form-horizontal" action="?command=DeleteInstitution" method="post">
				<div class="form-actions">
					<input type="hidden" name="id" value="<%=helper.getId()%>" />
					<input type="submit" value="Delete" class="btn-danger" />
				</div>
			</form>
			<jsp:getProperty property="username" name="helper" />
		</div>
	</div>
	<%@ include file="inc/scripts.jsp"%>
</body>
</html>
