import java.util.Scanner;

public class User {
	Scanner mouth = new Scanner(System.in);
	String name = "사용자";
	
	public int answerNum() {
		return mouth.nextInt();
	}
}
