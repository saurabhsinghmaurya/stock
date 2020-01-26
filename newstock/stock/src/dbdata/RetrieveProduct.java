package dbdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import beans.Product;

public class RetrieveProduct {
	public LinkedList<Product> getAll() throws Exception {
		
		LinkedList<Product> getProduct = new LinkedList<Product>();
		Dbmanager db = new Dbmanager();
		Connection con = db.getconnection();
		Statement st = con.createStatement();
		String sql = "select * from product  order by pid";
		
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
		getProduct.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3)));
		}
		return getProduct;
	}
	public int getPrice(String product) throws Exception {
		Dbmanager db = new Dbmanager();
		Connection con = db.getconnection();
		Statement st = con.createStatement();
		String sql = "select * from product where product='"+product +"' order by pid";
		int price=0;
		ResultSet rs = st.executeQuery(sql);
		if(rs.next())
		{
			price=rs.getInt(3);
			
		}
		return price;
		
	}
}
