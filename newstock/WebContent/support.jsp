<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><jsp:useBean id="validat" class="beans.ValidateLogin"
	scope="session" />
<title>support</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="head.jsp"%>


</head>
<body>
	<%
		if (validat.getUser() == null) {
	%>
	<%@ include file="topborder.jsp"%>
	<%
		} else {
	%><%@ include file="itop.jsp"%>
	<%
		}
	%>
	<!-- ******************************slogan and horizontal menu******************************* -->
	<!-- ******************************sliding photo******************************* -->
	<div class="main">
		<div class="header">
			<div class="header_resize">


				<div class="menu_nav"></div>
				<div class="clr"></div>
				<div class="slider">
					<div id="coin-slider">
						<a href="#"><img src="images/slide1.jpg" width="960"
							height="320" alt="" /> </a> <a href="#"><img
							src="images/slide2.jpg" width="960" height="320" alt="" /> </a> <a
							href="#"><img src="images/slide3.jpg" width="960"
							height="320" alt="" /> </a>
					</div>

					<div class="clr"></div>
				</div>
				<div class="clr"></div>
			</div>
		</div>
		<!-- ******************************slogan and horizontal menu******************************* -->
		<!-- ******************************About application******************************* -->
		<div class="wrapper col5">
			<div id="container">






				<div class="content">
					<div class="content_resize">

						<div class="sidebar">


							<div class="clr"></div>

							<div class="gadget">

								<b> Stock management</b> is the function of understanding the
								stock mix of a company and the different demands on that stock.
								The demands are influenced by both external and internal factors
								and are balanced by the creation of Purchase order requests to
								keep supplies at a reasonable or prescribed level.






							</div>

						</div>
						<!-- ******************************vertical menu******************************* -->
						<!-- ******************************space for form******************************* -->
						<div align="center">

							<h4>Retail Supply Chain Management</h4>
							Stock management in the retail supply chain follows the following
							sequence:<br></br>
		<table style="text-align: left;"><tr><td>			
	<img src="images/ne.png">Request for new stock from stores to head office</img><br></br></td></tr>
  <tr><td> <img src="images/ne.png">Head office issues purchase orders to the vendor.</img><br></br></td></tr>
	<tr><td><img src="images/ne.png">Vendor ships the goods</img><br></br></td></tr>
	<tr><td><img src="images/ne.png">Warehouse receives the goods</img><br></br></td></tr>
	<tr><td><img src="images/ne.png">Warehouse stocks and distributes to the stores</img><br></br></td></tr>
	<tr><td><img src="images/ne.png">Stores receive the goods</img><br></br></td></tr>
	<tr><td><img src="images/ne.png">Goods are sold to customers at the stores</img><br></br></td></tr></table>
		
							

						</div>


						<br class="clear" />
					</div>
				</div>




			</div>
		</div>
	</div>

	<!-- ******************************space for form******************************* -->
	<!-- ******************************copyright******************************* -->
	<%@ include file="footer.jsp"%>
</body>
</html>
