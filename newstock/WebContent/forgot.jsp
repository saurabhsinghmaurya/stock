<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Retrive password</title>
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

       
					<div style="margin-left: 60%; margin-right: 10%;">

						<div class="holder"> Please check your mail inbox after submit your email id <hr><br>
							<%
									String msg = null;
									msg = (String) request.getAttribute("msg");
									if (msg != null) {
										out.print(msg);
									}
								%>

							<form name="login" class="login" action="ForgotPassword"
								onsubmit="return validateForm(this);" method="post"
								autocomplete="off">
								<table
									style="background-color: rgb(220, 220, 220); margin-right: 20%;">
									<tr>
										<td>
											<ul class="sb_menu" style="color: black;">
												<li style="font-size: medium;">Get password </li>
												<li>Email Id</li>
												<li><input type="text" name="user" size="30" required></li>

												

												<li><input type="submit" value="Submit"></li>
											</ul>
										</td>
									</tr>
								</table>
							</form>
						
								
									
							
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