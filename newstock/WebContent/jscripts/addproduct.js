function validateForm(form)
{
	if (form.pname.value == "") {
		alert("ProductName cannot be blank!");
		form.pname.focus();
		return false;
	}
	re = /^\w+$/;
	if (!re.test(form.pname.value)) {
		alert("ProductName must contain only letters, numbers and underscores!");
		form.pname.focus();
		return false;
	}		
   return true;
   }
