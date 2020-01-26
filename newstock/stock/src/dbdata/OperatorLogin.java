package dbdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.Operator;

public class OperatorLogin {
	public boolean getLogin(Operator operator) throws Exception {
		Dbmanager db = new Dbmanager();
		Connection con = db.getconnection();
		Statement st = con.createStatement();
		String sql = "select * from operator  where email='" + operator.getEmail()
				+ "'and password='" + operator.getPassword() + "' and post='"+operator.getPost()+"'";
		// System.out.println("sql "+sql);
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			return true;
		}
		return false;
	}
	public boolean Check(String email) throws Exception {
		Dbmanager db = new Dbmanager();
		Connection con = db.getconnection();
		Statement st = con.createStatement();
		String sql = "select * from operator  where email='" +email+"'";
				
		// System.out.println("sql "+sql);
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			return true;
		}
		return false;	
	}

}
