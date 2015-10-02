package dbdata;
import java.sql.*;
import java.util.*;
import beans.*;
public class RetrieveAidDb {
	public LinkedList<RetrieveAid> allAid(String user,String product)throws Exception {
		 LinkedList<RetrieveAid> getAid = new LinkedList<RetrieveAid>();
			Dbmanager db=new Dbmanager();
			Connection con= db.getconnection();
			Statement st=con.createStatement();
			IdHandler i=new IdHandler();
			String sql="select * from subproduct where pid="+i.getPid(user, product)+" and action='0' order by sid";
			//System.out.println("sql "+sql);
		    ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
			getAid.add(new RetrieveAid(rs.getInt(1),rs.getString(2)));
			
			}
			con.close();
			return getAid;
		}
	public LinkedList<RetrieveAid> subTable(String user,String product)throws Exception {
		 LinkedList<RetrieveAid> getAid = new LinkedList<RetrieveAid>();
			Dbmanager db=new Dbmanager();
			Connection con= db.getconnection();
			Statement st=con.createStatement();
			IdHandler i=new IdHandler();
			String sql="select * from subproduct where pid="+i.getPid(user, product)+" and action='0' order by sid";
			//System.out.println("sql "+sql);
		    ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
			getAid.add(new RetrieveAid(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			
			}
			con.close();
			return getAid;
		}
	
}
