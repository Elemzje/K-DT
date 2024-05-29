
public class VMain2 {
	public static void main(String[] args) {
		// 이름, 오늘 날짜 (연도.월.일), 사는 곳(지역),
		// 시력, java경험의 유무(%b) 를 변수에 담아서 출력
		
		String name = "이민주";
		int year = 2024;
		int month = 5;
		int day = 2;
		String region = "서울 강서구";
		double sight = 0.2;
		boolean experience = false;
		System.out.printf("이름 : %s\n", name);
		// System.out.println("이름 : " + name);
		System.out.printf("날짜 : %d.%02d.%02d\n", year, month, day);
		System.out.printf("사는 곳 : %s\n", region);
		System.out.printf("시력 : %.1f\n", sight);
		System.out.printf("Java 경험 : %b\n", experience);
		// System.out.println("Java 경험 : "+ experience);
		System.out.println("--------------");
		
		// 섬유향수
		// 1000원
		// 80ml
		// 체리블라썸
		// 향균은 99.9%
		// 무색
		// 다이소
		// 재활용 해야함(true / false)
		
		String product = "섬유향수";
		int price = 1000;
		int capacity = 80;
		String scent = "체리블라썸";
		double antibacterial = 99.9;
		String color = "무색"; // char color = '무'
		// System.out.printf("색 : %c색\n", color);
		String purchase = "다이소";
		boolean recycling = true;
		
		System.out.println("제품명 : " + product);
		System.out.printf("가격 : %d원\n", price);
		System.out.printf("용량 : %dml\n", capacity);
		System.out.println("향 : " + scent);
		System.out.printf("향균 : %.1f%%\n", antibacterial);
		System.out.println("색상 : " + color);
		System.out.println("구매처 : " + purchase);
		System.out.printf("재활용 : %b\n", recycling);
		
		
		
		
		
		
		
		
		
		
		
		
	}
}



















