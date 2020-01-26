package dbdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.Vendor;

public class InsertVendor {
public void insertVendor(Vendor vendor) throws Exception {
	Dbmanager db = new Dbmanager();
    Connection con = db.getconnection();
	int id = 0;
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("SELECT sno FROM vendor"+" order by sno");
	if (rs.last()) {
		id = rs.getInt("sno") + 1;
	}
	PreparedStatement pr = con
			.prepareStatement("INSERT INTO vendor VALUES (?,?,?,?,?,?,?)");
	pr.setInt(1, id);
	pr.setString(2, vendor.getProduct());
	pr.setString(3, vendor.getVendor());
	pr.setLong(4, vendor.getQuantity());
	pr.setLong(5, vendor.getPrice());
	pr.setString(6, vendor.getDate());
	pr.setString(7, vendor.getStatus());
	pr.executeUpdate();
	
	con.close();


	
}


}
