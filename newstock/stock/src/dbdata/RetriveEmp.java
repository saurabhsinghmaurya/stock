package dbdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import beans.Employee;

public class RetriveEmp {

	/**
	 * @param args
	 */
	

	public LinkedList<Employee> getAllEmp() throws Exception {
		LinkedList<Employee> getEmp = new LinkedList<Employee>();
		Dbmanager db = new Dbmanager();
		Connection con = db.getconnection();
		Statement st = con.createStatement();
		String sql = "select * from employee order by eid";
		// System.out.println("sql "+sql);
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			getEmp.add(new Employee(rs.getString(2), rs.getString(3), rs
					.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7),
					rs.getString(8), rs.getString(9), rs.getString(11), rs
							.getString(12), rs.getString(13)));
		}
		return getEmp;
	}
public Employee getEmp(String email) throws Exception{
	Dbmanager db = new Dbmanager();
	Connection con = db.getconnection();
	Statement st = con.createStatement();
	String sql = "select * from employee where email='"+email +"' order by eid";
	// System.out.println("sql "+sql);
	ResultSet rs = st.executeQuery(sql);
	Employee emp = null;
	while (rs.next()) {
		
		emp=new Employee(rs.getString(2), rs.getString(3), rs
				.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7),
				rs.getString(8), rs.getString(9), rs.getString(11), rs
						.getString(12), rs.getString(13));
	}
	return emp;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
RetriveEmp emp=new RetriveEmp();
try {
	LinkedList< Employee> list=emp.getAllEmp();
	for (Employee employee : list) {
		System.out.println(employee.getBday());
	}
	System.out.println(emp.getEmp("ghg2").getName());
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
