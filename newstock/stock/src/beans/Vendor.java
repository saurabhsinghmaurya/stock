package beans;

public class Vendor {
	int sno;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	String product;
	String vendor;
	long quantity;
	long price;
	String date;
	String status;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Vendor(int sno, String product, String vendor, long quantity,
			long price, String date, String status) {
		super();
		this.sno = sno;
		this.product = product;
		this.vendor = vendor;
		this.quantity = quantity;
		this.price = price;
		this.date = date;
		this.status = status;
	}
	
}
