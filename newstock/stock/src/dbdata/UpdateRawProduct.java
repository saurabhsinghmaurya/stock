package dbdata;

import java.sql.Connection;
import java.sql.Statement;

public class UpdateRawProduct {
public void update(String product,int limit) throws Exception {
	Dbmanager db = new Dbmanager();
	Connection con = db.getconnection();
	Statement st = con.createStatement();
	String sql =
	"update `rawproduct` set `limit`='"+limit+"' where `product`='"+product+"'";
	
	st.executeUpdate(sql);
	
			
}
}
