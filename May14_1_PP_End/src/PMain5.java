// 면접 문제... ㅇ0ㅇ !!!
// Call By Value, Call By Reference
//	어떻게 답이 도출되었는지 설명할 수 있어야

// Call By Value : 변수의 '값'을 복사해서 함수의 파라미터 값으로 사용하는 것
// Call By Reference : 변수를 참조하는 주소값(번지값)을 파라미터로 전달하는 것

public class PMain5 {
	public static void test(int a, int[] b, int[] c) {
		System.out.println("b(green) " + b); 	// b [주소1
		System.out.println("c(green) " + c); 	// c [주소2
		System.out.println(a + "a(green)"); 	// 10a
		System.out.println(b[0] + "b(green)"); 	// 10b
		System.out.println(c[0] + "c(green)"); 	// 10c
		System.out.println("-------------------");
		a = 100;
		b[0] = 100;			// main쪽에 영향을 줌 (참조형)
							// 기본형과 참조형의 차이 !
		
		// c = { 100, 200 }; // 에러! (약식을 사용해도 새로운 수를 만들어내는 것이지
							// 값을 변경하는 것은 아님)
							// 값 변경 = 각각의 요소에 접근을 해야함!
		
		c = new int[] {100,200};	// 말그대로 새로운 수 (new)
									// new int[] 꼭 써줘야 (정규식)
		
		System.out.println("b(green) " + b); 	// b [주소1
		System.out.println("c(green) " + c); 	// c [주소3
		System.out.println(a + "a(green)"); 	// 100a
		System.out.println(b[0] + "b(green)"); 	// 100b
		System.out.println(c[0] + "c(green)");	// 100c
		
	}
	public static void main(String[] args) {
		int a = 10;
		int[] b = {10, 20};
		int[] c = {10, 20};
		System.out.println("b(red) " + b); 	// b [주소1
		System.out.println("c(red) " + c); 	// c [주소2
		System.out.println("-------------------");
		test(a, b, c);
		System.out.println("-------------------");
		System.out.println(a + "a(red)");	// 10a
		System.out.println(b[0] + "b(red)");// 100b
											// *** 값 변경에 영향을 받았음
		System.out.println(c[0] + "c(red)");// 10c
											// *** 값 변경에 영향을 받지 않음
										// test함수의 변경된 c와 다르기 때문
		
	}
}

// Java에서 파라미터를 넘기는 과정에 직접적인 참조를 넘긴게 아닌,
// 주소 값을 '복사'해서 넘기기 때문에 이는 Call by value이다 (입장차이가 있음)