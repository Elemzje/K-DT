
public class YMain {
	public static void main(String[] args) throws InterruptedException {
		// 학원오는데얼마나 걸렸는지 (시간) : 0.8시간
		System.out.printf("등원 시간\t: %.1f시간\n", 0.8);
		// 어제 저녁 메뉴 ? : ???
		System.out.println("어제 저녁 메뉴\t: 파스타와 피자");
		// 어제 뭐하셨나요 ? : ???
		System.out.println("어제 일과\t: 친구와 산책");
		// 취침 시간 : ?시 ?분
		System.out.printf("어제 취침 시간\t: %02d시 %d분\n", 1, 40);
		// 첫 수업 소감: ???
		System.out.println("첫 수업 소감\t: 처음 배우는 내용이지만\n\t\t쉽게 설명해주셔서"
				+ " 쉽게 배웠다");
		// 수업 성취도 : ?.?%
		System.out.printf("수업 성취도\t: %.1f%%\n", 72.5);		
		// 출력
		
		// => 5초 정도 딜레이걸어서 => .bat로 실행까지!
		Thread.sleep(5000);
		
		
		
	}
}
