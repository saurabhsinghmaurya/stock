package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbdata.*;
import beans.*;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String src = null;
		UserInfoValidate userinfo = new UserInfoValidate(
				request.getParameter("user"), request.getParameter("email"),
				request.getParameter("pass"), request.getParameter("cpass"),
				request.getParameter("gen"), request.getParameter("mobile"),
				request.getParameter("add"));
		if (!userinfo.validate()) {
			String msg = "Plese enter valid info.Any field can not be empty";
			request.setAttribute("msg", msg);
			src = "/register.jsp";
		} else if (!userinfo.validatePass()) {
			String msg = "Plese enter same password in password and Confirm password";
			request.setAttribute("msg", msg);
			src = "/register.jsp";
		} else {
			InsertUserInfo insert = new InsertUserInfo();
			try {
				insert.insert(userinfo);
				src = "/Userinfo.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				String msg = e.getMessage();
				request.setAttribute("msg", msg);
				src="/register.jsp";
			}

		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(src);
		rd.forward(request, response);
	}
}
