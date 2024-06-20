// M
//	(유효성검사 파일도 front-end개발자 A가 만들었음)
//	front-end개발자 B

function check() {
	let x = document.f.x;
	let y = document.f.y;
	
	if (isEmpty(x) || isNotNumber(x)
		|| isEmpty(y) || isNotNumber(y)) {
		alert("Ouch !");	
		return false;
	}
	return true;
}





