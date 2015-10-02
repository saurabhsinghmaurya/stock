<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isErrorPage="true"%>
<%@ page errorPage="errorPage1.jsp"%>

<jsp:useBean id="validat" class="beans.ValidateLogin" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>error page</title><%@ include file="head.jsp"%>
</head>
<body><%@ include file="itop.jsp"%>
	<br class="clear" />
	<div class="wrapper col5"><%@ include file="verticalmenu.jsp"%>
		<div id="container"><div class="p">
	<h4>
		
		Exception=<%=exception.getClass() %><br> Message=<%=exception.getMessage() %></h4></div></div></div>
	<%@ include file="footer.jsp"%>
</body>
</html>