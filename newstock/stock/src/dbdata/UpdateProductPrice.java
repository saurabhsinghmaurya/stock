package dbdata;

import java.sql.Connection;
import java.sql.Statement;

public class UpdateProductPrice {
	public void update(String product,int price) throws Exception {
		Dbmanager db = new Dbmanager();
		Connection con = db.getconnection();
		Statement st = con.createStatement();
		String sql =
		"update `product` set `price`='"+price+"' where `product`='"+product+"'";
		
		st.executeUpdate(sql);
		
				
	}
}
