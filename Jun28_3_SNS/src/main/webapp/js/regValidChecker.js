
function regCheck() {
	let idBox = document.regForm.id;
	let pwBox = document.regForm.pw;
	let pwchkBox = document.regForm.pwchk;
	let nameBox = document.regForm.name;
	let phoneNumBox = document.regForm.phoneNum;
	let birthdayBox = document.regForm.birthday;
	let imageBox = document.regForm.image;
	let pass1 = "!@#$%^&*()[]{};'<>,./?`~:\|=+-_";
	let pass2 = "1234567890";
	
	if (containsAnother(idBox) || atLeastLetter(idBox, 4)) {
		alert('Please Fill in Your ID Properly');
		idBox.value = "";
		idBox.focus();
		return false;
	} else if (notContain(pwBox, pass1) || notContain(pwBox, pass2) || 
	atLeastLetter(pwBox, 3)) {
		alert('Please Fill in Your PW Properly');
		pwBox.value = "";
		pwBox.focus();
		return false;
	} else if (notEqualPw(pwBox, pwchkBox)) {
		alert('PW Check is Not Equal to Your PW');
		pwchkBox.value = "";
		pwchkBox.focus();
		return false;
	} else if (isEmpty(nameBox)) {
		alert('Please Fill in Your Name Properly');
		nameBox.value = "";
		nameBox.focus();
		return false;
	} else if (atLeastLetter(phoneNumBox, 13) || notContain(phoneNumBox, "-")) {
		alert('Please Fill in Your Phone Number Properly');
		phoneNumBox.value = "";
		phoneNumBox.focus();
		return false;
	} else if (atLeastLetter(birthdayBox, 10) || notContain(birthdayBox, "-")) {
		alert('Please Fill in Your Birthday Properly');
		birthdayBox.value = "";
		birthdayBox.focus();
		return false;
	} else if (isEmpty(imageBox) || (isNotType(imageBox, "jpg") && 
	isNotType(imageBox, "png") && isNotType(imageBox, "jfif") && 
	isNotType(imageBox, "jpeg") && isNotType(imageBox, "gif"))) {
		alert('Please Upload Your Image Properly');
		imageBox.value = "";
		imageBox.focus();
		return false;
	}
 	
	
	return true;
}