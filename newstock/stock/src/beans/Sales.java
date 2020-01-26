package beans;

public class Sales {
String product;
long quantity;
long totalPrice;
public String getProduct() {
	return product;
}
public void setProduct(String product) {
	this.product = product;
}
public long getQuantity() {
	return quantity;
}
public void setQuantity(long quantity) {
	this.quantity = quantity;
}
public long getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(long totalPrice) {
	this.totalPrice = totalPrice;
}
public Sales(String product, long quantity, long totalPrice) {
	super();
	this.product = product;
	this.quantity = quantity;
	this.totalPrice = totalPrice;
}

}
