package dbdata;

import beans.*;
import java.sql.*;

public class InsertUserInfo {
	public synchronized void insert(UserInfoValidate userinfovalidate) throws Exception {

		// TODO Auto-generated method stub
		Dbmanager db = new Dbmanager();

		Connection con = db.getconnection();
		int id = 0;

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT id FROM userinfo"+" order by id");
		if (rs.last()) {
			id = rs.getInt("id") + 1;
		}
		@SuppressWarnings("unused")
		String table = "productTable" + id;
		PreparedStatement pr = con
				.prepareStatement("INSERT INTO userinfo VALUES (?,?,?,?,?,?,?)");
		pr.setInt(1, id);
		pr.setString(2, userinfovalidate.getUser());
		pr.setString(3, userinfovalidate.getEmail());
		pr.setString(4, userinfovalidate.getPass());
		pr.setString(5, userinfovalidate.getGen());
		pr.setString(6, userinfovalidate.getMobile());
		pr.setString(7, userinfovalidate.getAdd());
		pr.executeUpdate();
		
		con.close();

	}

}
