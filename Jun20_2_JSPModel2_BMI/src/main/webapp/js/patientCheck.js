function check() {
	let name = document.pf.name;
	let height = document.pf.height;
	let weight = document.pf.weight;
	let photo = document.pf.photo;
	
	if (isEmpty(name) || atLeastLetter(name, 2)) {
		name.focus();
		name.value = "";
		alert('Put in your name properly.');
		return false;
	} else if (isEmpty(height) || isNotNumber(height)) {
		height.focus();
		height.value = "";
		alert('Put in your height properly.');
		return false;
	} else if (isEmpty(weight) || isNotNumber(weight)) {
		weight.focus();
		weight.value = "";
		alert('Put in your weight properly.');
		return false;
	} else if (isEmpty(photo) || isNotType(photo, jfif)) {
		alert('Put in your photo properly.');
		return false;
	}
	return true;
}