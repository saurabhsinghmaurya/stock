package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.*;
import dbdata.*;

/**
 * Servlet implementation class SoldServlet
 */
public class SoldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String src = null;
		try {
			RetrieveBrand rb = new RetrieveBrand();
			String brand = rb.getBrand(request.getParameter("user"),
					request.getParameter("product"),
					request.getParameter("aid"));
			int qu = Integer.parseInt(request.getParameter("quantity"));

			int quantity = -qu;

			int price = Integer.parseInt(request.getParameter("price"));
			int avQuantity = rb.getQuntity(request.getParameter("user"),
					request.getParameter("product"),
					request.getParameter("aid"));

			ItemDetails ids = new ItemDetails(request.getParameter("user"),
					request.getParameter("product"),
					request.getParameter("aid"), brand, quantity, price, "Sold");
			InsertItemDetails iid = new InsertItemDetails();
			if (qu <= avQuantity) {
				iid.insert(ids);
				src = "/home.jsp";
			} else {
				src = "/sold.jsp";
				request.setAttribute("msg",
						"Sold quantity is more then available quantity");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			String msg = e.getMessage();
			request.setAttribute("msg", msg);
			src = "/sold.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(src);
		rd.forward(request, response);
	}

}
