// 수학, 영어점수를 입력받아서 평균 점수를 출력해주는 프로그램
// 출력 (document.write)
let mathScore = prompt("수학 점수");	// 80
let engScore = prompt("영어 점수");		// 90
let avg = (mathScore + engScore) / 2;
document.write(`평균 점수 ${avg}점<br>`); // 4045???

let mathScore2 = 80;	// 80
let engScore2 = 90;		// 90
let avg2 = (mathScore2 + engScore2) / 2;
document.write(`평균 점수 ${avg2}점<br>`); // 85 !


// prompt로 받은 값은 무조건 문자형(String)
//	"80" + "90" = 170 (x) / "8090" (o)
//	"8090" / 2 = 4045 ...? => NaN 아니고...?
//	"8090"은 분명 문자열인데.. 계산이 되었음
//		숫자형이 아니더라도 표현식(+ - * /)을 활용했을 때 숫자형으로 변환할 수 있다면
//		자동으로 형 변환이 되어서 계산이 됨
//		'자동 형 변환' 이라고 함

// 자동 형변환이 좋아보이지만
// 원인을 찾기 힘든 에러를 발생시킬 여지도 충분히 있음 !
//		=> 항상 의도를 가지고 원하는 타입(자료형)으로 변환해서 사용하는 것이 바람직하다! 
//			'명시적 형 변환'

// 4. 형 변환

// String() :	=> 문자형으로 변환
// Number() :	=> 숫자형으로 변환
// Boolean() :	=> 논리형으로 변환

// 형 변환은 왜 필요할까요 ~ ?
//	자료형이 다른 두 변수를 계산했을 때, 원하는 결과가 나오지 않을 수 있음

// String() : S는 대문자 ! / 괄호안의 값을 문자형으로 바꿔줌
document.write("String() <br>");
document.write(
	String(3) + "<br>",
	String(true) + "<br>",
	String(false) + "<br>",
	String(null) + "<br>",
	String(undefined) + "<br>"
);
document.write('-------------------------<br>');

// Number() : N은 대문자 / 괄호안의 값을 숫자형으로 바꿔줌
document.write("Number() <br>");
document.write(
	Number("1234") + "<br>",	// 1234
	Number("asdf") + "<br>",	// NaN (Not a Number)
	Number(true) + "<br>",		// 1
	Number(false) + "<br>"		// 0
);
document.write('-------------------------<br>');

// Boolean() : B는 대문자 / 괄호안의 값을 논리형으로 바꿔줌

// false가 나오는 경우들을 알아두면
//	- 숫자 0
//	- 빈 문자열("") / 띄어쓰기 X
//	- null
//	- undefined
//	- NaN

// 이외에는 모두 true가 됨!

// 주의사항 => 딱히 설명이 없어서... 인지해두시는게 좋겠어요..
Number(null);		// 0
Number(undefined);	// NaN

let a = Number(prompt("asdf"));
document.write(a + '<br>'); // prompt에 값을 넣지 않았다면 ??
							// => 값을 넣지 않아서 null
							// => Number(null); => 0