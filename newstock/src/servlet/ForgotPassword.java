package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbdata.*;
//import beans.*;

/**
 * Servlet implementation class ForgotPassword
 */
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String src = null;
		RetriveUserLoginInfo ru=new RetriveUserLoginInfo();
		try {
			IdHandler idh = new IdHandler();
			int id = idh.getId(request.getParameter("user"));
			// System.out.println(id);
			if (id == 0) {
				request.setAttribute("msg", "This email id is not register");
				src = "/forgot.jsp";
			} else {
				ru.getPassword(request.getParameter("user"));
				
				src = "/forgot.jsp";
			}
		} catch (Exception e) {
			// TODO: handle exception
			src = "/forgot.jsp";
			request.setAttribute("msg", e.getMessage());
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(src);
		rd.forward(request, response);
	}

}
