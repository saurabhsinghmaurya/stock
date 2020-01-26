package beans;

public class Employee {
	String name;
	String father;
	String gender;
	String bday;
	String mobile;
	long salary;
	String status;
	String joinDate;
	String designation;
	String email;
	String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBday() {
		return bday;
	}

	public void setBday(String bday) {
		this.bday = bday;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employee(String name, String father, String gender, String bday,
			String mobile, long salary, String status, String joinDate,
			String designation, String email, String address) {
		super();
		this.name = name;
		this.father = father;
		this.gender = gender;
		this.bday = bday;
		this.mobile = mobile;
		this.salary = salary;
		this.status = status;
		this.joinDate = joinDate;
		this.designation = designation;
		this.email = email;
		this.address = address;
	}



}
