<%@page import="beans.*"%>
<%@page import="dbdata.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>validate</title>
</head>
<body>
	<jsp:useBean id="validat" class="beans.ValidateLogin"
		scope="session" />
	<jsp:setProperty property="*" name="validat" />
	<%
RetriveUserLoginInfo userlogin=new RetriveUserLoginInfo();

if(validat.getUser()==null||validat.getPass()==null)
{
	//out.print(ob.getUser());
String msg="Plese enter valid user name and password1";	
validat.setUser(null);
request.setAttribute("msg", msg);	%>
	<jsp:forward page="login.jsp"></jsp:forward>
	<% 
}
else if(userlogin.userValidate(validat))
{String msg=validat.getUser();
request.setAttribute("msg", msg);	%>
	<jsp:forward page="home.jsp" />
	<% 
	}
else
{
  out.print(validat.getUser());
String msg="Plese enter valid user name and password0";	
validat.setUser(null);
request.setAttribute("msg", msg);
%>
	<jsp:forward page="login.jsp" />
	<%} %>


</body>
</html>