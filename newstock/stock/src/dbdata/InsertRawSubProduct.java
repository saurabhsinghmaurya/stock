package dbdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.RawSubProduct;

public class InsertRawSubProduct {
public void insert(RawSubProduct  product) throws Exception {
	Dbmanager db = new Dbmanager();
    Connection con = db.getconnection();
	int id = 0;
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("SELECT sid FROM rawsubproduct"+" order by sid");
	if (rs.last()) {
		id = rs.getInt(1) + 1;
		
	}
	PreparedStatement pr = con
			.prepareStatement("INSERT INTO rawsubproduct VALUES (?,?,?,?,?,?)");
	pr.setInt(1, id);
	pr.setLong(2, product.getQuantity());
	pr.setLong(3, product.getPrice());
	pr.setString(4,product.getAction());
	pr.setString(5, product.getDate());
	pr.setInt(6, product.getPid());

	pr.executeUpdate();
	
	
	int total=0;
	rs = st.executeQuery("select sum(quantity) from rawsubproduct where pid="+ product.getPid() + "");
	if (rs.next()) {
		total = rs.getInt(1);
		//System.out.println(total);
	}
	st.executeUpdate("update rawproduct set quantity=" + total
			+ " where pid=" + "'" + product.getPid()
			+ "' ");
			 
	con.close();

}
}
