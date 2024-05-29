import java.util.Scanner;

// 평일 스케쥴 출력해주는 프로그램

// 시간을 입력받아서 (24시간단위) => 해당시간에 속하는 내용을 출력
//		=> (입력한 시간이) 시간 범위가 아니면 다시 입력

// 오전 9시 ~ 오후 6시 : 학원에서 공부
// 오전 9시, 오후 2시, 오후 6시 : QR찍기
// 오후 1시 ~ 오후 2시 : 점심시간
// 오후 6시 넘어서 ~ 오후 8시 : 집에 가는 시간
// 오전 6시 ~ 오전 9시 전까지 : 기상 + 씻기 + 학원가기
// 오후 8시 ~ 오전 6시 전까지 : 여가시간 + 취침

// 함수 사용하기

@SuppressWarnings("resource")
public class YMain1 {
	
	// 시간 입력받기
	public static int getTime() {
		Scanner k = new Scanner(System.in);
		System.out.print("시간을 (hhmm)꼴로 적어주세요 : ");
		int time = k.nextInt();
		int t = time / 100;
		int m = time % 100;
		if (t < 0 || t > 23) {
			System.err.printf("%d시는 없습니다, 다시 입력하세요\n", t);
			getTime();
		}
		if (m < 0 || m > 59) {
			System.err.printf("%d분은 없습니다, 다시 입력하세요\n", m);
			getTime();
		}
		return time;
	}
	
	// 내용 출력하기
//	public static void schedule(int t) {
//		if (t >= 6 && t <= 20) {
//			if (t < 9) {
//				System.out.println("기상");
//				System.out.println("씻기");
//				System.out.println("학원가기");
//			} else if (t <= 18) {
//				System.out.println("학원에서 공부");
//				if (t == 9 || t == 14 || t == 18) {
//					System.out.println("QR 찍기");
//				} else if (t >= 13 && t < 14) {
//					System.out.println("점심시간");
//				}
//			} else {
//				System.out.println("집에 가는 시간");
//			}
//		} else {
//			System.out.println("여가시간");
//			System.out.println("취침");
//		}
//	}
	
	// 내용 출력하기 (세분화)
	// 큰 틀
	public static void bigFunc(int t, int m) {
		if (t >= 6 && t < 20 || (t == 20 && m == 0)) {
			midFunc(t, m);
		} else {
			System.out.println("여가시간");
			System.out.println("취침");
		}
	}
	
	// 중간 틀
	public static void midFunc(int t, int m) {
		if (t < 9) {
			System.out.println("기상");
			System.out.println("씻기");
			System.out.println("학원가기");
		} else if (t <= 18) {
			System.out.println("학원에서 공부");
			smallFunc(t, m);
		} else {
			System.out.println("집에 가는 시간");
		}
	}
	
	// 작은 틀
	public static void smallFunc(int t, int m) {
		if (m == 0 && (t == 9 || t == 14 || t == 18)) {
			System.out.println("QR 찍기");
		} else if (t >= 13 && t < 14) {
			System.out.println("점심시간");
		}
	}
	
	// 시간 출력하기
	public static void printTime(int t, int m) {
		System.out.println("=====================");
		System.out.printf("%d시 %d분\n", t, m);
	}
	
	public static void main(String[] args) {
		int time = getTime();
		int hour = time / 100;
		int minute = time % 100;
		printTime(hour, minute);
//		System.out.println(time);
//		schedule(time);
		bigFunc(hour, minute);
		System.out.println("=====================");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
