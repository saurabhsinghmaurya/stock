function validateForm(form) {
	var product = document.getElementById("product").value;
	if (product == -1) 
	{
		alert("Please select an Product.");
		return false;
	}

	if (form.aid.value == "") {
		alert("Article id cannot be blank!");
		form.aid.focus();
		return false;
	}
	re = /^\w+$/;
	if (!re.test(form.aid.value)) {
		alert("Article id must contain only letters, numbers!");
		form.aid.focus();
		return false;
	}
	re = /^[A-Za-z]{3,25}$/;
	if (form.cname.value == "") {
		alert("Brand name  cannot be blank!");
		form.cname.focus();
		return false;
	}
	re = /^\w+$/;
	if (!re.test(form.cname.value)) {
		alert("Brand name must contain only letters!");
		form.cname.focus();
		return false;
	}
	return true;
}