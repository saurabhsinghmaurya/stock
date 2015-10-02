package beans;

public class RetrieveAid {
int id;
String articleid;
String brand;
int quantity;
public int getId() {
	return id;
}
public String getArticleid() {
	return articleid;
}
public String getBrand() {
	return brand;
}
public int getQuantity() {
	return quantity;
}
public RetrieveAid(int id, String articleid, String brand, int quantity) {
	super();
	this.id = id;
	this.articleid = articleid;
	this.brand = brand;
	this.quantity = quantity;
}
public RetrieveAid(int id, String articleid) {
	super();
	this.id = id;
	this.articleid = articleid;
}
}
