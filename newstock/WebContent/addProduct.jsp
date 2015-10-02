<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page errorPage="errorPage1.jsp"%>
<jsp:useBean id="validat" class="beans.ValidateLogin" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><script type="text/javascript" src="jscripts/addproduct.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new product</title><%@ include file="head.jsp"%>
<script type="text/javascript" src="jscripts/addproduct.js"></script>
</head>
<body><%@ include file="itop.jsp"%>
	<br class="clear" />
	<div class="wrapper col5">
		<div id="container"><%
		if (validat.getUser() == null) {
	%>
	<jsp:forward page="index.jsp"></jsp:forward>
	<%
		}
	%><%@ include file="verticalmenu.jsp"%>
	<div class="p"><% String msg=null;
msg=(String)request.getAttribute("msg");
if(msg!=null)
{
out.print(msg);
}
     %><br><br><br><h4>Add New Product</h4>
		<form action="AddProductServlet" onsubmit="return validateForm(this);" method="post">
			Enter Product name<input type="text" name="pname" required><input
				type="hidden" name="user"value="<%=validat.getUser() %>"><input type="submit" value="submit">
		</form>
	</div></div></div>
	<%@ include file="footer.jsp"%>
</body>
</html>