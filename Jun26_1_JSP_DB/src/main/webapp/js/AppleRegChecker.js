function regCheck() {
	let aL = document.appleForm.a_location
	let aC = document.appleForm.a_color
	let aF = document.appleForm.a_flavor
	let aP = document.appleForm.a_price
	let aI = document.appleForm.a_introduce
	
	if (isEmpty(aL)) {
		alert("Please Fill in Location Properly.");
		aI.focus();
		return false;
	} else if (isEmpty(aC)) {
		alert("Please Fill in Color Properly.");
		aC.value = "";
		aC.focus();
		return false;
	} else if (isEmpty(aF)) {
		alert("Please Fill in Flavor Properly.");
		aF.value = "";
		aF.focus();
		return false;
	} else if (isEmpty(aP) || isNotNumber(aP)) {
		alert("Please Fill in Price Properly.");
		aP.value="";
		aP.focus();
		return false;
	} else if (isEmpty(aI) || atLeastLetter(aI, 5)) {
		alert("Please Fill in Introduce Properly.");
		aI.value = "";
		aI.focus();
		return false;
	}
	
	return true;
}