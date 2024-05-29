import java.util.Scanner;
@SuppressWarnings("resource")
public class PMain7 {
	// 거스름돈 환전 프로그램
	// 함수 사용 (O)
	
	// < 입력 >
	// 구매한 물건 가격 : 35000
	// 낸 돈 : 41530
	// ----------------------------------
	// 거스름돈 : 6530 을
	//		50000 : 0
	//		10000 : 0
	//		5000 : 1
	//		1000 : 1
	//		500 : 1
	//		100 : 0
	//		50 : 0
	//		10 : 3
	
	public static int getPrice() {
		Scanner k = new Scanner(System.in);
		System.out.println("====================");
		System.out.print("구매한 물건 가격 : ");
		int price = k.nextInt();
		if (price < 0) {
			System.err.println("물건 가격은 양수로 입력해주세요");
			int i = getPrice();
			price = i;
		}
		return price;
	}
	
	public static int payMoney(int p) {
		Scanner k = new Scanner(System.in);
		System.out.println("====================");
		System.out.print("지불한 금액 : ");
		int money = k.nextInt();
		if (p > money) {
			System.err.println("지불한 금액이 가격보다 적습니다");
			
			
			System.out.println("다시 입력해주세요");
		}
		return money >= p ? money : payMoney(p);
	}
	
	public static int calcChange(int p, int m) {
		int change = m - p;
		return change;
	}
	
	public static void printInfo(int p, int m, int c) {
		System.out.println("====================");
		System.out.printf("구매한 물건의 가격은 %d원\n지불하신 금액은 %d원입니다\n"
				+ "거스름돈은 %d원 되겠습니다\n", p, m, c);
	}
	
	public static void printChange(int c) {
		// 2가지 방법..
		//	1.
		int[] currency = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
		int times = 0;
		System.out.println("====================");
		for (int i = 0; i < currency.length; i++) {
			times = 0;
			while (c >= currency[i]) {
				c -= currency[i];
				times++;
			}
			if (times == 0) {
				continue;
			}
			System.out.printf("%d원\t:\t%d개\n", currency[i], times);
		}
		System.out.println("====================");
		//	2.
//		int currency2 = 100000;
//		while (true) {
//			currency2 /= 2;
//			if (c >= currency2) {
//				System.out.printf("%d원\t:\t%d개\n", currency2, c / currency2);
//				c %= currency2;
//			}
//			currency2 /= 5;
//			if (c >= currency2) {
//				System.out.printf("%d원\t:\t%d개\n", currency2, c / currency2);
//				c %= currency2;
//			}
//			if (currency2 == 10) {
//				break;
//			}
//		}
	}
	
	public static void main(String[] args) {
		int price = getPrice();
		int money = payMoney(price);
		int change = calcChange(price, money);
		printInfo(price, money, change);
		printChange(change);
	}
	
	
	
		
	
}
