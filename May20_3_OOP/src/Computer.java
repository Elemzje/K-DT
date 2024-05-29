import java.util.Random;

public class Computer {
	Random brain = new Random();
	int hand;
	
	public int getComRSP() {
		return brain.nextInt(3) + 1;
	}
}
