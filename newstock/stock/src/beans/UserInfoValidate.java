package beans;

public class UserInfoValidate {
	String user;
	String email;
	String pass;
	String cpass;
	String gen;
	String mobile;
	String add;

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCpass() {
		return cpass;
	}

	public void setCpass(String cpass) {
		this.cpass = cpass;
	}

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public boolean validate() {
		if (this.getUser() == null || this.getPass() == null
				|| this.getEmail() == null || this.getGen() == null
				|| this.getCpass() == null || this.getMobile() == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean validatePass() {
		if (this.getPass().equals(this.getCpass())) {
			return true;
		} else {
			return false;
		}
	}

	public UserInfoValidate(String user, String email, String pass,
			String cpass, String gen, String mobile, String add) {
		super();
		this.user = user;
		this.email = email;
		this.pass = pass;
		this.cpass = cpass;
		this.gen = gen;
		this.mobile = mobile;
		this.add = add;
	}

}
