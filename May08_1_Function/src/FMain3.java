import java.util.Random;
import java.util.Scanner;

public class FMain3 {
	// 홀짝 게임 (함수.ver)
	
	/*
	 * 홀짝 게임을 시작하는걸 출력할 함수
	 * 1~10까지 랜덤한 정수를 구할 함수
	 * 랜덤한 정수가 홀수인가 짝수인가 판별할 함수
	 * 유저가 홀, 짝을 입력하게 할 함수
	 * 결과를 확인할 함수
	 * 결과를 출력할 함수
	 * 함수를 모은 함수
	 */
	
//	public static void printStart() {
//		System.out.println("홀짝게임을 시작합니다 !");
//	}
//	
//	public static int getNum() {
//		Random r = new Random();
//		int i = r.nextInt(10) + 1;
//		return i;
//	}
//	
//	public static String checkEvenOdd(int comNum) {
//		String c = comNum % 2 == 1 ? "홀" : "짝";
//		return c;
//	}
//	
	public static String getUserGuess() {
		Scanner k = new Scanner(System.in);
		System.out.print("홀/짝 중 선택하세요 : ");
		String u = k.next();
		k.close();
		return u;
	}
//	
//	public static String getResult(String comGuess, String userGuess) {
//		String r = comGuess.equals(userGuess) ? "정답" : "오답";
//		return r;
//	}
//	
//	public static void printResult(int c, String r) {
//		System.out.printf("컴퓨터가 뽑은 수는 %d입니다 !\n[%s]\n", c, r);
//	}
//	
//	public static void start() {
//		printStart();
//		int comNum = getNum();
//		String comGuess = checkEvenOdd(comNum);
//		String userGuess = getUserGuess();
//		String result = getResult(comGuess, userGuess);
//		printResult(comNum, result);
//	}
	
	// 코드 줄이기 과정

	public static void printStart() {
		System.out.println("홀짝게임을 시작합니다 !");
	}
	
	public static int getNum() {
		return new Random().nextInt(10)+1;
	}
	
	public static String checkEvenOdd(int comNum) {
		return comNum % 2 == 1 ? "홀" : "짝";
	}
	
//	public static String getUserGuess() {
//		System.out.print("홀/짝 중 선택하세요 : ");
//		return new Scanner(System.in).next();
//	}
	
	public static String getResult(String comGuess, String userGuess) {
		return comGuess.equals(userGuess) ? "정답" : "오답";
	}
	
	public static void printResult(int c, String r) {
		System.out.printf("컴퓨터가 뽑은 수는 %d입니다 !\n[%s]\n", c, r);
	}
	
	public static void start() {
		printStart();
		int comNum = getNum();
		String comGuess = checkEvenOdd(comNum);
		String userGuess = getUserGuess();
		String result = getResult(comGuess, userGuess);
		printResult(comNum, result);
	}
	
	public static void main(String[] args) {
		start();
		
		
		
		
	}
	
	// 랜덤한 동전 갯수 가져오기
	// 질문 & 답 입력
	// 동전 갯수가 홀수면 '홀', 짝수면 '짝'
	// 비교해서 결과 내기
	// 출력
	// 함수들 모으기
	
	
	
	
	
}
