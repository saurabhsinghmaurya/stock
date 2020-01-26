package dbdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.Product;

public class InsertProduct {
	public void insertProduct(Product product) throws Exception {
		Dbmanager db = new Dbmanager();
	    Connection con = db.getconnection();
		int id = 0;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT pid FROM product order by pid");
		if (rs.last()) {
			id = rs.getInt(1) + 1;
			
		}
		PreparedStatement pr = con
				.prepareStatement("INSERT INTO product VALUES (?,?,?)");
		pr.setInt(1, id);
		pr.setString(2, product.getProduct());
		pr.setLong(3, product.getPrice());
	
		
		pr.executeUpdate();
		
		con.close();


	}

}
