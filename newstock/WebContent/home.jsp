<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page errorPage="errorPage1.jsp"%>
<jsp:useBean id="validat" class="beans.ValidateLogin" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<%@ include file="head.jsp"%>
</head>
<body >
	<%@ include file="itop.jsp"%>
	<br class="clear" />
	<div class="wrapper col5">
		<div id="container">
	<% 
		if (validat.getUser() == null) { 
	%> 
	<jsp:forward page="index.jsp"></jsp:forward> 
	<% 
		} 
	%><%@ include file="verticalmenu.jsp"%> 
	<div class="p">
	<p style="text-align:left;margin-left:10px;">	
		Now you can add your product to your stock by clicking on <b>Add product </b> menu <br>
		
		and you can also enter details about sold product and returned product <br>
		you can also check your available product by clicking on <b>Available product</b> menu on left side.
		
		
		Using this application you can manage your stock easily and efficiently
		<p>
	</div>

	<hr />
</div></div>


	<br />
	<%@ include file="footer.jsp"%>
</body>
</html>