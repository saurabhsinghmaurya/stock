function validateForm(form) 
{
	var product = document.getElementById("product").value;
	if (product == -1) {
		alert("Please select a product");
		return false;
	}
	var product = document.getElementById("aid").value;
	if (product == -1) {
		alert("Please select an article id");
		return false;
	}
	re =/^\d{1,9}$/;
	if(!re.test(form.quantity.value))
	{ 
		alert("Quantity must be integer  number !");
		form.quantity.focus();
		return false;
	}
	 if (form.price.value.trim() === "") {
	        alert("Please enter a price");
	        form.price.focus();
	        return false;
	    }
	    if (form.price.value !== "") {
	        if (! (/^\d{1,9}$/.test(form.price.value))) {
	            alert("Please enter a valid price");
	            form.price.focus();
	            return false;
	        }
	    }

	return true;
}