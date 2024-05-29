
public class PMain2 {
	public static void main(String[] args) {
		//Escape Sequence (이스케이프 문자)
		// : 특수한 문자 or 특수한 기능을 표현할 때
		// 		역슬래시 \ 를 사용해서
		
		// \t : Tap키 (줄 맞추는 용도)
		// \n : New Line (줄만 맞추는 용도)
		// \r : Carriage Return (커서를 맨 앞으로)
		// \r\n : Enter키 
		// \b : Backspace키 (1byte만 지움) -> Java에서는 사용 X
		// 		C언어 - 한 글자 : 1byte
		// 		Java - 한 글자 : 2byte
		// \0 : 빈칸 (Space키)
		
		// syso 4개에 각각 문장하나씩 생성
		//  => 중간중간에 이스케이프 문자 넣어서 출력
		
		System.out.println("오늘날짜\t: 2024.04.30");
		System.out.println("요일\t\t: 화요일");
		System.out.println("오늘\n 진짜\r 덥네요\r\n ㅠㅠ");
		System.out.println("쪄 죽\0을것 같\b아요");
		
		// 현재 : 가볍게 확인용도로 사용하는 콘솔창이라서
		//		\r or \n 둘 중 하나만 있어도 enter키 처리가 가능
		// 파일처리 / 통신 : \r이나 \n 하나만 쓰게 되면...
		// 				다 뒤집어질 수도 있음!
		// -> 이클립스 안에서는 \r, \n을 구분하기는 어려움
		// => \n을 엔터처리로 하고, 이후에 파일처리에서 \r, \n을 보자!
		
		// \(^_^)/ 출력하기
		// \\ : \를 글자로!
		System.out.println("\\(^_^)/");
		
		// (".") 출력
		// \" : "를 글자로!
		System.out.println("(\".\")");
		
		
		
		
		
	}
}
