import java.util.Random;
import java.util.Scanner;
@SuppressWarnings("resource")

// 가위바위보 연승 게임 (함수 사용 O)
//	1. 가위 => 콘솔창에 1을 입력하면 가위
//	2. 바위 => 콘솔창에 2를 입력하면 바위
//	3. 보 => 콘솔창에 3를 입력하면 보
// 컴퓨터와 가위바위보를 해서 1번 질동안 몇 승 하는지 출력까지!

public class PMain4 {
	public static int getUserAns() {
		Scanner k = new Scanner(System.in);
		System.out.println("1. 가위\n2. 바위\n3. 보");
		System.out.println("-------------------------");
		System.out.print("1, 2, 3 : ");
		int userRSP = k.nextInt();
		return (userRSP > 0 && userRSP < 4) ? userRSP : getUserAns();
	}
	
	public static int getComAns() {
		Random r = new Random();
		int comRSP = r.nextInt(3) + 1;
		return comRSP;
	}
	
	public static void printAnswer(int u, int c) {
		if (u == 1) {
			System.out.println("유저는 가위를 냈습니다");
		} else if (u == 2) {
			System.out.println("유저는 바위를 냈습니다");
		} else {
			System.out.println("유저는 보를 냈습니다");
		}
		if (c == 1) {
			System.out.println("컴퓨터는 가위를 냈습니다");
		} else if (c == 2) {
			System.out.println("컴퓨터는 바위를 냈습니다");
		} else {
			System.out.println("컴퓨터는 보를 냈습니다");
		}
	}
	
	public static int judgeWinLose(int u, int c) {
		if (u == c) {
			return 1;
		} else if (u - c == 1 || (u == 1 && c == 3)) {
			return 0;
		} else {
			return 2;
		}
	}
	
//	public static int judge(int user, int com) {
//		int game = user - com;
//		if (game == 0) {
//			System.out.println("무승부");
//			return 0;
//		} else if (game == -1 || game == 2) {
//			System.out.println("패배");
//			return 1509;
//		} else {
//			System.out.println("승리");
//			return 1;
//		}
//	}
	
	public static boolean printResult(int r) {
		if (r==2) {
			System.out.println("패배");
			return false;
		} else if (r==1) {
			System.out.println("무승부");
		} else {
			System.out.println("승리");
		}
		System.out.println("-------------------------");
		return true;
	}
	
	public static void printFinalResult(int winTimes) {
		System.out.println("-------------------------");
		System.out.println("승리한 횟수 : " + winTimes);
	}
	
	public static int rematch(int w, boolean r) {
		int userAns = 0;
		int comAns = 0;
		int result = 0;
		while (r) {
			userAns = getUserAns();
			comAns = getComAns();
			printAnswer(userAns, comAns);
			result = judgeWinLose(userAns, comAns);
			if (result == 0) {
				w++;
			}
			r = printResult(result);
		}
		return w;
	}
	
	public static void start() {
		int winTimes = 0;
		boolean rematch = true;
		winTimes = rematch(winTimes, rematch);
		printFinalResult(winTimes);
	}
	
	public static void main(String[] args) {
		start();
	}
	
}
