import java.util.Scanner;

public class KIMain2 {
	public static void main(String[] args) {
		// 메뉴판 (중식)
		// 짜장면, 짬뽕, 볶음밥, 탕수육, ...
		// 가격을 입력받아서
		// 메뉴판 모양으로 출력
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("메뉴에 따른 가격을 입력해주세요");
		System.out.print("짜장면 : ");
		int jjazang = keyboard.nextInt();
		System.out.print("짬뽕 : ");
		int jjambbong = keyboard.nextInt();
		System.out.print("볶음밥 : ");
		int bokkeumRice = keyboard.nextInt();
		System.out.print("탕수육 : ");
		int tangsu = keyboard.nextInt();
		System.out.print("양장피 : ");
		int yangjangpi = keyboard.nextInt();
		System.out.print("오향장육 : ");
		int fiveSpiceMeat = keyboard.nextInt();
		System.out.println("\n\n\n\n\n\n\n");
		
		System.out.println("┌───────────────────────────────┐");
		System.out.println("│\t\0\0\0메   뉴   판\t\t│");
		System.out.println("│				│");
		System.out.println("│  메뉴\t\t\0\0\0\0가격\t\t│");
		System.out.println("│				│");
		System.out.printf("│  짜장면\t\t%,9d원\t│\n", jjazang);
		System.out.println("│				│");
		System.out.printf("│  짬뽕\t\t%,9d원\t│\n", jjambbong);
		System.out.println("│				│");
		System.out.printf("│  볶음밥\t\t%,9d원\t│\n", bokkeumRice);
		System.out.println("│				│");
		System.out.printf("│  탕수육\t\t%,9d원\t│\n", tangsu);
		System.out.println("│				│");
		System.out.printf("│  양장피\t\t%,9d원\t│\n", yangjangpi);
		System.out.println("│				│");
		System.out.printf("│  오향장육\t%,9d원\t│\n", fiveSpiceMeat);
		System.out.println("│				│");
		System.out.println("│				│");
		System.out.println("│		물은 셀프입니다	│");
		System.out.println("└───────────────────────────────┘");
		
		keyboard.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
