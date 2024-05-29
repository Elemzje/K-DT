import java.util.Scanner;

public class YMain1 {
	
	// (3보다 작은) 정수를 하나 입력받는 함수
	// 3보다 크거나 같을 때 => 정수를 다시 입력 받을 수 있도록!
	
	@SuppressWarnings("resource")
	public static int getInt() {
		System.out.print("3보다 작은 정수 : ");
		int i = new Scanner(System.in).nextInt();
		return i < 3 ? i : getInt();
	}
	
	
	// 홀수만 입력 받을 수 있는 함수
	//	=> 짝수를 입력하면 다시 입력 받을 수 있도록!
	
	@SuppressWarnings("resource")
	public static int getInt2() {
		System.out.print("홀수 : ");
		int i = new Scanner(System.in).nextInt();
		return i % 2 == 1 ? i : getInt2();
	}

	// 정수를 입력받는 함수 => 0 ~ 100
	//	=> 범위 안의 정수가 아니라면 다시 입력 받을 수 있도록!
	
	@SuppressWarnings("resource")
	public static int getInt3() {
		System.out.print("0 ~ 100 : ");
		int i = new Scanner(System.in).nextInt();
		return i >= 0 && i <= 100 ? i : getInt3();
	}
	
	
	public static void main(String[] args) {
		int i = getInt();
		System.out.println(i);
		int i2 = getInt2();
		System.out.println(i2);
		int i3 = getInt3();
		System.out.println(i3);
	}
	
	
	
	
	
	
}
