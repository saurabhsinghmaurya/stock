<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>MagicCity</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="head.jsp"%>
<script type="text/javascript" src="jscripts/login.js"></script>
</head>
<body >
	<%@ include file="topborder.jsp"%>
	<br class="clear" />
	<div class="wrapper col5">
		<div id="container">
           <!-- ******************************vertical menu******************************* -->
					<!-- ******************************space for form******************************* -->
					<br /> <br /> <br />

                <img style="float: left;" src="images/3.jpg" alt="" />
					<div style="margin-left: 60%; margin-right: 10%;">

						<div class="holder">
							<%
									String msg = null;
									msg = (String) request.getAttribute("msg");
									if (msg != null) {
										out.print(msg);
									}
								%>

							<form name="login" class="login" action="validate.jsp"
								onsubmit="return validateForm(this);" method="post"
								autocomplete="off">
								<table
									style="background-color: rgb(220, 220, 220); margin-right: 20%;">
									<tr>
										<td>
											<ul class="sb_menu" style="color: black;">
												<li style="font-size: medium;">Sign in</li>
												<li>Email Id</li>
												<li><input type="text" name="user" size="30" required></li>

												<li>Password</li>
												<li><input type="password" name="pass" size="30"
													required></li>

												<li><input type="submit" value="Sign in"></li>
											</ul>
										</td>
									</tr>
								</table>
							</form>
						<a href="forgot.jsp" style="font-size:large;">Forgot Password? </a><br><br>
								<a href="register.jsp" style="font-size:large;">New User? Please Register</a>
									
							
						</div>
<br><br><br><br><br>
					</div>

					<br class="clear" />

				</div>

			</div>


			<!-- ******************************space for form******************************* -->
			<!-- ******************************copyright******************************* -->
			<%@ include file="footer.jsp"%>
</body>
</html>