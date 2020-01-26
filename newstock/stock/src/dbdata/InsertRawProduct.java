package dbdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.RawProduct;

public class InsertRawProduct {
public void insertRawProduct(RawProduct rawProduct) throws Exception {
	Dbmanager db = new Dbmanager();
    Connection con = db.getconnection();
	int id = 0;
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("SELECT pid FROM rawproduct order by pid");
	if (rs.last()) {
		id = rs.getInt(1) + 1;
		
	}
	PreparedStatement pr = con
			.prepareStatement("INSERT INTO rawproduct VALUES (?,?,?,?)");
	pr.setInt(1, id);
	pr.setString(2, rawProduct.getProduct());
	pr.setLong(3, rawProduct.getLimit());
	pr.setLong(4, rawProduct.getQuantity());
	
	pr.executeUpdate();
	
	con.close();


}
}
