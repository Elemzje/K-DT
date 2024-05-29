import java.util.Scanner;

public class YMain2 {
	public static void main(String[] args) {
		// 국어, 수학, 영어 점수를 각각 입력받아서 출력
		// + 총점과 평균점수까지 출력
		
		Scanner k = new Scanner(System.in);
		
		System.out.print("국어 점수 : ");
		int korean = k.nextInt();
		
		System.out.print("수학 점수 : ");
		int math = k.nextInt();
		
		System.out.print("영어 점수 : ");
		int english = k.nextInt();
		
		System.out.println("________________________\n");
		System.out.printf("국어 점수 : %d점\n", korean);
		System.out.printf("수학 점수 : %d점\n", math);
		System.out.printf("영어 점수 : %d점\n", english);
		System.out.printf("총점 : %d점\n", korean + math + english);
		System.out.printf("평균 점수 : %.2f점\n", (double) (korean + math + english) / 3);
		
		// int / int = int 결과는 정수로만 나온다!
		// 결과값을 실수로 나오게 하기 위해서 (double)을 붙인다
		
		
		
		
		k.close();
	}
}
