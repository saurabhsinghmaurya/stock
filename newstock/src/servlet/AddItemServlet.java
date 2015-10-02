package servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbdata.*;
import beans.*;

/**
 * Servlet implementation class AddItemServlet
 */
@SuppressWarnings("unused")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String src;
		try {
			RetrieveBrand rb = new RetrieveBrand();
			String brand = rb.getBrand(request.getParameter("user"),
					request.getParameter("product"),
					request.getParameter("aid"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int price = Integer.parseInt(request.getParameter("price"));
			ItemDetails ids = new ItemDetails(request.getParameter("user"),
					request.getParameter("product"),
					request.getParameter("aid"), brand, quantity, price, "Add");
			InsertItemDetails iid = new InsertItemDetails();

			iid.insert(ids);
			src = "/home.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			src = "/addProduct.jsp";
			request.setAttribute("msg", e.getMessage());
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(src);
		rd.forward(request, response);
	}

}
