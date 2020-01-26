package dbdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import beans.Product;
import beans.Sales;

public class SalesReport {
public LinkedList<Sales> getSalesReport(String date,String date1) throws Exception {
	LinkedList<Sales> sales=new LinkedList<Sales>();
	Dbmanager db = new Dbmanager();
	Connection con = db.getconnection();
	Statement st = con.createStatement();
	LinkedList<Integer> list=new LinkedList<Integer>();
	String sql = "select * from billusername where date between ' "+date+"' and '"+date1+"' order by billid";
	
	
	ResultSet rs = st.executeQuery(sql);
	while (rs.next()) {
	list.add(new Integer(rs.getInt(1)));
	}
	RetrieveProduct  product=new RetrieveProduct();
	LinkedList<Product> listProducts=product.getAll();
	for (Product product2 : listProducts) {
		String pro=product2.getProduct();
		int totalQuan=0;
		int totalPrice=0;
		for (Integer integer : list) {
			String sql1="select * from bill where product='"+pro+"' and billid=" + integer+"";
			rs=st.executeQuery(sql1);
			while (rs.next()) {
				totalQuan+=rs.getInt(3);
				totalPrice+=(rs.getInt(3)*rs.getInt(4));
				 
				}
		}
		sales.add(new Sales(pro, totalQuan, totalPrice));
		
	}
	
return sales;
}
}
