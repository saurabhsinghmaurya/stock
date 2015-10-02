<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="dbdata.*"%>
<%@page import="beans.*"%>

<%@ page errorPage="errorPage1.jsp"%>
<jsp:useBean id="validat" class="beans.ValidateLogin" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><%@ include file="head.jsp"%>
<script type="text/javascript" src="jscripts/addexitproduct.js"></script>
<script type="text/javascript" src="jscripts/ajax.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add item</title>

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
	%>
	<%
		RetrieveProductDb db = new RetrieveProductDb();
		LinkedList<RetrieveProduct> ll = db.allProduct(validat.getUser());
		Iterator<RetrieveProduct> it = ll.iterator();
	%>
<%@ include file="verticalmenu.jsp"%>
	<div class="p">
		<h4>Add inventory to the stock</h4><br>
		<%
			String msg = null;
			msg = (String) request.getAttribute("msg");
			if (msg != null) {
				out.print(msg);
			}
		%>

		<br>
		<form action="AddItemServlet" onsubmit="return validateForm(this);"
			method="post">
			select product <select
				style="height: 22px; width: 167px; border-radius: 10px;"
				name="product" onchange="showAid(this.value)" id="product"><option
					value="-1">------select-------</option>
				<%
					while (it.hasNext()) {
						RetrieveProduct rp = it.next();
				%>
				<option value="<%=rp.getProduct()%>"><%=rp.getProduct()%></option>

				<%
					}
				%>


			</select><br> <br> select Article id <select
				style="height: 22px; width: 167px; border-radius: 10px;" name="aid"
				id="aid" onchange="showBrand(dm product)"><option
					value="-1">------select-------</option>


			</select><br> <br> Quantity <input type="text" name="quantity"><br>
			<br>Price/Item <input type="text" name="price"><br>
			<input type="hidden" name="user" value="<%=validat.getUser()%>"><br>
			<input type="submit" value="submit">
		</form>
	</div></div></div>
	<%@ include file="footer.jsp"%>
</body>
</html>