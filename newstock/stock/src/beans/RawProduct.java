package beans;

public class RawProduct {
int pid;
String product;
long limit;
long quantity;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getProduct() {
	return product;
}
public void setProduct(String product) {
	this.product = product;
}
public long getLimit() {
	return limit;
}
public void setLimit(long limit) {
	this.limit = limit;
}
public long getQuantity() {
	return quantity;
}
public void setQuantity(long quantity) {
	this.quantity = quantity;
}
public RawProduct(int pid, String product, long limit, long quantity) {
	super();
	this.pid = pid;
	this.product = product;
	this.limit = limit;
	this.quantity = quantity;
}

}
