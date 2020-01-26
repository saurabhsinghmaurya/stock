package beans;

public class BillUserName {
	int billId;
	String name;
	String mobile;
	String date;
	String operator;

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public BillUserName(int billId, String name, String mobile, String date,
			String operator) {
		super();
		this.billId = billId;
		this.name = name;
		this.mobile = mobile;
		this.date = date;
		this.operator = operator;
	}

}
