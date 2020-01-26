package dbdata;

import java.sql.Connection;
import java.sql.Statement;

public class UpdateOrderStatus {
public void update(String status,int sno) throws Exception {
	Dbmanager db = new Dbmanager();
	Connection con = db.getconnection();
	Statement st = con.createStatement();
	String sql = "update `vendor` set `status`='"+status+"' where `sno`='"+sno+"'";

	st.executeUpdate(sql);

}
}
