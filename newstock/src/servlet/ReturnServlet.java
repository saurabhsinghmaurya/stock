package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemDetails;
import dbdata.InsertItemDetails;
import dbdata.RetrieveBrand;

/**
 * Servlet implementation class ReturnServlet
 */
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String src=null;
		try {
			RetrieveBrand rb=new RetrieveBrand();
			String brand=rb.getBrand(request.getParameter("user"), request.getParameter("product"), request.getParameter("aid"));
			int qu=Integer.parseInt(request.getParameter("quantity"));
			int quantity=-qu;
			int avQuantity=rb.getQuntity(request.getParameter("user"), request.getParameter("product"), request.getParameter("aid"));

			int price=Integer.parseInt(request.getParameter("price"));
			ItemDetails ids = new ItemDetails(request.getParameter("user"),
					request.getParameter("product"), request.getParameter("aid"),
					brand,
					quantity,
					price, "Return");
			InsertItemDetails iid=new InsertItemDetails();
			
			if (qu<=avQuantity) {
				iid.insert(ids);	
				src="/home.jsp";
			}
			else {
				src="/return.jsp";
				request.setAttribute("msg","Return quantity is more then available quantity");
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				src="/return.jsp";
				request.setAttribute("msg","Return quantity is more then available quantity");
		
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					src);
			rd.forward(request, response);
	}

}
