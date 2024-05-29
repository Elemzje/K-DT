import java.util.Random;
import java.util.Scanner;

public class YMain {
	// 홀짝게임 만들기!
	// 		동전 10개를 쥐고 있다가! => 섞어서 동전갯수 고름
	//		내가 '홀'이라고 하면...
	//		정답인지 아닌지 판정해서 그 결과를 출력해주는 프로그램
	public static void main(String[] args) throws InterruptedException {
		Random r = new Random();
//		int i = r.nextInt();		// int범위안에 있는 랜덤한 정수
//		int i2 = r.nextInt(5);		// 0 ~ 4 중 랜덤한 정수
//		int i3 = r.nextInt(5) + 1; 	// 1 ~ 5 중 랜덤한 정수
//		System.out.println(i);
//		System.out.println(i2);
//		System.out.println(i3);
		
		
		Scanner k = new Scanner(System.in);
		int coin = r.nextInt(10) + 1;
		System.out.println("짤짤짤짤..");
		String evenOdd = coin % 2 == 1 ? "홀" : "짝";
		System.out.print("'홀', '짝' 중 선택하세요 ! : ");
		String pick = k.next();
		String judgment = pick.equals(evenOdd) ? "정답" : "오답";	
		System.out.println("컴퓨터가 고른 동전의 갯수는");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(500);
		System.out.printf("%d개로 %s입니다!\n", coin, judgment);
		
		// 입력받을 준비
		// 랜덤하게 동전을 뽑을 준비
		// 지정한 갯수 중에서 랜덤한 동전 갯수를 뽑기
		// 동전 갯수가 홀수면 '홀', 짝수면 '짝'
		// 답을 맞출 수 있게 입력
		// 결과를 맞춰봐야!
		//	(컴퓨터가 뽑은 정답과 내가 입력한 정답이 같은지)
		
		
		
		
		
		k.close();
	}
}
