function setConvertType(convertType) {
	document.convertForm.convertType.value = convertType;
}

function inputCheck() {
	let bnBox = document.convertForm.beforeNum;
	let ctBox = document.convertForm.convertType;
	
	if (isEmpty(bnBox) || isNotNumber(bnBox)) {
		alert('Please Fill in Your Number Properly');
		bnBox.value = "";
		bnBox.focus();
		return false;
	} else if (isNotNumber(ctBox)) {
		alert('Please Choose one of Convert Type');
		bnBox.focus();
		return false;
	}
	return true;
}