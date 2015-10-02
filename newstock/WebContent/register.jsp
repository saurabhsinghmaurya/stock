<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Stock Management Registration</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="head.jsp"%>

<script type="text/javascript" src="jscripts/register.js"></script>

</head>
<body><%@ include file="topborder.jsp"%>
	<br class="clear" />
	<div class="wrapper col5">
		<div id="container">
			
			<!-- ******************************space for form******************************* -->
			


			<div style="margin-left: 60%; margin-right: 10%;">

				<div class="holder">
					<%
						String msg = null;
						msg = (String) request.getAttribute("msg");
						if (msg != null) {
							out.print(msg);
						}
					%><br> <br>
					<form name="register" action="RegServlet"
						onsubmit="return validateForm(this);" method="post"
						autocomplete="off">

						<table style="background-color: rgb(220, 220, 220) ; ">
							<tr>
								<td>
									<ul class="sb_menu" style="color: black;">

										<li>Enter your showroom Name<span style="color: red;">*</span></li>
										<li><input type="text" name="user" size="30" required></li>
										<li>Enter Your Emailid<span style="color: red;">*</span></li>
										<li><input type="text" name="email" size="30" required></li>
										<li>Password<span style="color: red;">*</span></li>
										<li><input type="password" name="pass" size="30"
											required></li>
										<li>Confirm Password<span style="color: red;">*</span></li>
										<li><input type="password" name="cpass"
											size="30" required></li>
										<li>Gender<span style="color: red;">*</span></li>
										<li><input type="radio" name="gen" value="male"
											required>Male <input type="radio" name="gen"
												value="female" required>Female </li>
										<li>Mobile No.<span style="color: red;">*</span></li>
										<li><input type="text" name="mobile" size="30" required></li>
										<li>Address<span style="color: red;">*</span></li>
										<li><textarea name="add" rows="3" cols="22" required></textarea>
										</li>
										<li><input type="submit" value="Sign up"><input
												type="reset"></li>
									</ul>
								</td>
							</tr>
						</table>
					</form>
					
						 <a href="login.jsp" style="font-size:large;">Already Registered?Sign in</a>
						
					
				</div>

			</div>

			<br class="clear" />

		</div>

	</div>


	<!-- ******************************space for form******************************* -->
	<!-- ******************************copyright******************************* -->
	<%@ include file="footer.jsp"%>
</body>
</html>