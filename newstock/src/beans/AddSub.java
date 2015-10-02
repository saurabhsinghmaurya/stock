package beans;

public class AddSub {
String product;
String aid;
String brand;
String user;
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
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public AddSub(String product, String aid, String brand, String user) {
	super();
	this.product = product;
	this.aid = aid;
	this.brand = brand;
	this.user = user;
}

}
