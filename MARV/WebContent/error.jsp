<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Error</title>
	<base href="<%= request.getContextPath() %>/" />
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
			<h1>Error</h1>
			<div><%= exception.toString() %></div>
			<div>
				<h2>StackTrace</h2>
				<pre><%
					StringWriter stringWriter = new StringWriter();
					PrintWriter printWriter = new PrintWriter(stringWriter);
					exception.printStackTrace(printWriter);
					out.println(stringWriter);
					printWriter.close();
					stringWriter.close();
					%>
				</pre>
			</div>
		</div>
	</div>
	<%@ include file="inc/scripts.jsp"%>
</body>
</html>