import java.util.Scanner;

public class CMain7 {
	// f1 : 정수를 하나 입력 받아서
	// 그게 양수면 "양" / 0이면 "0" / 음수면 "음" 출력
	
	// f2 : 정수를 하나 입력 받아서
	// 3의 배수면 "3의 배수"
	// 4의 배수면 "4의 배수"
	// 둘 다 아니면 "몰라!!!"
	// 를 판정해주는 함수
	
	@SuppressWarnings("resource")
	public static void f1() {
		Scanner k = new Scanner(System.in);
		System.out.print("숫자 : ");
		int i = k.nextInt();
//		if (i > 0) {
//			System.out.println("양");
//		} else if (i == 0) {
//			System.out.println("0");
//		} else {
//			System.out.println("음");
//		}
		switch (sigmoid(i)) {
		case 1:
			System.out.println("양");
			break;
		case 0:
			System.out.println("0");
			break;
		case -1:
			System.out.println("음");
			break;
		default:
			break;
		}
	}
	
	public static int sigmoid(int i) {
		if (i > 0) {
			return 1;
		} else if (i < 0) {
			return -1;
		} else {
			return 0;
		}
	}
	
	@SuppressWarnings("resource")
	public static String f2() {
		Scanner k = new Scanner(System.in);
		System.out.print("숫자 : ");
		int i = k.nextInt();
//		if (i % 12 == 0) {
//			return "3과 4의 공배수";
//		} else if (i % 3 == 0) {
//			return "3의 배수";
//		} else if (i % 4 == 0) {
//			return "4의 배수";
//		} else {
//			return "몰라!!!";
//		}
		switch (i % 12) {
		case 3: case 6: case 9:
			return "3의 배수";
		case 4: case 8:
			return "4의 배수";
		case 0:
			return "3과 4의 공배수";
		default:
			return "몰라!!!";
		}
	}
	
	
	
	public static void main(String[] args) {
		f1();
		String s = f2();
		System.out.println(s);
	}
}
