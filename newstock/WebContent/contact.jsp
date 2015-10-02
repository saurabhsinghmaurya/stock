<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:useBean id="validat" class="beans.ValidateLogin" scope="session" />
<head>
<title>contact us</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="head.jsp"%>
<script type="text/javascript" src="jscripts/login.js"></script>
</head>
<body >
<%
		if (validat.getUser() == null) {
	%>
	<%@ include file="topborder.jsp"%><%}
		else {
			%><%@ include file="itop.jsp"%><% 
			
		}
%>
	<br class="clear" />
	<div class="wrapper col5">
	<img src="images/query.jpg" alt="any query" style="width:100%;height:400px;" />
		<div id="container"><div >
		
		 <i>Although we have made this application as simple and powerfull as possible...</i><br></br>
		 
		 But still if you find any difficulty in usiing this web app.....you can contact us any time 24x7<br></br>
		<ul style="font-size: large;margin-left:  1in;"> 
		<li> <b>Rahul mishra(cs.0905410077@gmail.com)</b> </li><br></br>
		<li><b>Chandrashekhar soni(cs.0905410039@gmail.com)</b></li><br></br>
		<li><b>Saurabh singh maurya(cs.0905410096@gmail.com)</b></li><br></br>
		<li><b>Amit kumar(cs.0905410016@gmail.com)</b></li><br></br>
		 
		 
		 
		 </div>
		</div>
           </div>
			<%@ include file="footer.jsp"%>
</body>
</html>