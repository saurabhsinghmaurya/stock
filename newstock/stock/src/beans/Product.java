package beans;

public class Product {
	long pid;
	String product;
	long price;
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Product(long pid, String product, long price) {
		super();
		this.pid = pid;
		this.product = product;
		this.price = price;
	}
	 
	}
