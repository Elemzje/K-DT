
public class PMain4 {
	
	// 명함 만들기
	// 이름 / 나이 / 성별 / 키 / 사는 지역 / 별명 (printf)
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("┌───────────────────────────────┐");
		System.out.printf("│이름\t\t- %s\t│\n", "이민주");
		System.out.printf("│나이\t\t- 만 %d세\t│\n", 19);
		System.out.printf("│성별\t\t- %s\t\t│\n", "남성");
		System.out.printf("│키\t\t- %.1fcm\t│\n", 180.9);
		System.out.printf("│사는 지역\t- %s │\n", "서울시 강서구");
		System.out.printf("│별명\t\t- %s\t\t│\n", "별종");
		System.out.println("└───────────────────────────────┘");
		
		Thread.sleep(10000);
		
	}
}
