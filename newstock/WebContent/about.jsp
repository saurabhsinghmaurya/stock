<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><jsp:useBean id="validat" class="beans.ValidateLogin"
	scope="session" />
<title>about stock management</title>
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






				
							<div class="gadget"><br> "The
								activity of checking a shop’s stock"[1] Many shops now use stock
								control systems. The term "stock control system" can be used to
								include various aspects of controlling the amount of stock on
								the shelves and in the stockroom and how reordering happens.
								Typical features include: Ensuring that products are on the
								shelf in shops in just the right quantity. Recognising when a
								customer has bought a product.<br> Automatically signalling when
								more products need to be put on the shelf from the stockroom.
								Automatically reordering stock at the appropriate time from the
								main warehouse. Automatically producing management information
								reports that could be used both by local managers and at Head
								office. These might detail what has sold, how quickly and at
								what price, for example. Reports could be used to predict when
								to stock up on extra products, for example, at Christmas or to
								make decisions about special offers, discontinuing products and
								so on. Sending reordering information not only to the warehouse
								but also directly to the factory producing the products to
								enable them to optimise production.</div>

					
						<!-- ******************************vertical menu******************************* -->
						<!-- ******************************space for form******************************* -->
					

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
