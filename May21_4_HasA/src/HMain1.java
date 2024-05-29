
// A has a B

public class HMain1 {
	public static void main(String[] args) {
		// 이름이 Andrew Kim, 남자, 핸드폰 번호가 010-1234-5678인 사람 // Person
		// 출력
		Person aK = new Person("Andrew Kim", "남자", "010-1234-5678", "식당주인", null);
		aK.printInfo();
		System.out.println("-------------------");
		// 강남포차, 논현동, 02-1111-2222, Andrew Kim의 식당	// place
		// 출력(식당 주인의 정보까지)
		Place gP = new Place("강남포차", "논현동", "02-1111-2222", aK, null);
		gP.printInfo();
		System.out.println("-------------------");
		// 계란말이, 22000원, 강남포차에서 파는 메뉴	// menu
		// 관련된 전체 정보를 출력
		Menu eR = new Menu("계란말이", 22000, gP);
		eR.printInfo();
		System.out.println("-------------------");
		// 석쇠불고기, 25000원, 강남포차에서 파는 메뉴	// menu
		// 관련된 전체 정보를 출력
		Menu sB = new Menu("석쇠불고기", 25000, gP);
		sB.printInfo();
		System.out.println("-------------------");
		// 석쇠, 5000원, 석쇠불고기를 담은 접시	// item
		// 관련된 전체 정보를 출력
		Item ss = new Item("석쇠", 5000, sB);
		ss.printInfo();
		System.out.println("-------------------");
		// 가락시장, 송파구, 석쇠를 구매한 시장 // place
		// 관련된 전체 정보를 출력
		Place gS = new Place("가락시장", "송파구", null, null, ss);
		gS.printInfo();
		System.out.println("-------------------");
		// 곽두팔, 가락시장을 좋아하는 상인	// Person
		// 관련된 전체 정보를 출력
		Person dK = new Person("곽두팔", null, null, "상인", gS);
		dK.printInfo();
		System.out.println("-------------------");
		System.out.println("======================");
		
		// 곽두팔의 이름만 출력
		System.out.println(dK.name);
		System.out.println("-------------------");
		// 곽두팔이 좋아하는 시장 정보를 전체 출력
		dK.lovePlace.printInfo();
		System.out.println("-------------------");
		// 곽두팔이 좋아하는 시장은 어디에? 출력
		System.out.println(dK.lovePlace.location);
		System.out.println("-------------------");
		// 곽두팔이 좋아하는 시장에서 산 접시 전체 정보 출력
		dK.lovePlace.useFor.printInfo();
		System.out.println("-------------------");
		// 곽두팔이 좋아하는 시장에서 산 접시에 담긴 메뉴 전체 정보 출력
		dK.lovePlace.useFor.useFor.printInfo();
		System.out.println("-------------------");
		// 곽두팔이 좋아하는 시장에서 산 접시에 담긴 메뉴의 가격 출력
		System.out.println(dK.lovePlace.useFor.useFor.price);
		System.out.println("-------------------");
		// 곽두팔이 좋아하는 시장에서 산 접시에 담긴 메뉴를 판 식당 연락처 출력
		System.out.println(dK.lovePlace.useFor.useFor.restaurant.phoneNumber);
		System.out.println("-------------------");
		// 곽두팔이 좋아하는 시장에서 산 접시에 담긴 메뉴를 판 식당 주인 연락처 출력
		System.out.println(dK.lovePlace.useFor.useFor.restaurant.owner.phoneNumber);
		System.out.println("-------------------");
		// 계란말이를 파는 사람 연락처
		System.out.println(eR.restaurant.owner.phoneNumber);
		
	}
}
