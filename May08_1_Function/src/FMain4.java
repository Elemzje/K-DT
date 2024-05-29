import java.util.Random;
import java.util.Scanner;

public class FMain4 {
	// 동전 맞추기 게임
	// 10개
	
	/*
	 * 동전 갯수 랜덤으로 정하기
	 * 동전 갯수 맞추기
	 * 정답 확인
	 * 출력
	 * 함수모으기
	 */
	
	// 동전 10개 섞기
	// 질문 & 답 입력
	// 답 맞춰보기
	// 출력
	
	public static int shakeCoin() {
		return new Random().nextInt(10) + 1;
	}
	
	@SuppressWarnings("resource")
	public static int askUserAns() {
		System.out.print("컴퓨터는 몇 개의 동전을 가지고 있을까요 ?\n(1 ~ 10) : ");
		return new Scanner(System.in).nextInt();
	}
	
	public static String checkAns(int coin, int answer) {
		return coin == answer ? "정답" : "오답";
	}
	
	public static void printResult(int coin, int answer, String result) {
		System.out.printf("당신의 답변은 %d 실제 동전의 갯수는 %d로 %s입니다!\n", answer, coin, result);
	}
	
	public static void start() {
		int coin = shakeCoin();
		int answer = askUserAns();
		String result = checkAns(coin, answer);
		printResult(coin, answer, result);
	}
	
	public static void main(String[] args) {
		start();
	}
	

	
	
	
}
