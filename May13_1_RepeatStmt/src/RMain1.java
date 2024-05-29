import java.util.Random;
import java.util.Scanner;

public class RMain1 {
	
	// Up & Down 게임 (main에)
	// 1 ~ 100 사이의 숫자
	// 컴퓨터 vs 나 => 같은 숫자내면 종료
	//		숫자가 나보다 낮으면 Down!
	// 		숫자가 나보다 높으면 Up!
	//		몇 턴만에 정답을 찾았는지 출력
	
	public static void main(String[] args) throws InterruptedException {
		Scanner k = new Scanner(System.in);
		Random r = new Random();
		int comNum = r.nextInt(100) + 1;
		int userNum = 0;
		int tryTimes = 0;
		for (int i = 1; comNum != userNum; i++) { 
			System.out.print("컴퓨터의 숫자는? : ");
			userNum = k.nextInt();
			if (comNum < userNum) {
				System.err.printf("%d Down!\n", userNum);
			} else if (comNum > userNum) {
				System.err.printf("%d Up!\n", userNum);
			}
			Thread.sleep(50);
			tryTimes = i;
		}
		System.out.printf("정답입니다! 당신은 %d회 시도했습니다", tryTimes);
		
		int myNum = 0;
		for (int turn = 1; true; turn++) { // 몇 번 반복할지 모르기 때문에
											// 조건을 지정할 수 없음
											// true로 자리를 메워줌
			System.out.print("입력 : ");
			myNum = k.nextInt();
			
			if (comNum < myNum) {
				System.out.println("Down !");
			} else if (comNum > myNum) {
				System.out.println("Up !");
			} else {
				System.out.println("정답 !");
				System.out.printf("%d번만에 정답을 맞췄습니다.\n", turn);
				break;		// 반복문을 깨버림
			}
			System.out.println("************************************");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		k.close();
	}
	
	
}
