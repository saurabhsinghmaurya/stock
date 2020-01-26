package dbdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import beans.Vendor;

public class RetrieveVendor{
	public LinkedList<Vendor> getAllOrder() throws Exception {
		LinkedList<Vendor> getOrder = new LinkedList<Vendor>();
		Dbmanager db = new Dbmanager();
		Connection con = db.getconnection();
		Statement st = con.createStatement();
		String sql = "select * from vendor order by sno";
		// System.out.println("sql "+sql);
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			getOrder.add(new Vendor(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
		}
		return getOrder;
	}
	public String getStatus(int sno) throws Exception {
		Dbmanager db = new Dbmanager();
		Connection con = db.getconnection();
		Statement st = con.createStatement();
		String sql = "select * from vendor where sno="+sno+" order by sno";
		String status=null;
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			status=rs.getString(7);
		}
		return status;
	
	}
}
