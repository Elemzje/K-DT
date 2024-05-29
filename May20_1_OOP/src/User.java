import java.util.Scanner;

public class User {
	Scanner k = new Scanner(System.in);
	int userCoin;
	String answer;
	
	public void ansCoin() {
		userCoin = k.nextInt();
		if (userCoin > 20 || userCoin < 2) {
			System.err.println("2 ~ 20 사이의 범위로 입력하세요");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("동전 갯수 입력 : ");
			ansCoin();
		}
	}
	
	public void ansOddEven() {
		answer = k.next();
		if (!(answer.equals("홀") || answer.equals("짝"))) {
			System.err.println("홀/짝으로 입력하세요");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("홀? 짝? : ");
			ansOddEven();
		}
	}
	
	
}
