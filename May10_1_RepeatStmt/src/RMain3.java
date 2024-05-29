
public class RMain3 {
	public static void main(String[] args) {
		// 별찍기
		
		// ㅋ
		// ㅋㅋ
		// ㅋㅋㅋ
		// ㅋㅋㅋㅋ
		// ㅋㅋㅋㅋㅋ
		
//		for (int i = 1; i < 6; i++) {
//			for (int j = 5; j > 0; j--) {
//				if (i + j > 5) {
//					System.out.print("ㅋ");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println("-----------------------");
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) { // 반복문 속의 조건문에도 변수를 넣을 수 있다
				System.out.print("ㅋ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
		
		// ㅋ
		//   ㅋ
		//     ㅋ
		// 	     ㅋ
		//         ㅋ
		
		// 1번째 방법
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) { 
				if (j == i) {
					System.out.print("ㅋ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		System.out.println("-----------------------");

		// 2번째 방법
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < i; j++) {
//				System.out.print("  ");
//			}
//			System.out.println("ㅋ");
//		}
//		System.out.println("-----------------------");
		
		// 3번째 방법
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < i; j++) {
//				System.out.print(i == j ? "ㅋ" : "  ");
//			}
//			System.out.println("ㅋ");
//		}
//		System.out.println("-----------------------");
		
		
		
		//     ㅋ    
		//   ㅋ  ㅋ
		// ㅋ      ㅋ
		//   ㅋ  ㅋ  
		//     ㅋ
		// 출력하기
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) { 
//				if (i + j == 2 || i + j == 6 || i * j == 3) {
//					System.out.print("ㅋ");
//				} else {
//					System.out.print("  ");
//				}
//			}
//			System.out.println();
//		}
		
		
		// ㅋㅋㅋㅋㅋ
		// ㅎㅎㅎㅎ
		// ㅋㅋㅋ
		// ㅎㅎ
		// ㅋ
		
		for (int i = 4; i > -1; i--) {
			for (int j = 0; j <= i; j++) {
				System.out.print(i % 2 == 1 ? "ㅎ" : "ㅋ");
			} 
			System.out.println();
		}
		System.out.println("-----------------------");
		
		// ㅋ
		// ㅎㅎㅎ
		// ㅋㅋㅋㅋㅋ
		// ㅎㅎㅎㅎㅎㅎㅎ
		// ㅋㅋㅋㅋㅋㅋㅋㅋㅋ
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= (i * 2); j += 1) {
				System.out.print(i % 2 == 1 ? "ㅎ" : "ㅋ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
		
		//     *
		//    ***
		//   *****
		//  *******
		// *********
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < (i + 6); j++) {
				System.out.print(i + j > 4 ? "*" : " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i * 2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
	}

}
