package dbdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import beans.RawProduct;

public class RetrieveRawProduct {
public LinkedList<RawProduct> getAll() throws Exception {
	
	LinkedList<RawProduct> getProduct = new LinkedList<RawProduct>();
	Dbmanager db = new Dbmanager();
	Connection con = db.getconnection();
	Statement st = con.createStatement();
	String sql = "select * from rawproduct  order by pid";
	
	ResultSet rs = st.executeQuery(sql);
	while (rs.next()) {
	getProduct.add(new RawProduct(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4)));
	}
	return getProduct;
}
public long  getQuan(String product) throws Exception {
	Dbmanager db = new Dbmanager();
	Connection con = db.getconnection();
	Statement st = con.createStatement();
	String sql = "select * from rawproduct where product='"+product+"'  order by pid";
	ResultSet rs = st.executeQuery(sql);
	long quan=0;
	if (rs.next()) {
	quan=rs.getLong(4);
	}
	return quan;

}
public long  getLimit(String product) throws Exception {
	Dbmanager db = new Dbmanager();
	Connection con = db.getconnection();
	Statement st = con.createStatement();
	String sql = "select * from rawproduct where product='"+product+"'  order by pid";
	ResultSet rs = st.executeQuery(sql);
	long quan=0;
	if (rs.next()) {
	quan=rs.getLong(3);
	}
	return quan;

}
}

