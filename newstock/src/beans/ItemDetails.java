package beans;

import java.sql.Date;

public class ItemDetails {
int id;
String user;
String product;
String aid;
String brand;
int quantity;
int price;
String action;
Date date;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getProduct() {
	return product;
}
public void setProduct(String product) {
	this.product = product;
}
public String getAid() {
	return aid;
}
public void setAid(String aid) {
	this.aid = aid;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

public String getAction() {
	return action;
}
public void setAction(String action) {
	this.action = action;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

public ItemDetails(String user, String product, String aid, String brand,
		int quantity, int price, String action) {
	super();
	this.user = user;
	this.product = product;
	this.aid = aid;
	this.brand = brand;
	this.quantity = quantity;
	this.price = price;
	this.action = action;
}
public ItemDetails(int id, String aid, String brand, int quantity, int price,
		String action, Date date) {
	super();
	this.id = id;
	this.aid = aid;
	this.brand = brand;
	this.quantity = quantity;
	this.price = price;
	this.action = action;
	this.date = date;
}



}
