package dbdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddProduct {
	public void add(String user, String product) throws Exception {
		Dbmanager db = new Dbmanager();
		Connection con = db.getconnection();

	Statement st = con.createStatement();

	
	int pid = 1;

	ResultSet rs1 = st.executeQuery("SELECT pid FROM product order by pid");
	if (rs1.last()) {
		pid = rs1.getInt(1) + 1;
	}
//		// System.out.println(pid);
		// inserting data into product table
		String sql1 = "INSERT INTO product VALUES (?,?,?)";
		PreparedStatement pr = con.prepareStatement(sql1);
		pr.setInt(1, pid);
		pr.setString(2, product);
        pr.setInt(3, 1);
		pr.execute();
		

		con.close();
	}
}
