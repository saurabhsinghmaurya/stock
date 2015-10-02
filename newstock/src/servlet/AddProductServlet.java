package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dbdata.*;
/**
 * Servlet implementation class AddProductServlet
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String product = request.getParameter("pname");
		String user=request.getParameter("user");
		String src=null;
		RetrieveBrand rb=new RetrieveBrand();
		
          AddProduct add=new AddProduct();
          try {
        	  if(rb.checkProduct(user, product)){
			add.add(user, product);
			src="/home.jsp";
        	  }
        	  else{
        		  src = "/addProduct.jsp";
  				request.setAttribute("msg",
  						"you have already this product");
        	  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			String msg = e.getMessage();
			request.setAttribute("msg", msg);
			src="/addProduct.jsp";
		}
          RequestDispatcher rd = getServletContext().getRequestDispatcher(src);
  		rd.forward(request, response);
		
	}

}
