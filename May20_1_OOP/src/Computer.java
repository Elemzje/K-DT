import java.util.Random;

public class Computer {
	int coin = 20;
	Random cpu = new Random();
	int gamecoin;
	String comResult;
	
	public void askCoin(User u) {
		System.out.print("동전 갯수 입력 : ");
		u.ansCoin();
	}
	
	public void shakeCoin(User u) {
		gamecoin = cpu.nextInt(u.userCoin) + 1;
	}
	
	public void judgeCoin() {
		if (gamecoin % 2 == 0) {
			comResult = "짝";
		} else {
			comResult = "홀";
		}
	}
	
	public void askOddEven(User u) {
		System.out.print("홀? 짝? : ");
		u.ansOddEven();
	}
	
	
	public void printResult(User u) {
		System.out.println("동전 갯수 : " + gamecoin);
		if (u.answer.equals(comResult)) {
			System.out.println("정답");
		} else {
			System.out.println("오답");
		}
	}
	
	public void start(User u) {
		askCoin(u);
		shakeCoin(u);
		judgeCoin();
		askOddEven(u);
		printResult(u);
	}
	
}
