import java.util.Random;

public class Friend {
	Random brain = new Random();
	String name = "김친구";
	
	public int writeAnswer() {
		int think = brain.nextInt(100) + 1;
		System.out.println("답 정함");
		return think;
	}
	
}
