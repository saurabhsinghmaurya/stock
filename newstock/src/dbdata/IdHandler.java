package dbdata;

import java.sql.*;


public  class IdHandler {

	/**
	 * @param args
	 */
public void date() {

	System.out.println();
}
	public int getId(String user) throws Exception {
		Dbmanager db = new Dbmanager();
		Connection con = db.getconnection();
		// code for getting id
		int id = 0;
		String s = "'" + user + "'";
		String sql = "select * from userinfo where usermail=" + s+" order by id";
		// System.out.println("sql" + sql);
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);
		// getting auto generated key id
		if (rs.next()) {
			id = rs.getInt(1);
		}
		con.close();
		return id;
	}

	public int getPid(String user, String product) throws Exception {
		Dbmanager db = new Dbmanager();
		Connection con = db.getconnection();
		// code for getting id and confirm table name
		int id = this.getId(user);
		//String table = "producttable" + id;// Product table name
		// System.out.println(table);
		int pid = 0;

		// getting auto generated key pid
		String p = "'" + product + "'";
		String sql1 = "SELECT pid FROM product where product=" + p+" and id="+id+" order by pid";
		// System.out.println("sql1 " + sql1);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql1);
		if (rs.next()) {
			pid = rs.getInt(1);
		}
		con.close();
		return pid;
	}

	public int getSpid(String user, String product, String aid)
			throws Exception {
		Dbmanager db = new Dbmanager();
		Connection con = db.getconnection();
		int spid = 0;
		int id = this.getId(user);
		int pid = this.getPid(user, product);
		String table1 = "sub" + pid + id;
		// System.out.println("table1 " + table1);
		String p = "'" + aid + "'";
		Statement st = con.createStatement();
		// getting auto generated key id for sub table
		String sql = "SELECT id FROM " + table1 + " where articleid=" + p+" order by id";
		// System.out.println(sql);
		ResultSet rs = st.executeQuery(sql);
		if (rs.last()) {
			spid = rs.getInt(1);
		}
		con.close();
		return spid;
	}

	public String getProductTableName(String user) throws Exception {
		String pname = null;
		pname = "producttable" + this.getId(user);
		return pname;

	}

	public String getSubTableName(String user, String product) throws Exception {
		String sname = null;
		sname = "sub" + this.getPid(user, product) + this.getId(user);
		return sname;
	}

	public String getDetailsTableName(String user, String product, String aid)
			throws Exception {
		String dname = null;
		dname = "subdetails" + this.getSpid(user, product, aid)
				+ this.getPid(user, product) + this.getId(user);
		return dname;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IdHandler i = new IdHandler();
		i.date();
		try {
			// System.out.println(i.getId("am"));
			// System.out.println(i.getPid("bm", "ac"));
			// System.out.println(i.getSpid("bm","ac","we3"));
			// System.out.println(i.getProductTableName("sd"));
			//System.out.println(i.getSubTableName("am", "ac"));
			System.out.println(i.getDetailsTableName("dm", "dsfs", "s12"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace()
			System.out.println(e.getMessage() + e.getClass());
		}
	}

}
