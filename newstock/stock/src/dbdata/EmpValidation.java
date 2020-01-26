package dbdata;

import java.util.regex.Pattern;

import beans.Employee;

public class EmpValidation {
public boolean validation(Employee emp) {
	if(!emp.getName().trim().equalsIgnoreCase("")&&!emp.getFather().trim().equalsIgnoreCase(""))
	{
		boolean mob=Pattern.matches("^[0-9]{10}",emp.getMobile());
		Long l=emp.getSalary();
		boolean salary=Pattern.matches("\\d*",l.toString());
		boolean email=Pattern.matches("^([0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-\\w]*[0-9a-zA-Z]\\.)+[a-zA-Z]{2,9})$",emp.getEmail());
		if(mob&&email&&salary&&!emp.getDesignation().equalsIgnoreCase("")&&!emp.getAddress().trim().equalsIgnoreCase("")){
			
			return true;
		}
	}
	return false;
}

}
