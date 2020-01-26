package dbdata;

import java.sql.Connection;
import java.sql.Statement;

import beans.Employee;

public class UpdateEmpDetails {
	public void update(Employee employee) throws Exception {
		Dbmanager db = new Dbmanager();
		Connection con = db.getconnection();
		Statement st = con.createStatement();
		String sql = "update `employee` set `name`='"+employee.getName() +"',`fathername`='"+employee.getFather()+"',`gender`='"+employee.getGender()+"',`bday`='"+employee.getBday()+"',`mobile`='"+employee.getMobile()+"',`salary`='"+employee.getSalary()+"',`status`='"+employee.getStatus()+"',`joindate`='"+employee.getJoinDate()+"',`resigndate`='1969-12-31',`designation`='"+employee.getDesignation()+"',`email`='"+employee.getEmail()+"',`address`='"+employee.getAddress()+"' where `email`='"+employee.getEmail()+"'";

		st.executeUpdate(sql);

	}
}
