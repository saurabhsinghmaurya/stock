package dbdata;

import java.sql.*;

import beans.ConnectionBean;

public class Dbmanager {
	public  Connection getconnection() throws Exception {
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:"+ConnectionBean.getPort()+"/"
				+ "dstock", ConnectionBean.getUser(), ConnectionBean.getPassword());
		
		return con;
	}
}
