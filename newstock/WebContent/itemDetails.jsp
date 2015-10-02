<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="dbdata.*"%>
<%@page import="beans.*"%>
<%@page import="java.util.*"%>
<%@ page errorPage="errorPage1.jsp"%>
<jsp:useBean id="validat" class="beans.ValidateLogin" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><%@ include file="head.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
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
			%><%@ include file="verticalmenu.jsp"%><div
				class="p">
				<table>
					<tr>
						<th>S.NO</th>
						<th>ARTCICLE ID</th>
						<th>BRAND NAME</th>
						<th>QUANTITY</th>
						<th>PRICE</th>
						<TH>ACTION</TH>
						<TH>DATE</TH>
					</tr>
					<tr>
						<%
							int i = 0;
							RetrieveItemDetails db = new RetrieveItemDetails();
							LinkedList<ItemDetails> ll = db.detailsTable(validat.getUser(),
									request.getParameter("product"),
									request.getParameter("aid"));
							Iterator<ItemDetails> it = ll.iterator();
							while (it.hasNext()) {
								ItemDetails rp = it.next();
						%>
						<td><%=++i%></td>
						<td><%=rp.getAid()%></td>
						<td><%=rp.getBrand()%></td>
						<td><%=rp.getQuantity()%></td>
						<td><%=rp.getPrice()%></td>
						<td><%=rp.getAction()%></td>
						<td><%=rp.getDate()%></td>

					</tr>
					<%
						}
					%>
				</table>
				Total Quantity=<%=request.getParameter("q") %>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%></body>
</html>