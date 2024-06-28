function logOut() {
	let logout = confirm("진짜 로그아웃 함?");
	if (logout) {
		location.href = "LoginController";
	}
}

function goInfo() {
	location.href = "InfoController";
}