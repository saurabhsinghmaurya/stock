package dbdata;

import java.sql.*;

public class Dbmanager {
	public Connection getconnection() throws Exception {
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
				+ "stock", "root", "8765384745");
		return con;
	}
}
