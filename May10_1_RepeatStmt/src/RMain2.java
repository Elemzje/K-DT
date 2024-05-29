
// 이중 for문 >> for문 안에 for문 >> 중첩 for문

public class RMain2 {
	public static void main(String[] args) {
		for (int i = 1; i < 6; i++) {
			System.out.printf("i값 : %d------------\n", i);
			for (int j = 1; j < 6; j++) {
				System.out.printf("j값 : %d\n", j);
			}
		}
		System.out.println("------------------------------");
		
		// 구구단
		// <2단>
		// 2 x 1 = 2
		// ...
		// 9 x 9 = 81
		
		for (int i = 2; i < 10; i++) {
			System.out.printf("<%d단>\n",i);
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d X %d = %d\n", i, j, i * j);
			}
		}
		System.out.println("------------------------------");
		
		// 구구단을 가로로!
		// <2단> <3단> ... <9단>
		// 2 x 1 = 2 ...
		//					9 x 9 = 81
		
		for (int dan = 2; dan < 10; dan++) {
			System.out.printf("<  %d단  >\t", dan);
		}
		System.out.println();
		for (int j = 1; j < 10; j++) {
			for (int i = 2; i < 10; i++) {
				System.out.printf("%d x %d = %d\t", i, j , i * j);
			}
			System.out.println();
		}
		
	}
}
