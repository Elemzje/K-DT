import java.util.Random;
import java.util.Scanner;

// UP&DOWN 게임 (함수 사용 O)
// 컴퓨터 1 ~ 100 사이의 숫자를 뽑음 (ex : 34)
// 유저가 입력
//		1트 : 50 => down!
//		2트 : 20 => up!
//		...
//		10트 : 34 => 정답!
// n트에 성공!


public class PMain2 {
	public static int getRdmNum() {
		Random r = new Random();
		int comNum = r.nextInt(100) + 1;
		return comNum;
	}
	
	public static int getUserNum() {
		Scanner k = new Scanner(System.in);
		int userNum = 0;
		while (userNum >= 0 && userNum <=100) {
			System.out.print("숫자 : ");
			userNum = k.nextInt();
			break;
		}
		k.close();
		return userNum;
	}
	
	public static void printUserAnswer(int c, int u) {
		if (u > c) {
			System.out.println(" down !");
		} else if (u < c) {
			System.out.println(" up !");
		} else {
			System.out.println(" 정답 !");
		}
	}
	
	public static void printTryTimes(int c) {
		int u = 0;
		for (int turn = 1; true; turn++) {
			if (u == c) {
				break;
			}
			u = getUserNum();
			System.out.print(turn+"트 : "+u);
			printUserAnswer(c, u);
		}
	}
	
	public static void main(String[] args) {
		int comNum = getRdmNum();
		printTryTimes(comNum);
	}
	
	public static boolean test(int c , int u) {
		// 리턴타입 boolean의 경우
		return (c==u); // c == u가 참일때 true 거짓일 때 false를 리턴한다
	}
	
}
