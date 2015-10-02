package dbdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import beans.*;

public class AddSubDb {
public void add(AddSub addsub)throws Exception {
	Dbmanager db = new Dbmanager();
	Connection con = db.getconnection();
	// code for getting id and confirm table name
	int id = 0;
	String s = "'" + addsub.getUser() + "'";
	String sql = "select * from userinfo where usermail=" + s+" order by id";
	// System.out.println("sql"+sql);
	Statement st = con.createStatement();

	ResultSet rs = st.executeQuery(sql);
	// getting auto generated key id
	if (rs.next()) {
		id = rs.getInt(1);
	}
	String table = "producttable" + id;// Product table name
	 //System.out.println(table);
	int pid = 1;

	// getting auto generated key pid
	String p="'" + addsub.getProduct() + "'";
	String sql1="SELECT pid FROM " + table+" where product="+p+" order by pid";
	//System.out.println("sql1 "+sql1);
	ResultSet rs1 = st.executeQuery(sql1);
	if (rs1.next()) {
		pid = rs1.getInt(1);
	}
	//System.out.println("pid"+pid);
	// confirm sub table name as table1
	String table1 = "sub" + pid + id;
	//System.out.println("table1 "+table1);
	int spid = 1;

	// getting auto generated key id for sub table
	ResultSet rs2 = st.executeQuery("SELECT id FROM " + table1+" order by id");
	if (rs2.last()) {
		spid = rs2.getInt(1) + 1;
	}
	//System.out.println(spid);
	String sql2 = "INSERT INTO " + table1 + " VALUES (?,?,?,?)";
	PreparedStatement pr = con.prepareStatement(sql2);
	pr.setInt(1, spid);//sub product id
	pr.setString(2, addsub.getAid());
	pr.setString(3,addsub.getBrand());
	pr.setInt(4, 0);
	pr.execute();
	// creating table for sub cat details
	String table2 = "subdetails"+spid + pid + id;
	//System.out.println(table2);
	String sql3 = "CREATE TABLE "
			+ table2
			+ " (id int NOT NULL AUTO_INCREMENT,articleid VARCHAR(100)NOT NULL,brand varchar(50)NOT NULL,quantity int NOT NULL,price int NOT NULL,action varchar(50)NOT NULL,date date not null ,PRIMARY KEY (id))";
	//System.out.println(sql3);
	st.executeUpdate(sql3);

	con.close();	
}
}
