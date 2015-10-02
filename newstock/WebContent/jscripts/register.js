function validateForm(form) {
	if (form.user.value == "") {
		alert("Username cannot be blank!");
		form.name.focus();
		return false;
	}
	re = /^\w+$/;
	if (!re.test(form.user.value)) {
		alert("Username must contain only letters, numbers and underscores!");
		form.name.focus();
		return false;
	}
	var x = document.forms["register"]["email"].value;
	var atpos = x.indexOf("@");
	var dotpos = x.lastIndexOf(".");
	if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
		alert("Not a valid e-mail address");
		return false;

	}

	if (form.pass.value != ""
			&& form.pass.value == form.cpass.value) {
		if (form.pass.value.length < 6) {
			alert("Password must contain at least 6 characters and maximum contain 15 characters !");
			form.pass.focus();
			return false;
		}
		if (form.pass.value.length > 15) {
			alert("Password must contain at least 6 characters and maximum contain 15 characters !");
			form.pass.focus();
			return false;
		}

		if (form.pass.value == form.user.value) {
			alert("Password must be different from Username!");
			form.pass.focus();
			return false;
		}
	}

	else {
		alert("Please check that you've entered and confirmed your password!");
		form.pass.focus();
		return false;
	}


	re = /^\d{10}$/;
	if (!re.test(form.mobile.value)) {
		alert("It is not valid mobile number.input 10 digits number!");
		form.mobile.focus();
		return false;
		}
	
	return true;

}
