function bmiCheck() {
	let nameBox = document.ff.name;
	let heightBox = document.ff.height;
	let weightBox = document.ff.weight;
	let photoBox = document.ff.photo;
	
	if (isEmpty(nameBox) || atLeastLetter(nameBox, 2)) {
		alert('Please Fill in Your Name Properly.');
		nameBox.value = "";
		nameBox.focus();
		return false;
	} else if (isEmpty(heightBox) || isNotNumber(heightBox) || atLeastLetter(heightBox, 3)) {
		alert('Please Fill in Your Height Properly.');
		heightBox.value = "";
		heightBox.focus();
		return false;
	} else if (isEmpty(weightBox) || isNotNumber(weightBox) || atLeastLetter(weightBox, 3)) {
		alert('Please Fill in Your Weight Properly.');
		weightBox.value = "";
		weightBox.focus();
		return false;
	} else if (isEmpty(photoBox) || 
			(isNotType(photoBox, "png") && isNotType(photoBox, "jpg") && 
			isNotType(photoBox, "jpg") && isNotType(photoBox, "jfif"))) {
		alert('Please Fill in Your Photo Properly.');
		photoBox.value = "";
		photoBox.focus();
		return false;
	}
	return true;
}