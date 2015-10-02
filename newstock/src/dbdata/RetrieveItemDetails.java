package dbdata;

import java.sql.*;
import java.util.*;

import beans.*;
public class RetrieveItemDetails {
	public LinkedList<ItemDetails> detailsTable(String user,String product,String aid)throws Exception {
		 LinkedList<ItemDetails> getAid = new LinkedList<ItemDetails>();
			Dbmanager db=new Dbmanager();
			Connection con= db.getconnection();
			Statement st=con.createStatement();
			IdHandler i=new IdHandler();
			String sql="select * from subproduct where articleid="+"'"+aid+"' and pid="+i.getPid(user, product)+" and action!='0'order by sid";
			//System.out.println("sql "+sql);
		    ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
			getAid.add(new ItemDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getDate(7)));
			
			}
			con.close();
			return getAid;
		}
}
