import java.util.Scanner;

public class YMain1 {
	public static void main(String[] args) throws InterruptedException {

		// 오늘 기분은 어떤가요 ?
		// 오늘 컨디션 점수는 ?
		// 대중교통 몇 번 갈아타고 오셨는지 ?
		// 밤에 푹 주무셨는지 (잘 잤으면 true / 아니면 false)
		// 몇 시간 주무셨나요 ? (ex : 6.0시간)
		
		// Scanner로 입력을 받아서 출력까지 !
		
		Scanner k = new Scanner(System.in);
		
		System.out.print("오늘 기분은 어떤가요? : ");
		String toDayFeeling = k.next();
		
		System.out.print("오늘 컨디션 점수는? : ");
		int condition = k.nextInt();
		
		System.out.print("대중교통 몇 번 갈아타고 오세요? : ");
		int transport = k.nextInt();
		
		System.out.print("밤에 푹 주무셨나요? : ");
		boolean goodNight = k.nextBoolean();
		
		System.out.print("몇 시간 주무셨나요? : ");
		double sleepTime = k.nextDouble();
		
		System.out.println("_________________________\n");
		System.out.println("오늘 기분은 어떤가요? : " + toDayFeeling);
		System.out.printf("오늘 컨디션 점수는? : %d점 / 100점\n", condition);
		System.out.printf("대중교통 몇 번 갈아타고 오세요? : %d회\n", transport);
		System.out.println("밤에 푹 주무셨나요? : " + goodNight);
		System.out.printf("몇 시간 주무셨나요? : %.1f시간\n", sleepTime);
		
		
		
		
		
		
		
		
		
	
		k.close();
		Thread.sleep(0);
	}
}
