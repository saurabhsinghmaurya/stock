package dbdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import beans.Bill;

public class RetrieveBill {
	public LinkedList<Bill> getBill() throws Exception {
		LinkedList<Bill> getBill = new LinkedList<Bill>();
		Dbmanager db = new Dbmanager();
		Connection con = db.getconnection();
		Statement st = con.createStatement();
		String sql = "select * from bill  order by sno";
		// System.out.println("sql "+sql);
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			getBill.add(new Bill(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
		}
		return getBill;
	}
	public static void main(String[] args) throws Exception {
		RetrieveBill bill=new RetrieveBill();
		LinkedList<Bill> list = bill.getBill();
		for (Bill bill2 : list) {
			System.out.println(bill2.getPrice());
		}
		
	}
}
