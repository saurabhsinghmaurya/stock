package dbdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckDatabase {
public boolean checkDatabase(Connection con) throws SQLException {
	Statement st = con.createStatement();
	String sql="show databases";
	ResultSet rs=st.executeQuery(sql);
	while(rs.next()){
		
	String database=rs.getString(1);
	if(database.equalsIgnoreCase("dstock")){
		return true;
	}
		
	
	}
	return false;
	
}
public void execute(Connection  con) throws Exception {
	
	Statement st = con.createStatement();
	String [] sql=new String[12];
	sql[0]="CREATE DATABASE `dstock` ";
	sql[1]="USE `dstock`";
	sql[2]="CREATE TABLE `bill` (`sno` int(11) NOT NULL,`product` varchar(30) NOT NULL,`quantity` int(20) NOT NULL, `price` int(20) NOT NULL,`billid` int(11) NOT NULL,PRIMARY KEY (`sno`))";
	sql[3]="CREATE TABLE `billusername` (`billid` int(11) NOT NULL,`name` varchar(30) NOT NULL,`mobile` varchar(20) NOT NULL,`date` date NOT NULL, `operator` varchar(50) NOT NULL,PRIMARY KEY (`billid`)) ";
	sql[4]="CREATE TABLE `employee` (`eid` int(10) NOT NULL AUTO_INCREMENT, `name` varchar(30) NOT NULL,`fathername` varchar(30) NOT NULL,`gender` varchar(10) NOT NULL,`bday` date NOT NULL,`mobile` varchar(12) NOT NULL,`salary` int(20) NOT NULL,`status` varchar(15) NOT NULL,`joindate` date NOT NULL,`resigndate` date NOT NULL DEFAULT '3000-01-01', `designation` varchar(40) NOT NULL, `email` varchar(50) NOT NULL,`address` varchar(300) NOT NULL,PRIMARY KEY (`email`), UNIQUE KEY `eid` (`eid`)) ";
	sql[5]="CREATE TABLE `operator` ( `id` int(5) NOT NULL AUTO_INCREMENT,`name` varchar(30) NOT NULL, `email` varchar(30) NOT NULL,`password` varchar(30) NOT NULL, `eid` int(11) NOT NULL, PRIMARY KEY (`email`), UNIQUE KEY `id` (`id`)) ";
	sql[6]="CREATE TABLE `product` (`pid` int(12) NOT NULL AUTO_INCREMENT,`product` varchar(50) NOT NULL,`price` int(20) NOT NULL,PRIMARY KEY (`product`),UNIQUE KEY `pid` (`pid`)) ";
	sql[7]="CREATE TABLE `rawproduct` (`pid` int(20) NOT NULL, `product` varchar(50) NOT NULL, `limit` int(20) NOT NULL, `quantity` int(20) NOT NULL,PRIMARY KEY (`product`)) ";
	sql[8]="CREATE TABLE `rawsubproduct` ( `sid` int(10) NOT NULL, `quantity` int(20) NOT NULL, `price` int(20) NOT NULL, `action` varchar(450) NOT NULL, `date` date NOT NULL, `pid` int(11) NOT NULL, PRIMARY KEY (`sid`)) ";
	sql[9]="CREATE TABLE `salary` (`sno` int(11) NOT NULL, `name` varchar(30) NOT NULL,`salary` varchar(15) NOT NULL, `date` date NOT NULL, `eid` int(11) NOT NULL, PRIMARY KEY (`sno`))";
	sql[10]="CREATE TABLE `userinfo` (`id` int(10) DEFAULT NULL,`name` varchar(270) DEFAULT NULL, `usermail` varchar(270) DEFAULT NULL, `password` varchar(135) DEFAULT NULL, `gender` varchar(90) DEFAULT NULL, `mobile` varchar(270) DEFAULT NULL, `address` varchar(900) DEFAULT NULL) ";
	sql[11]="CREATE TABLE `vendor` (`sno` int(11) NOT NULL AUTO_INCREMENT,`product` varchar(50) NOT NULL,`vendor` varchar(50) NOT NULL,`quantity` int(20) NOT NULL,`price` int(20) NOT NULL, `date` date NOT NULL, `status` varchar(50) NOT NULL, PRIMARY KEY (`sno`)) ";
	for (String string : sql) {
		st.executeUpdate(string);
	}
}
}
