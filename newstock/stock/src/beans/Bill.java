package beans;

public class Bill {
	String product;
	long quantity;
     long price;
	long billId;
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
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getBillId() {
		return billId;
	}
	public void setBillId(long billId) {
		this.billId = billId;
	}
	public Bill(String product, long quantity, long price, long billId) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.billId = billId;
	}

	

}
