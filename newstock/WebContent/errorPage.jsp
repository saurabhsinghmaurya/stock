<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isErrorPage="true"%>
<%@ page errorPage="errorPage.jsp"%>

<jsp:useBean id="validat" class="beans.ValidateLogin" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>error page</title><%@ include file="head.jsp"%>
</head>
<body>
	<h4>
		<%validat.setUser(null); %>
		Exception=<%=exception.getClass() %><br> Message=<%=exception.getMessage() %></h4>
	<%@ include file="footer.jsp"%>
</body>
</html>