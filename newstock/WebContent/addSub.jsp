<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="dbdata.*"%>
<%@page import="beans.*"%>

<%@ page errorPage="errorPage1.jsp"%>
<jsp:useBean id="validat" class="beans.ValidateLogin" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jscripts/addsubcategory.js">
	
</script>
<script type="text/javascript" src="jscripts/ajax.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add sub</title>
</head><%@ include file="head.jsp"%>
</head>
<body><%@ include file="itop.jsp"%>
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
				<%
					String msg = null;
					msg = (String) request.getAttribute("msg");
					if (msg != null) {
						out.print(msg);
					}
				%><br><br>
				<h4>Add Subcategory</h4>
				<form action="AddSubServlet" onsubmit="return validateForm(this);"
					method="post">
					<br>
					<table>
						<tr>
						<td>select product</td></tr><tr>
						<td> <select
							style="height: 22px; width: 167px; border-radius: 10px;"
							name="product" onchange="showAid(this.value)" id="product">
								<option value="-1">------select-------</option>
								<%
									while (it.hasNext()) {
										RetrieveProduct rp = it.next();
								%>
								<option value="<%=rp.getProduct()%>"><%=rp.getProduct()%></option>

								<%
									}
								%>
						</select></td></tr>
						<tr><td>
						
						 Article id</td></tr>
						<tr><td><input type="text" name="aid"></td></tr>
						
						<tr><td>Brand Name</td></tr>
						<tr><td><input type="text" name="cname"></td></tr>
						<input type="hidden" name="user" value="<%=validat.getUser()%>">
						
						<tr><td><input type="submit" value="submit"></td></tr></table>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>