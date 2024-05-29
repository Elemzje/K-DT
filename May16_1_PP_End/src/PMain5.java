import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
@SuppressWarnings("resource")
public class PMain5 {
	// 로또 (함수 사용 O)
	// 컴퓨터가 1 ~ 45 사이의 정수 중 6개 숫자를 뽑음
	// 유저가 숫자 6개를 입력
	// 6개 일치 : 1등 / 5개 일치 : 2등 / 4개 일치 : 3등 / 그 외 : 꽝
	//		=> 출력
	
//	public static int[] getLotto() {
//		Random r = new Random();
//		int[] lotto = new int[6];
//		for (int i = 0; i < lotto.length; i++) {
//			lotto[i] = r.nextInt(45) + 1;
			// 앞의 배열요소와 뒤의 배열요소의 값을 구분하기 위해서 반복문 추가
//			for (int j = 0; j < i; j++) { // 인덱스값이 하나 덜 나오게 해야 비교 가능
	
				// i번째에서 뽑은거랑 이전꺼에서 뽑은 값을 비교해서
//				if (lotto[j] == lotto[i]) {
//					i--; // 중복된 값이 있으면 제거하고 첫번째 for문으로 가서 다시 뽑는다
//				}
//			}
//		}
//		return lotto;	
//	}

	public static int[] getLotto() {
		Random r = new Random();
		int[] lotto = new int[6];
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = r.nextInt(45) + 1;
		} 
		Arrays.sort(lotto);
		for (int i = 1; i < lotto.length; i++) {
			System.out.println(lotto[i-1]);
			System.out.println(lotto[i]);
			if (lotto[i-1] == lotto[i]) {
				lotto[i] = r.nextInt(45 - lotto[i]) + 1 + lotto[i];
			} 
		}
		return lotto;
	}
	
	public static int[] getNum() {
		Scanner k = new Scanner(System.in);
		int[] numArray = new int[6];
		for (int i = 0; i < numArray.length; i++) {
			System.out.printf("%d번째 로또번호 : ", i + 1);
			numArray[i] = k.nextInt();
			if (numArray[i] > 45 || numArray[i] < 1) {
				i--;
				System.out.println("범위 밖의 숫자입니다 다시 입력해주세요");
			}
		}
		System.out.println("============================");
		return numArray;
	}
	
	public static void printNum(int[] numArray) {
		Arrays.sort(numArray);
		System.out.println("입력한 숫자");
		for (int i = 0; i < numArray.length - 1; i++) {
			System.out.print(numArray[i]+", ");
		}
		System.out.println(numArray[5]);
		System.out.println("============================");
	}
	
	public static int getResult(int[] lotto, int[] num) {
		int count = 0;
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < lotto.length; j++) {
				if (num[i] == lotto[j]) {
					count++;
					break;
				}
			}
		}
		return count;
	}
	
	public static void printLotto(int[] lotto) {
		Arrays.sort(lotto);
		System.out.println("당첨 번호");
		for (int i : lotto) {
			System.out.print("[" + i + "] ");
		}
		System.out.println();
		System.out.println("============================");
	}
	
	public static void printResult(int count) {
		switch (count) {
		case 6:
			System.out.println("1등");
			break;
		case 5:
			System.out.println("2등");
			break;
		case 4:
			System.out.println("3등");
			break;
		default:
			System.out.println("꽝");
			break;
		}
	}
	
	public static void activate() {
		int[] lotto = getLotto();
		int[] num = getNum();
		printLotto(lotto);
		printNum(num);
		int count = getResult(lotto, num);
		printResult(count);
	}
	
	public static void main(String[] args) {
		activate();
	}
}
