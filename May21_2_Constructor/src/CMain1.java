
public class CMain1 {
	public static void main(String[] args) {
		// 신발
		// 나이키 홈페이지
		
		// 이름 : ???
		// 사이즈 : 260
		// 가격 : 110000
		// 브랜드 : 나이키
		// 정보 출력
		// -----------------
		// 이름 : ???
		// 사이즈 : 260
		// 가격 : 110000
		// 브랜드 : 나이키
		// 정보 출력
		// -----------------
		
		Shoes s1 = new Shoes();
		Shoes s2 = new Shoes();
		
		s1.name = "vomero";
		s1.size = 270;
		s1.price = 189000;
		s1.printInfo();

		s2.name = "P-6000";
		s2.size = 275;
		s2.price = 129000;
		s2.printInfo();
		
		// 생성자 오버로딩
		Shoes s3 = new Shoes("신발", 250, 3000);
		s3.printInfo();
		
		s2.test(s2.name);
		System.out.println("-----");
		s2.test("zzz");
		System.out.println("-----");
		
		// 커피
		// 커피 이름 / 가격
		// 출력
		
		Coffee c = new Coffee("조지아", 3500);
		c.printInfo();
		
		
	}
}
