package dbdata;

import java.sql.Connection;
import java.sql.Statement;

public class UpdateOperator {
public void updatePassword(String email,String oldPassword,String newPassword ) throws Exception {
	Dbmanager db = new Dbmanager();
	Connection con = db.getconnection();
	Statement st = con.createStatement();
	String sql =
	"update `operator` set `password`='"+newPassword+"' where  email='"+email+"'and `password`='"+oldPassword+"'";

	
	st.executeUpdate(sql);
	

}
public void removeOperator(String email) throws Exception {
	Dbmanager db = new Dbmanager();
	Connection con = db.getconnection();
	Statement st = con.createStatement();
	String sql =
	"delete from `operator` where `email`='"+email +"';";

	
	st.executeUpdate(sql);

}
}
