package dbdata;
import java.util.*;
import beans.*;
import java.sql.*;
import dbdata.*;
@SuppressWarnings("unused")
public class RetrieveProductDb {
	public LinkedList<RetrieveProduct> allProduct(String user)throws Exception {
		 LinkedList<RetrieveProduct> getProduct = new LinkedList<RetrieveProduct>();
			Dbmanager db=new Dbmanager();
			Connection con= db.getconnection();
			Statement st=con.createStatement();
			IdHandler i=new IdHandler();
			String sql="select * from product where id="+i.getId(user)+" order by id";
			//System.out.println("sql "+sql);
		    ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
			getProduct.add(new RetrieveProduct(rs.getInt(1),rs.getString(2)));
			
			}
			con.close();
			return getProduct;
		}
	}
