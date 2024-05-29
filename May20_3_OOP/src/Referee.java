
public class Referee {
	String[] ruleBook = { "s;lk", "가위", "바위", "보" };
	
	public int askGuess(Computer c) {
		System.out.println("가위 바위 보?");
		c.hand = c.getComRSP();
		return c.hand;
	}
	
	public int askGuess(User u) {
		System.out.println("1. 가위, 2. 바위, 3. 보");
		System.out.print("번호> ");
		u.hand = u.getUserRSP();
		return u.hand > 0 && u.hand < 4 ? u.hand : askGuess(u);
	}
	
	public boolean judgeResult(Computer c, User u) {
		if (c.hand == u.hand) {
			return true;
		} else if (c.hand - u.hand == 1 || (c.hand == 1 && u.hand == 3)) {
			return false;
		} else {
			return true;
		}
	}
	
	public void printResult(Computer c, User u) {
		if (c.hand == u.hand) {
			System.out.printf("컴퓨터와 유저 모두 %s를 내 무승부!\n", ruleBook[c.hand]);
			u.draw++;
		} else {
			System.out.printf("컴퓨터는 %s 유저는 %s를 내 유저의 승리!\n", ruleBook[c.hand], ruleBook[u.hand]);
			u.win++;
		}
		System.out.println("=====================");
	}
	
	public void printEnd(Computer c, User u) {
		System.out.printf("컴퓨터는 %s 유저는 %s를 내 유저의 패배!\n", ruleBook[c.hand], ruleBook[u.hand]);
	}
	
	public void printWinrate(User u) {
		System.out.println("=====================");
		System.out.printf("승리 %d회, 무승부 %d회!", u.win, u.draw);
	}
	
	public void start(Computer c, User u) {
		boolean result = true;
		while (true) {
			c.hand = askGuess(c);
			u.hand = askGuess(u);
			result = judgeResult(c, u);
			if (result) {
				printResult(c, u);
			} else {
				printEnd(c, u);
				break;
			}
		}
		printWinrate(u);
	}
	
}
