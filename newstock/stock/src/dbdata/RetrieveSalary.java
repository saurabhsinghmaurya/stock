package dbdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import beans.Salary;

public class RetrieveSalary {
	public LinkedList<Salary> getSalary(int eid) throws Exception {
		LinkedList<Salary> getSal = new LinkedList<Salary>();
		Dbmanager db = new Dbmanager();
		Connection con = db.getconnection();
		Statement st = con.createStatement();
		String sql = "select * from salary where eid="+ eid+" order by sno";
		// System.out.println("sql "+sql);
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			getSal.add(new Salary(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
		}
		return getSal;
	}
	public static void main(String[] args) {
		RetrieveSalary retrieveSalary=new RetrieveSalary();
		LinkedList<Salary> list = null;
		try {
			list = retrieveSalary.getSalary(12);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Salary salary : list) {
			System.out.println(salary.getName());
		}
	}
}
