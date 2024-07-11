$(function() {
	$("#loginForm").submit(function() {
		let idBox = document.loginForm.m_id;
		let pwBox = document.loginForm.m_pw;
		
		if (isEmpty(idBox)) {
			alert("Please Fill in Your ID Properly");
			return false;
		} else if (isEmpty(pwBox)) {
			alert("Please Fill in Your Password Properly");
			pwBox.focus();
			return false;
		}
		return true;
	});
	
	$("#signinForm").submit(function() {
		let idBox = document.signinForm.m_id;
		let pwBox = document.signinForm.m_pw;
		let pwchkBox = document.signinForm.m_pwCheck;
		let affiBox = document.signinForm.m_affiliation;
		let pass1 = "abcdefghijklmnopqrstuvwxyz"; 
		let pass2 = "1234567890"; 
		
		if (atLeastLetter(idBox, 6) || containsAnother(idBox) || 
				notContain(idBox, pass1) || notContain(idBox, pass2)) {
			alert("Please Fill in Your ID Properly");
			idBox.value = "";
			idBox.focus();
			return false;
		} else if (atLeastLetter(pwBox, 6) || containsAnother(pwBox) || 
				notContain(pwBox, pass1) || notContain(pwBox, pass2)) {
			alert("Please Fill in Your Password Properly");
			pwBox.value = "";
			pwBox.focus();
			return false;
		} else if (notEqualPw(pwBox, pwchkBox)) {
			alert("Your Password Check is Not Equal to Your Password");
			pwchkBox.value = "";
			pwchkBox.focus();
			return false;
		} else if (isEmpty(affiBox)) {
			alert("Please Fill in Your Affiliation Properly");
			affiBox.value = "";
			affiBox.focus();
			return false;
		}
		return true;
	});	
	
	$("#userInfoForm").submit(function() {
		let pwBox = document.userInfoForm.m_pw;
		let pwchkBox = document.userInfoForm.m_pwCheck;
		let affiBox = document.userInfoForm.m_affiliation;
		let pass1 = "abcdefghijklmnopqrstuvwxyz"; 
		let pass2 = "1234567890"; 
		
		if (atLeastLetter(pwBox, 6) || notContain(pwBox, pass1) || 
				notContain(pwBox, pass2) || containsAnother(pwBox)) {
			alert("Please Fill in Your Password Properly");
			pwBox.focus();
			pwBox.value = "";
			return false;
		} else if (notEqualPw(pwBox, pwchkBox)) {
			alert("Your Password Check is Not Equal to Your Password");
			pwchkBox.focus();
			pwchkBox.value = "";
			return false;
		} else if (isEmpty(affiBox)) {
			alert("Please Fill in Your Affiliation Properly");
			affiBox.value = "";
			affiBox.focus();
			return false;
		}
		return true;
	});
});