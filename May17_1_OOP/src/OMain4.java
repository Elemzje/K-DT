// 실행용 Class : 프로그램 실행을 위한 main() method를 제공하는 역할
public class OMain4 {
	// 이름, 사는곳 속성을 가진 학생 객체
	// 속성을 출력하는 기능까지
	
	public static void main(String[] args) {
		Student s1 = new Student();
		
		s1.studentName = "이민주";
		s1.studentAddress = "강서구";
		System.out.println("s1이 Student 객체를 참조");
		System.out.println(s1);
		s1.printInfo();
		System.out.println("------------------");
		// 완전히 독립한 서로 다른 객체
		Student s2 = new Student();
		s2.studentName = "일민주";
		s2.studentAddress = "강동구";
		System.out.println("s2가 Student 객체를 참조");
		System.out.println(s2);
		s2.printInfo();
		
	}
	
}
