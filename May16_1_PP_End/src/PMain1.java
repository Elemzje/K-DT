import java.util.Random;
import java.util.Scanner;

public class PMain1 {
	// 베스킨라빈스 31게임!
	// 유저 먼저 시작! (1 ~ 3 사이 정수)
	// main함수에
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Random r = new Random();
		int userNum = 0;
		int comNum = 0;
		int num = 0;
		while (true) {
			System.out.printf("현재 숫자는 %d입니다\n", num);
			while (true) {
				System.out.print("숫자를 입력해주세요 : ");
				userNum = k.nextInt();
				if (userNum < 1 || userNum > 3) {
					System.out.println("-------------------------");
					System.out.println("숫자범위는 1 ~ 3입니다");
					System.out.println("다시 입력해주세요");
					System.out.println("-------------------------");
					continue;
				} else {
					num += userNum;
					break;
				}
			}
			if (num >= 31) {
				System.out.println("당신이 숫자 31을 넘겼습니다");
				System.out.println("패배하셨습니다");
				System.out.println("-------------------------");
				break;
			}
			System.out.printf("현재 숫자는 %d입니다\n", num);
			System.out.println("-------------------------");
			comNum = r.nextInt(3) + 1;
			System.out.printf("컴퓨터의 숫자는 %d입니다\n", comNum);
			System.out.println("-------------------------");
			num += comNum;
			if (num >= 31) {
				System.out.println("컴퓨터가 숫자 31을 넘겼습니다");
				System.out.println("축하드립니다 승리하셨습니다");
				System.out.println("-------------------------");
				break;
			}
			
		}
		
		k.close();
	}
	
	
	
	
	
	
	
	
	
}

























