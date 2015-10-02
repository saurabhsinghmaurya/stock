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
 * Servlet implementation class AddSubServlet
 */
public class AddSubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ItemDetails ids = new ItemDetails(request.getParameter("user"),
				request.getParameter("product"), request.getParameter("aid"),
				 request.getParameter("cname"), 0, 0, "0");
		RetrieveBrand rb=new RetrieveBrand();
		String src = null;
		try {
			if(rb.checkAid(request.getParameter("user"),
					request.getParameter("product"), request.getParameter("aid"))){
			InsertItemDetails iid = new InsertItemDetails();

			iid.insert(ids);
			src = "/home.jsp";}
			else{
				src = "/addSub.jsp";
  				request.setAttribute("msg",
  						"you have already this Article id");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			String msg = e.getMessage();
			request.setAttribute("msg", msg);
			src = "/addSub.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(src);
		rd.forward(request, response);
	}

}
