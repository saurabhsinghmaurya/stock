<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@page import="dbdata.*"%>
<%@page import="beans.*"%>
<%@page import="java.util.*"%>
<%@ page errorPage="errorPage1.jsp"%>
<jsp:useBean id="validat" class="beans.ValidateLogin" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Print</title><%@ include file="head.jsp"%>
</head>
<body marginheight="1"><%@ include file="itop.jsp"%>
	<br class="clear" />
	<div class="wrapper col5">
		<div id="container"><%
		if (validat.getUser() == null) {
	%>
	<jsp:forward page="index.jsp"></jsp:forward>
	<%
		}
	%><%@ include file="verticalmenu.jsp"%>
<div class="p" ><table>
			<tr>
				<th>S.NO</th>
				<th>PRODUCT NAME</th>
				
			</tr><tr>
			<% 
			int i=0;
		RetrieveProductDb db = new RetrieveProductDb();
		LinkedList<RetrieveProduct> ll = db.allProduct(validat.getUser());
		Iterator<RetrieveProduct> it = ll.iterator();
		
		while (it.hasNext()) {
			RetrieveProduct rp = it.next();
	%>
	<td><%=++i %></td>
				<td><a href="subtable.jsp?product=<%=rp.getProduct()%>">
						<%out.print(rp.getProduct()+"<br>");%>
				</a></td></tr><%  } %>
	</table></div></div></div>
<%@ include file="footer.jsp"%>
</body>
</html>