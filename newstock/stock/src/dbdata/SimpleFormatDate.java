package dbdata;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.text.SimpleDateFormat;

public class SimpleFormatDate
{
	public java.sql.Date getDate() {
		
		Date todaysDate = new java.util.Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		  String formattedDate = formatter.format(todaysDate);
		  java.sql.Date d=java.sql.Date.valueOf(formattedDate);
		return d;
	}
  public static void main(String args[]){
  Date todaysDate = new java.util.Date();
  // Formatting date into  yyyy-MM-dd HH:mm:ss e.g 2008-10-10 11:21:10
 
 // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 // String formattedDate = formatter.format(todaysDate);
 // System.out.println("Formatted date is ==>"+formattedDate);

  // Formatting date into  yyyy-MM-dd e.g 2008-10-10 
  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
  String formattedDate = formatter.format(todaysDate);
  System.out.println("Formatted date is ==>"+formattedDate);
java.sql.Date d=java.sql.Date.valueOf(formattedDate);
  // Formatting date into  MM/dd/yyyy e.g 10/10/2008 
  Dbmanager db = new Dbmanager();
try{
	Connection con = db.getconnection();
	PreparedStatement pr = con
			.prepareStatement("INSERT INTO date VALUES (?)");
	pr.setDate(1, d);
	pr.executeUpdate();
	
}
catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
  }
}