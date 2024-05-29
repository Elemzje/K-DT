import java.util.Scanner;

// main함수에서 진행
// 1을 입력하면 학생 수 값을 입력 받을 수 있게
// 2를 입력하면 각 학생들의 점수를 입력 받을 수 있게 (점수 범위 고려 X)
// 3을 입력하면 학생들의 점수 리스트를 출력할 수 있게 (ex : 1번 학생 점수 :  50점)
// 4를 입력하면 최고점수와 평균점수를 분석해서 출력할 수 있게
// 5를 입력하면 프로그램 종료


public class PMain6 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("---------------------------");
		System.out.println("1 : 학생 수 값 입력");
		System.out.println("2 : 각 학생들의 점수 입력");
		System.out.println("3 : 학생들의 점수 리스트 출력");
		System.out.println("4 : 최고점과 평균 출력");
		System.out.println("5 : 프로그램 종료");
		System.out.println("---------------------------");
		int num = 0;
		int students = 0;
		int[] score = null;
		a : while (true) {
			System.out.print("번호 : ");
			num = k.nextInt();
			switch (num) {
			case 1:
				System.out.print("학생 수 : ");
				students = k.nextInt();
				score = new int [students];
				break;
			case 2:
				for (int i = 0; i < score.length; i++) {
					System.out.printf("%d번 학생 점수 : ", i + 1);
					score[i] = k.nextInt();
				}
				break;
			case 3:
				int index = 1;
				for (int i : score) {
					System.out.printf("%d번 학생 점수는 %d점\n", index++, i);
				}
				break;
			case 4:
				int max = 0;
				int sum = 0;
				double avg = 0;
				for (int i : score) {
					sum += i;
					max = (max < i) ? i : max;
				}
				avg = (double) sum / score.length;
				System.out.printf("최고점은 %d점, 평균은 %.2f점\n", max, avg);
				break;
			case 5:
				System.out.println("프로그램을 종료합니다");
				break a;
			default:
				System.out.println("번호를 다시 입력해주세요");
				break;
			}
		}
		k.close();
	}
}
