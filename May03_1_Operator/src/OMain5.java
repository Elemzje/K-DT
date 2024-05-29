import java.util.Scanner;

public class OMain5 {
	public static void main(String[] args) throws InterruptedException {
		
		// 키(cm), 몸무게(kg)를 입력받아서
		//		=> 비만도 검사 프로그램
		
		// 표준체중 = (키 - 100) x 0.9
		// 비만도 = (실제 체중 / 표준체중) x 100
		// 비만도가 120을 넘으면 "비만",
		// 	아니면 "안비만" 문구를 출력
		// 아무 키나 입력했을 때 프로그램이 종료되게!
		
		Scanner k = new Scanner(System.in);
		
		System.out.print("키(cm) : ");
		double height = k.nextDouble();
		System.out.print("몸무게(kg) : ");
		double weight = k.nextDouble();
		System.out.printf("당신의 키는 %.1fcm, 몸무게는 %.1fkg입니다.\n", height, weight);
		
		double standard = (height - 100) * 0.9;
		System.out.printf("당신과 동일한 신장의 표준 체중은 %.1fkg입니다.\n", standard);
		double obesity = weight / standard * 100;
		String bmi = obesity > 120 ? "비만" : "안비만";
		System.out.printf("당신의 비만도는 %.1f로 %s입니다.\n", obesity, bmi);
		
		System.out.print("아무 키나 입력하면 종료됩니다.");
		String quit = k.next();
		System.out.println(quit);
		k.close();
		
		Thread.sleep(500);
	}
}
