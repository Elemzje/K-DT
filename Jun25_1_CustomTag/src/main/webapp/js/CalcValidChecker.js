function calcCheck() {
	let x = document.calcForm.x
	let y = document.calcForm.y
	
	if (isEmpty(x) || isNotNumber(x) || isEmpty(y) || isNotNumber(y)) {
		alert("Please Fill in Number Properly");
		x.value = "";
		y.value = "";
		x.focus();
		return false;
	}
	return true;
}