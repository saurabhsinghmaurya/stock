package beans;

public class Salary {
String sno;
String name;
long salary;
String date;
int eid;
public String getSno() {
	return sno;
}
public void setSno(String sno) {
	this.sno = sno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getSalary() {
	return salary;
}
public void setSalary(long salary) {
	this.salary = salary;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public Salary(String sno, String name, long salary, String date, int eid) {
	super();
	this.sno = sno;
	this.name = name;
	this.salary = salary;
	this.date = date;
	this.eid = eid;
}


}
