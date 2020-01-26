package dbdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class IdHandler {

	public int getPid( String product) throws Exception {
		Dbmanager db = new Dbmanager();
		Connection con = db.getconnection();
		
		int pid = 0;

	
		String p = "'" + product + "'";
		String sql1 = "SELECT pid FROM rawproduct where product=" +p+" ";
		// System.out.println("sql1 " + sql1);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql1);
		if (rs.next()) {
			pid = rs.getInt(1);
		}
		con.close();
		return pid;
	}
}
