function goAppleDetail(route) {
	location.href = "AppleDetailController?d=" + route;
}

function deleteApple(loc) {
	let t = confirm(`${loc} 사과 진짜 지우려고 ?`);
	if (t) {
		location.href = "AppleDeleteController?d=" + loc;
	}
}