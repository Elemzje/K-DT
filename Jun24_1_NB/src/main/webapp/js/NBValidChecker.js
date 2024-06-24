function round(n) {
	let num = n - n % 1;
	return num;
}

function isDupe(input) {
	let iv = input.value;
	let h = round(iv / 100);
	let t = round((iv / 10) % 10);
	let o = iv % 10;
	if (h == t || h == o || t == o) {
		return true;
	}
	return false;
}

function check() {
	let guess = document.ff.guess;
	if (atLeastLetter(guess, 3) || isNotNumber(guess) || isDupe(guess)) {
		alert('숫자는 3자리, 각 자리는 중복되지 않게 입력해주세요');
		return false;
	}
	return true;
}