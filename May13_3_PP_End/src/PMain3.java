import java.util.Arrays;
import java.util.Scanner;

// Bubble Sort : 인접한 두 항목의 값을 비교해서
//				기준에 만족하면 서로의 값을 교환하는 정렬 방법

public class PMain3 {
	
	// 숫자를 입력받아서 배열에 담을것 (숫자는 5개, 중복 X) 
	// 정렬 전의 값을 출력
	// 정렬
	// 정렬 후의 값을 출력
	
	@SuppressWarnings("resource")
	public static int[] getNumArray() {
		Scanner k = new Scanner(System.in);
		int[] numArray = new int[5];
		for (int i = 0; i < numArray.length; i++) {
			System.out.printf("%d번째 숫자 입력 : ", i + 1);
			numArray[i] = k.nextInt();
		}
		return numArray;
	}
	
	public static void printBeforeSort(int[] nA) {
		System.out.println("------------------");
		System.out.println("<< 입력한 값 >>");
		for (int i = 0; i < nA.length; i++) {
			System.out.print(nA[i] + " ");
		}
		System.out.println();
		System.out.println("------------------");
		System.out.printf("배열의 개수 : %d\n", nA.length);
		System.out.println("------------------");
	}
	
	public static int[] sortArray(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i]>a[i+1]) {
				int p = a[i]-a[i+1];
				a[i] -= p;
				a[i+1] += p;
			}
		}
		return a;
	}
	
//	public static void gR(int[] num) {
//		int t = 0;
//		for (int turn = 0; turn < num.length; turn++) {
//			for (int i = 0; i < num.length - 1; i++) {
//				// num.length - 1 :
//				//	if문 안에서 계산을 할 때, 다음 배열값을 비교하기 위해서
//				//	+ 1 을 사용하는데
//				//	length 길이를 그대로 사용하면 에러가 발생함
//				if (num[i] > num[i + 1]) {
//					t = num[i];
//					num[i] = num[i + 1];
//					num[i + 1] = t;
//				}
//				System.out.println(num[i] + " ");
//			}
//			System.out.println(num[4]);
//			System.out.println("정렬된 값 : " + t);
//		}
//		return num;
//	}
	
	public static void printAfterSort(int[] nA, int j) {
		System.out.println(j + 1 + "턴");
		for (int i = 0; i < nA.length; i++) {
			System.out.print(nA[i]+ " ");
		}
		System.out.println();
		System.out.println("정렬 된 값 : "+ nA[4 - j]);
		System.out.println("---");
	}
	
	public static int[] printDuringSort(int[] numArray) {
		int [] sortedArray = new int[5];
		for (int j = 0; j < numArray.length - 1; j++) {
			sortedArray = sortArray(numArray);
			printAfterSort(sortedArray, j);
		} 
		return sortedArray;
	}
	
	public static void printResult(int[] sA) {
		System.out.println("<< 정렬한 값 >>");
		for (int i = 0; i < sA.length; i++) {
			System.out.print(sA[i]+ " ");
		}
	}
	
	public static void start() {
		int[] numArray = getNumArray();
		printBeforeSort(numArray);
		int[] sortedArray = printDuringSort(numArray);
		printResult(sortedArray);
		
		// 사실상 크게 의미가 없음...
		// 성능에서 효과가 없기 때문
		Arrays.sort(numArray);
		for (int i = 0; i < numArray.length; i++) {
			System.out.print(numArray[i] + " ");
		}
		
		// 코테용으로 사용만 ㅋ_ㅋ
		// 선택정렬, 삽입정렬, 퀵정렬, 합병정렬, ...
		
	}
	
	public static void main(String[] args) {
		start();
		
		
	
	}
}
