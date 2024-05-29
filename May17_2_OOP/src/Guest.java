import java.util.Scanner;

public class Guest {
	String name = "강환자";
	int age;
	double height;
	double weight;
	Scanner mouth = new Scanner(System.in);
	double bmi;
	String bmiResult;
	
	
	public void pringGuestInfo() {
		System.out.println(name + " " + age);
	}
	
	public void sayHello() {
		System.out.println(name + " : 선생님 안녕하세요");
	}
	
	public double answerHeight() {
		return mouth.nextDouble();
	}
	
	public double answerWeight() {
		return mouth.nextDouble();
	}
	
//	public double giveWeight() {
//		Scanner k = new Scanner(System.in);
//		System.out.print(name + " : 제 몸무게는 ");
//		weight = k.nextDouble();
//		System.out.println(name + " : " + weight + "kg입니다");
//		return weight;
//	}
	
	
}
