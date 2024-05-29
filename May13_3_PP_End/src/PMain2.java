import java.util.Scanner;

public class PMain2 {
	
	// ATM기능을 하는 프로그램
	//	1을 고르면 입금 / 2를 고르면 출금 / 3을 고르면 잔액 확인
	//	4를 고르면 프로그램 종료
	//	입급, 출금 돈 값을 입력 받을 것!
	//	main함수에
	
	public static void main(String[] args) throws InterruptedException {
		Scanner k = new Scanner(System.in);
		int money = 0;
		int num = 0;
		int plusMinus = 0;
		a : while (true) {
			Thread.sleep(40);
			System.out.print("서비스를 선택하세요\n1. 입금, 2. 출금,"
					+ " 3. 잔액확인, 4. 서비스 종료 : ");
			num = k.nextInt();
			switch (num) {
			case 1:
				System.out.print("입금하실 금액을 입력해주세요 : ");
				plusMinus = k.nextInt();
				money += plusMinus;
				break;
			case 2:
				System.out.print("출금하실 금액을 입력해주세요 : ");
				plusMinus = k.nextInt();
				if (plusMinus > money) {
					System.out.println("잔액이 부족합니다");
					break;
				}
				money -= plusMinus;
				break;
			case 3:
				System.err.printf("잔액은 %d원 입니다.\n", money);
				break;
			case 4:
				System.out.println("서비스를 종료합니다");
				break a;
			}
		}
		k.close();
	}
	
	
	
	
}
