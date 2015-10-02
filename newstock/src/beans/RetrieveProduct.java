package beans;

public class RetrieveProduct {
String product;
int id;
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getProduct() {
	return product;
}

public void setProduct(String product) {
	this.product = product;
}

public RetrieveProduct( int id,String product) {
	super();
	this.id = id;
	this.product = product;
}


}
