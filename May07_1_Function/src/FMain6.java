import java.util.Random;

public class FMain6 {
	// 랜덤한 정수를 '출력'하는 함수!
	// 랜덤한 정수를 '생성'하는 함수!
	// 정수를 하나 넣으면 홀수인지 짝수인지 출력하는 함수!
	// 정수를 두 개 넣었을 때,
	//	앞 숫자가 크면 '앞', 뒷 숫자가 크거나 같으면 '뒤' 생성하는 함수!
	
	public static void printRandomInt() {
		Random r = new Random();
		int i = r.nextInt();
		System.out.println(i);
	}
	
	public static int returnRandomInt() {
		Random r = new Random();
		int i = r.nextInt();
		return i; // i에 있는 값을 최종 결과로 리턴
				  // 이 함수는 종료
	}
	
	public static void evenOdd(int number) {
		String result = number % 2 == 1 ? "홀수" : "짝수";
		System.out.printf("%d는 %s!\n", number, result);
	}
	
	public static char whichIsBig(int a, int b) {
		char ruling = a > b ? '앞' : '뒤';
		return ruling;
	}
	
	public static void main(String[] args) {
		printRandomInt();
		int randomInt = returnRandomInt();
		System.out.println(randomInt);
		evenOdd(294);
		char ruling = whichIsBig(14, 14);
		System.out.println(ruling);
		
		System.out.println("==========================");
		// 저녁메뉴 (2가지 중 하나)
		// 위의 함수를 이용
		//	랜덤한 숫자 2개를 뽑아서
		//	먼저 뽑힌게 크면 '초밥', 아니면 '파스타' 를 출력		
		int i = returnRandomInt();
		int i2 = returnRandomInt();
		
		char s = whichIsBig(i, i2);
		String menu = s == '앞' ? "닭갈비" : "미역국";
		System.out.printf("오늘 저녁은 %s!\n", menu);
		
	}
	
	
	
	
	
	
	
	
	
}












