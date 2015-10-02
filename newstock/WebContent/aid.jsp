<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
<%@page import="dbdata.*"%>
<%@page import="beans.*"%>
<%-- <%@ include file="hm.jsp"%> --%>
<%-- <%@ include file="vm.jsp"%> --%>
<%@ page errorPage="errorPage1.jsp"%>
<jsp:useBean id="validat" class="beans.ValidateLogin" scope="session" />
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body  ><%
		if (validat.getUser() == null) {
	%>
	<jsp:forward page="index.jsp"></jsp:forward>
	<%
		}
	%>
<% RetrieveAidDb db= new RetrieveAidDb();
LinkedList<RetrieveAid> ll=db.allAid(validat.getUser(),request.getParameter("pro"));
				Iterator<RetrieveAid> it=ll.iterator();%>
			
	<div class="p">
		<br>select Aid
	<select
					style="height: 22px; width: 167px; border-radius: 10px;"
					name="aid"onchange="showBrand(dm product)">
					<option value="-1">------select-------</option>
				<% 	while(it.hasNext())
			{
			RetrieveAid rp=it.next();%>
						<option value="<%=rp.getArticleid() %>"><%=rp.getArticleid() %></option>
						
<%} %>
				</select>
				
			
		
	</div>
	

</body>
</html>