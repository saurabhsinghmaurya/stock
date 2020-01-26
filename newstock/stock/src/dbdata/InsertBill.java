package dbdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.Bill;

public class InsertBill {
public void insertBill(Bill bill) throws Exception {
	Dbmanager db = new Dbmanager();
    Connection con = db.getconnection();
	int id = 0;
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("SELECT sno FROM bill"+" order by sno");
	if (rs.last()) {
		id = rs.getInt(1) + 1;
		
	}
	PreparedStatement pr = con
			.prepareStatement("INSERT INTO bill VALUES (?,?,?,?,?)");
	pr.setInt(1, id);
	pr.setString(2, bill.getProduct());
	pr.setLong(3, bill.getQuantity());
	pr.setLong(4, bill.getPrice());
	pr.setLong(5, bill.getBillId());
	

	pr.executeUpdate();
	
	con.close();



	
}
public static void main(String[] args) {
	InsertBill bill=new InsertBill();
	try {
		bill.insertBill(new Bill("gff", 12, 121, 212));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
