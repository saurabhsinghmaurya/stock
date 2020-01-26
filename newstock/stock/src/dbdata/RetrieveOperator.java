package dbdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import beans.Operator;

public class RetrieveOperator {
public LinkedList<Operator> getAll() throws Exception {
	LinkedList<Operator> getOp = new LinkedList<Operator>();
	Dbmanager db = new Dbmanager();
	Connection con = db.getconnection();
	Statement st = con.createStatement();
	String sql = "select * from operator where post='Operator'  order by id";
	// System.out.println("sql "+sql);
	ResultSet rs = st.executeQuery(sql);
	while (rs.next()) {
		getOp.add(new Operator(0, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
	}
	return getOp;
}
}
