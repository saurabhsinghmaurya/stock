package dbdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.Salary;

public class InsertSalary {
public void insertSalary(Salary salary) throws Exception {
	Dbmanager db = new Dbmanager();
    Connection con = db.getconnection();
	int id = 0;
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("SELECT sno FROM salary"+" order by sno");
	if (rs.last()) {
		id = rs.getInt(1) + 1;
		
	}
	PreparedStatement pr = con
			.prepareStatement("INSERT INTO salary VALUES (?,?,?,?,?)");
	pr.setInt(1, id);
	pr.setString(2, salary.getName());
	pr.setLong(3, salary.getSalary());
	pr.setString(4,salary.getDate());
	pr.setInt(5, salary.getEid());

	pr.executeUpdate();
	
	con.close();

}
public static void main(String[] args) {
	InsertSalary insertSalary=new InsertSalary();
	try {
		insertSalary.insertSalary(new Salary("3", "saurabh", 1500000, "3000-01-02", 12));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
