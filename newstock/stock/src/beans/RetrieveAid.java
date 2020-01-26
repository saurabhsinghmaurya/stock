package beans;

public class RetrieveAid {
	int id;
	String articleid;
	String brand;
	long quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArticleid() {
		return articleid;
	}
	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public RetrieveAid(int id, String articleid, String brand, long quantity) {
		super();
		this.id = id;
		this.articleid = articleid;
		this.brand = brand;
		this.quantity = quantity;
	}

	
}
