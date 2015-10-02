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
<title>Insert title here</title>
<%@ include file="head.jsp"%>
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
	%><%@ include file="verticalmenu.jsp"%>
	<div class="p">
		<table>
			<tr>
				<th>S.NO</th>
				<th>ARTCICLE ID</th>
				<th>BRAND NAME</th>
				<th>QUANTITY</th>
			</tr>
			<tr>
				<%
					int i = 0;
					RetrieveAidDb db = new RetrieveAidDb();
					LinkedList<RetrieveAid> ll = db.subTable(validat.getUser(),
							request.getParameter("product"));
					Iterator<RetrieveAid> it = ll.iterator();
					while (it.hasNext()) {
						RetrieveAid rp = it.next();
				%>
				<td><%=++i%></td>
				<td><a
					href="itemDetails.jsp?product=<%=request.getParameter("product")%>&aid=<%=rp.getArticleid()%>&q=<%=rp.getQuantity() %>">
						<%
							out.print(rp.getArticleid() + "<br>");
						%>

				</a></td>
				<td><%=rp.getBrand()%></td>
				<td><%=rp.getQuantity()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div></div></div>
	<%@ include file="footer.jsp"%>
</body>
</html>