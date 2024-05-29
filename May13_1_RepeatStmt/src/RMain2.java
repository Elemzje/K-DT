import java.util.Random;

// for (변수초기화; 조건식; 값의증감) {
//		내용
// }

public class RMain2 {
	public static void main(String[] args) {
		// 1 ~ 100까지의 정수 중에서 6의 배수만 더한 값을 출력
		int sum = 0;
		for (int i = 0; i < 101; i++) {
			sum = i % 6 == 0 ? sum + i : sum;
		}
		System.out.println(sum);
		
		// 4x + 5y = 60이 되는 해(정수)를 모두 구해서
		// (x, y)의 형태로 출력
		// x, y는 둘 다 10 이하의 정수(1 ~ 10)
		double x = 0;
		for (int y = 0; y <= 10; y++) {
			x = (60 - ((double) y * 5)) / 4;
			if (x % 1 == 0 && x <= 10) {
				System.out.printf("%.0f, %d\n", x , y);
			}
		}
		
		for (int x1 = 1; x1 <= 10; x1++) {
			for (int y = 1; y <= 10; y++) {
				if (4 * x1 + 5 * y == 60) {
					System.out.printf("(%d, %d)\n", x1, y);
				}
			} 
		}
		System.out.println("-----------------------");
		
		// 반복 횟수가 명확 = for문 (O)
		
		// 반복 조건 (if문의 반복버전)
		//	while 문 : 조건을 먼저 검사
		//		조건이 true(참)인 동안에 계속 반복해서 수행 부분을 실행시킴
		//		실행부분에서 조건을 false(거짓)으로 만들어서 멈추도록 하거나
		//		break; 명령어로 반복문을 종료시킬 수 있음
		//		조건이 맞지 않으면 반복하고 있던 작업을 중지!
		//		무한대로 반복하고 싶을 때 조건에 true 사용
		
		// while : 반복 횟수를 정확히 알 수 없을 때,
		//			특별한 조건에서 멈춰야 하는 경우에 사용
		//			while (조건식) {
		//				내용
		//			}
		// 한번도 반복 안할수도 있음 ㅎ_ㅎ;;
		Random r = new Random();
		int z = r.nextInt(10) + 1; // 랜덤한 정수를 한 번 뽑았고
		while (z != 9) {			// 9가 아니면 (= 9가 나올때까지 반복)
			System.out.println(z);
			z = r.nextInt(10) + 1; // 다시 while으로 돌아가서 조건을 체크
		}
		System.out.println(z);
		System.out.println("-----------------------");
		
		// do-while문 : 실행부터 하고 조건을 나중에 검사 (거의 안씀)
		// 한번은 반복이 보장 O
		do {
			z = r.nextInt(3) + 1;
			System.out.println(z);
		} while (z != 3);
		System.out.println("-----------------------");
		
		// 1 ~ n번째 더했을 때 100이 넘어가면 반복문이 종료되게
		//	총 합은 몇인지 / n의 값은 몇인지 출력
		int sum2 = 0;
		int num = 0;
		while (sum2 <= 100) {
			sum2 = sum2 + ++num;
		}
		System.out.printf("총 합 = %d, n = %d\n", sum2, num);
		System.out.println("-----------------------");
		
		// 1000 이하의 숫자 중에서
		// 가장 큰 15의 배수는 ?
		int multiply = 0;
		int d = 0;
		while (multiply <= 1000) {
			d = multiply % 15 == 0 ? multiply : d;
			multiply ++;
		}
		System.out.println(d);
		System.out.println("-----------------------");
		
		int num3 = 1000;
		while (num3 % 15 > 0) {
			num3--;
		}
		System.out.println("1000이하 정수 중에서 가장 큰 10의 배수 : "+ num3);
	}
}
