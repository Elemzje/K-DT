
// 재귀적 호출 (recursive call)
//	함수 속에서 자기 자신(이 함수)을 또 호출 => 반복

// 함수를 호출한다 : 비교적 느린 작업

// 반복문 : ex) 'for'

// 기업에서 테스트할 때 이걸 활용한 알고리즘을 문제로 내는 경우가 있음

public class FMain5 {
	
	// 등차수열
	// 정수를 하나 넣으면
	// 1 + 2 + 3 + 4 + ... + 그 숫자까지
	// 다 더한 값을 구해주는 함수
	
	// add(1) = 1
	// add(2) = 3
	// add(3) = 6
	
	public static int add(int x) {
		
		int answer = (x == 1) ? 1 : (x + add(x-1));
		return answer;
				
		
		
//		return x * (x + 1) / 2;
//		int o = 0;
//		for (int i = 1; i <= x; i++) {
//			o += i;
//		}
	}
	
	// 정수를 하나 넣으면 factorial값 구하는 함수
	// ex) 6! = 720
	//	1! = 1
	//	2! = 2
	//	3! = 6
	
	public static int factorial(int x) {
		
		int answer = x == 1 ? 1 : x * factorial(x - 1);
		return answer;
	}
	
	// 피보나치 수열
	//	1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
	//	정수를 하나 넣으면 해당 위치에 나올 숫자값 구하기
	
	public static int fibonacci(int x) {
		
		int answer = x <= 2 ? 1 : fibonacci(x - 1) + fibonacci(x - 2);
		return answer;
	}
	
	// 숫자 하나를 넣어서 각 자릿수의 숫자를 더한 값 구하기
	// ex) digitSum(12345) = 15
	
	public static int digitSum(int x) {
		int answer = x < 10 ? x : x % 10 + digitSum(x / 10);
		return answer;
	}
	
	public static void main(String[] args) {
		int a = add(3);
		System.out.println(a);
		int f = factorial(6);
		System.out.println(f);
		int fib = fibonacci(15);
		System.out.println(fib);
		int d = digitSum(12345);
		System.out.println(d);
	}
	
	
	
	
	
	
	
}
