package dbdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.Employee;

public class InsertEmp {

	/**
	 * @param args
	 */
	public void insertEmp(Employee employee) throws Exception {

		// TODO Auto-generated method stub
		Dbmanager db = new Dbmanager();

		Connection con = db.getconnection();
		int id = 0;

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT eid FROM employee"
				+ " order by eid");
		if (rs.last()) {
			id = rs.getInt("eid") + 1;
		}
		
	
		PreparedStatement pr = con
				.prepareStatement("INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
		pr.setInt(1, id);
		pr.setString(2, employee.getName());
		pr.setString(3, employee.getFather());
		pr.setString(4, employee.getGender());
		pr.setString(5, employee.getBday());
		pr.setString(6, employee.getMobile());
		pr.setLong(7, employee.getSalary());
		pr.setString(8, employee.getStatus());
		pr.setString(9, employee.getJoinDate());
		pr.setString(10, "2000-12-01");
		pr.setString(11, employee.getDesignation());
		pr.setString(12, employee.getEmail());
		pr.setString(13, employee.getAddress());
		pr.executeUpdate();
		con.close();

		
	}

	
}
