import java.util.Scanner;

public class YMain2 {
	// 정수 2개를 입력받아서 (각각의 함수에)
	// 그 정수 2개를 더했을 때 짝수면 결과를 리턴, 아니면 값을 재입력
	
	@SuppressWarnings("resource")
	public static int getNum() {
		System.out.print("숫자1 : ");
		int i = new Scanner(System.in).nextInt();
		return i;
	}
	
	@SuppressWarnings("resource")
	public static int getNum2() {
		System.out.print("숫자2 : ");
		int i = new Scanner(System.in).nextInt();
		return i;
	}
	
	// 덧셈을 계산해서 결과를 리턴할 함수
	
	public static int getResult(int x, int y) {
		int sum = x + y;
		return sum % 2 == 0 ? sum : getResult(getNum(),getNum2());
//		return sum % 2 == 0 ? sum : getResult(x,y);
									// 원하는 값이 들어오지 않으면
									// 무한 루프가 돌아감
				// => 처음 홀수를 입력한 값이 계속해서 계산됨!
	}
	
	public static int plus() {
		int a = getNum();
		int b = getNum2();
		return (a + b) % 2 == 0 ? a + b : plus();
	}
	
	public static void main(String[] args) {
//		int x = getNum();
//		int y = getNum2();
		int i = plus();
		System.out.println(i);
//		int sum = getResult(x, y);
//		System.out.println(sum);
	}
	
}
