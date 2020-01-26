package dbdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.Operator;

public class InsertOperator {
public void insertOpertor(Operator operator) throws Exception {
	Dbmanager db = new Dbmanager();
    Connection con = db.getconnection();
	int id = 0;
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("SELECT id FROM operator"+" order by id");
	if (rs.last()) {
		id = rs.getInt(1) + 1;
		
	}
	PreparedStatement pr = con
			.prepareStatement("INSERT INTO operator VALUES (?,?,?,?,?)");
	pr.setInt(1, id);
	pr.setString(2, operator.getName());
	pr.setString(3, operator.getEmail());
	pr.setString(4, operator.getPassword());
	pr.setString(5,operator.getPost());

	pr.executeUpdate();
	
	con.close();


	
}

}
