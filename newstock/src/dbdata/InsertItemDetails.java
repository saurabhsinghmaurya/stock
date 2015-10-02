package dbdata;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.*;

public class InsertItemDetails {
	public synchronized void  insert(ItemDetails ids) throws Exception {
		Dbmanager db = new Dbmanager();
		SimpleFormatDate sfd = new SimpleFormatDate();
		Date date = sfd.getDate();
		Connection con = db.getconnection();
		IdHandler i = new IdHandler();
		int pid = i.getPid(ids.getUser(), ids.getProduct());
		int id = 1;
		Statement st = con.createStatement();
		ResultSet rs = st
				.executeQuery("SELECT sid FROM subproduct order by sid");
		if (rs.last()) {
			id = rs.getInt("sid") + 1;
		}
		PreparedStatement pr = con
				.prepareStatement("INSERT INTO subproduct VALUES (?,?,?,?,?,?,?,?)");
		pr.setInt(1, id);
		pr.setString(2, ids.getAid());
		pr.setString(3, ids.getBrand());
		pr.setInt(4, ids.getQuantity());
		pr.setInt(5, ids.getPrice());
		pr.setString(6, ids.getAction());
		pr.setDate(7, date);
		pr.setInt(8, pid);
		pr.executeUpdate();
		int total = 0;

		rs = st.executeQuery("select sum(quantity) from subproduct where pid="
				+ "" + pid + " and articleid='" + ids.getAid() + "' and action !='0'");
		if (rs.next()) {
			total = rs.getInt(1);
			//System.out.println(total);
		}
		st.executeUpdate("update subproduct set quantity=" + total
				+ " where pid=" + "'" + pid
				+ "' and action='0' and articleid='" + ids.getAid() + "'");
	}
}
