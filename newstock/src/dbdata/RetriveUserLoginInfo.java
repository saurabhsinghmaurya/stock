package dbdata;

import java.sql.*;

import beans.ValidateLogin;

public class RetriveUserLoginInfo {
	String userdb;
	String passdb;

	public String getUserdb() {
		return userdb;
	}

	public void setUserdb(String userdb) {
		this.userdb = userdb;
	}

	public String getPassdb() {
		return passdb;
	}

	public void setPassdb(String passdb) {
		this.passdb = passdb;
	}

	public boolean userValidate(ValidateLogin validate) throws Exception {

		Dbmanager db = new Dbmanager();
		Connection con = db.getconnection();

		PreparedStatement pr = con
				.prepareStatement("select * from userinfo where userMail=? and password= ?");
		pr.setString(1, validate.getUser());
		pr.setString(2, validate.getPass());
		ResultSet rs = pr.executeQuery();
		while (rs.next()) {
			this.setUserdb(rs.getString(2));
			this.setPassdb(rs.getString(3));

		}
		if (this.getUserdb() == null) {
			System.out.println("false");
			con.close();
			return false;
		} else {
			con.close();
			System.out.println("true");
			return true;
		}
	}

	public void getPassword(String user) throws Exception {
		SendMail sm=new SendMail();
		Dbmanager db = new Dbmanager();
		Connection con = db.getconnection();

		PreparedStatement pr = con
				.prepareStatement("select * from userinfo where userMail=? ");
		pr.setString(1, user);

		ResultSet rs = pr.executeQuery();
		while (rs.next()) {
			this.setUserdb(rs.getString(3));
			this.setPassdb(rs.getString(4));

		}
sm.sendMail(userdb, passdb);
	}
}
