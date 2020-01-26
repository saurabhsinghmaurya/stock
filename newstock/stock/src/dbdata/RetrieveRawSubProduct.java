package dbdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import beans.RawSubProduct;

public class RetrieveRawSubProduct {
public LinkedList<RawSubProduct	> getAll() throws Exception {
	LinkedList<RawSubProduct> getSub=new LinkedList<RawSubProduct>();
	Dbmanager db = new Dbmanager();
	Connection con = db.getconnection();
	Statement st = con.createStatement();
	String sql = "select * from rawsubproduct  order by sid";
	
	ResultSet rs = st.executeQuery(sql);
	while (rs.next()) {
	getSub.add(new RawSubProduct(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getInt(6)));
	}
	return getSub;
}
public LinkedList<RawSubProduct	> getProductDetail(int pid) throws Exception {
	LinkedList<RawSubProduct> getSub=new LinkedList<RawSubProduct>();
	Dbmanager db = new Dbmanager();
	Connection con = db.getconnection();
	Statement st = con.createStatement();
	String sql = "select * from rawsubproduct where pid="+pid+" order by sid";
	
	ResultSet rs = st.executeQuery(sql);
	while (rs.next()) {
	getSub.add(new RawSubProduct(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getInt(6)));
	}
	return getSub;
}
public static void main(String[] args) throws Exception {
	LinkedList<RawSubProduct> h=new RetrieveRawSubProduct().getAll();
	for (RawSubProduct rawSubProduct : h) {
		System.out.println(rawSubProduct.getAction());
	}
}
}

