package beans;

public class RawSubProduct {
int sid;
long quantity;
long price;
String action;
String date;
int pid;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public long getQuantity() {
	return quantity;
}
public void setQuantity(long quantity) {
	this.quantity = quantity;
}
public long getPrice() {
	return price;
}
public void setPrice(long price) {
	this.price = price;
}
public String getAction() {
	return action;
}
public void setAction(String action) {
	this.action = action;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public RawSubProduct(int sid, long quantity, long price, String action,
		String date, int pid) {
	super();
	this.sid = sid;
	this.quantity = quantity;
	this.price = price;
	this.action = action;
	this.date = date;
	this.pid = pid;
}


}
