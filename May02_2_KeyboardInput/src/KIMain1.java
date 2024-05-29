import java.util.Scanner;

public class KIMain1 {
	public static void main(String[] args) throws InterruptedException {
		// Scanner : Java에 내장되어있는 기능 중 하나!
		// 이 기능을 사용하기 위해서 'import' 라는 것이 사용됨
		// 이 Scanner라는걸 사용하려면 조건이 하나 필요한데...
		//	new ~~~ : 객체
		
		// Scanner는 화면(이클립스의 콘솔창)으로부터
		//		데이터를 입력 받는 기능
		
		Scanner keyboard = new Scanner(System.in);
//		System.out.println();
		
		// 이름을 콘솔창에 입력받아서 출력
		System.out.print("이름 : ");
		String name = keyboard.next();
		
		// 키, 몸무게, 신발사이즈, 여행가고싶은곳,
		// 좋아하는 숫자, 퇴근하고싶은지 유무
		// 를 입력받고 변수에 담아서 출력!
		
		System.out.print("키(cm) : ");
		double height = keyboard.nextDouble();
		
		System.out.print("몸무게(kg) : ");
		double weight = keyboard.nextDouble();
		
		System.out.print("신발사이즈(mm) : ");
		int shoesSize = keyboard.nextInt();
		
		System.out.print("가고싶은 여행지 : ");
		String travelDestination = keyboard.next();
		
		System.out.print("좋아하는 숫자(정수) : ");
		int likeNum = keyboard.nextInt();
		
		System.out.print("퇴근하고싶은지 여부(true/false) : ");
		boolean leaveWork = keyboard.nextBoolean();
							//keyboard.hasNext("true로 받고싶은 문자");
		
		System.out.println("-------------------");
		System.out.printf("이름 : %s\n", name);
		System.out.printf("키 : %.1fcm\n", height);
		System.out.printf("몸무게 : %.1fkg\n", weight);
		System.out.printf("신발사이즈 : %dmm\n", shoesSize);
		System.out.printf("가고싶은 여행지 : %s\n", travelDestination);
		System.out.printf("좋아하는 숫자 : %d\n", likeNum);
		System.out.printf("퇴근하고싶다 : %s\n", leaveWork);
		System.out.println("-------------------");
		
		// bat파일 생성 =>
		//  '끄고 싶으면 아무거나 입력하세요 : '
		// 	뭔가를 입력해서 엔터 치면
		//	1초마다 .이 나온 후 (3번)
		// 	'프로그램을 종료합니다' 라는 메시지가 출력되고
		//	0.5초후에 프로그램이 종료
		
		System.out.print("끄고 싶으면 아무거나 입력하세요 : ");
		boolean quit = keyboard.hasNext();
		keyboard.close(); // 있어도 되고.. 없어도 되고..
		System.out.print(".");
		Thread.sleep(1000); // Thread.sleep();은 딜레이를 준다 (force close의 개념이 아님)
		System.out.print(".");
		Thread.sleep(1000);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println("프로그램을 종료합니다 !");
		Thread.sleep(500);
		System.out.println(quit);
		Thread.sleep(0);
		
		
		
		
		
		
		
	}
}
