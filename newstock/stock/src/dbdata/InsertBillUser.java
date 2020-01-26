package dbdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.BillUserName;

public class InsertBillUser {
public void insertBillUser(BillUserName billUserName) throws Exception {
	Dbmanager db = new Dbmanager();
    Connection con = db.getconnection();
	int id = 0;
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("SELECT billid FROM billusername"+" order by billid");
	if (rs.last()) {
		id = rs.getInt(1) + 1;
		
	}
	PreparedStatement pr = con
			.prepareStatement("INSERT INTO billusername VALUES (?,?,?,?,?)");
	pr.setInt(1, id);
	pr.setString(2, billUserName.getName());
	pr.setString(3, billUserName.getMobile());
	pr.setString(4, billUserName.getDate());
	pr.setString(5, billUserName.getOperator());

	pr.executeUpdate();
	
	con.close();



}
public int getBillId() throws Exception {
	Dbmanager db = new Dbmanager();
    Connection con = db.getconnection();
	int id = 0;
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("SELECT billid FROM billusername"+" order by billid");
	if (rs.last()) {
		id = rs.getInt(1)+1 ;
		
	}
	return id;
}

}
