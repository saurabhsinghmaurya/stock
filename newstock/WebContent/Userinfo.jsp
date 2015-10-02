<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Info</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<%@ include file="head.jsp"%>
</head>
<body><%@ include file="topborder.jsp"%>
	<br class="clear" />
	<div class="wrapper col5">
		<div id="container"><div class="p">
	<h1 align="center">User Information</h1>
	<h4>Registration successful</h4>
	<table align="center"style="background-color: rgb(220,220,220);">
		<tr>
			<td style="height: 25px; width: 94px;">Name</td>
			<td>
				<% out.println(" <b>" + request.getParameter("user") + "</b>"
					+ "<br>");%>
			</td>
		</tr>
		<tr>
			<td>Email id</td>
			<td>
				<% out.println(" <b>" + request.getParameter("email") + "</b>"
					+ "<br>");%>
			</td>
		</tr>
		<tr>
			<td>Password</td>
			<td>
				<% out.println(" ******");%>
			</td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>
				<% out.println(" <b>" + request.getParameter("gen") + "</b>"
					+ "<br>");%>	
			</td>
		</tr>
		<tr>
			<td>mobile</td>
			<td>
				<% out.println(" <b>" + request.getParameter("mobile") + "</b>"
					+ "<br>");%>
			</td>
		</tr>
		<tr>
			<td>Address</td>
			<td>
				<% out.println(" <b>" + request.getParameter("add") + "</b>"
					+ "<br>");%>
			</td>
		</tr>
	</table></div></div></div><%@ include file="footer.jsp"%>
</body>
</html>