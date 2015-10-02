package dbdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class RetrieveBrand {

	/**
	 * @param args
	 */
	public String getBrand(String user,String product,String aid) throws Exception{
		String brand=null;
		Dbmanager db=new Dbmanager();
		Connection con= db.getconnection();
		Statement st=con.createStatement();
		IdHandler i=new IdHandler();
		String sql="select * from subproduct where articleid="+"'"+aid+"' and pid="+i.getPid(user, product) ;
		//System.out.println("sql "+sql);
	    ResultSet rs=st.executeQuery(sql);
		if(rs.next()){
			brand=rs.getString(3);
			
		}
		con.close();
		
		return brand;
	}
	public int getQuntity(String user,String product,String aid) throws Exception{
		int quantity=0;
		Dbmanager db=new Dbmanager();
		Connection con= db.getconnection();
		Statement st=con.createStatement();
		IdHandler i=new IdHandler();
		String sql="select * from subproduct where articleid="+"'"+aid+"' and pid="+i.getPid(user, product)+" and action='0' " ;
		//System.out.println("sql "+sql);
	    ResultSet rs=st.executeQuery(sql);
		if(rs.next()){
			quantity=rs.getInt(4);
			
		}
		con.close();
		
		return quantity;
	}
	public boolean checkProduct(String user,String product) throws Exception {
		Dbmanager db=new Dbmanager();
		Connection con= db.getconnection();
		Statement st=con.createStatement();
		IdHandler i=new IdHandler();
		String sql="select * from product where product='"+product+"' and id="+i.getId(user);
		ResultSet rs=st.executeQuery(sql);
		if(rs.next()){
			return false;
			
		}
		con.close();
		return true;
		
	}
	public boolean checkAid(String user,String product,String aid) throws Exception {
		Dbmanager db=new Dbmanager();
		Connection con= db.getconnection();
		Statement st=con.createStatement();
		IdHandler i=new IdHandler();
		String sql="select * from subproduct where articleid='"+aid+"' and pid="+i.getPid(user, product);
		ResultSet rs=st.executeQuery(sql);
		if(rs.next()){
			return false;
			
		}
		return true;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
RetrieveBrand rb=new RetrieveBrand();
try {
	System.out.println(rb.checkAid("cs.0905410016@gmail.com","daru","67"));
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
