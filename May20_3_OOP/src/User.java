import java.util.Scanner;

public class User {
	Scanner brain = new Scanner(System.in);
	int hand;
	int win;
	int draw;
	
	public int getUserRSP() {
		return brain.nextInt();
	}
	
}
