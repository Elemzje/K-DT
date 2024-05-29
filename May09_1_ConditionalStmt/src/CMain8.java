import java.util.Scanner;

// BMI 검사 프로그램 (함수.ver)

// 이름, 키(cm), 체중(kg) 입력
// BMI(체질량지수) : 몸무게 / (키 * 키) => 키 : m단위
//	18.5 미만이면 저체중
//	18.5 이상이면 정상
//	25 이상이면 과체중
//	30 이상이면 경도비만
//	35 이상이면 중증도비만
//	40 이상이면 고도비만
//	결과를 출력 (각 결과에 따른 코멘트 작성)
//	Y를 입력하면 프로그램이 종료


@SuppressWarnings("resource")
public class CMain8 {

	public static void printStart() {
		System.out.println("BMI지수 측정을 시작하겠습니다");
	}
	
	public static String getName() {
		System.out.print("이름 : ");
		return new Scanner(System.in).next();
	}
	
	public static double getWeight() {
		System.out.print("체중(kg) : ");
		return new Scanner(System.in).nextDouble();
	}
	
	public static double getHeight() {
		System.out.print("키(cm) : ");
		return new Scanner(System.in).nextDouble();
	}
	
	public static double judgeBmi(double h, double w) {
		return w / (h/100 * h/100);
	}
	
	public static String judgeStatus(double bmi) {
		if (bmi < 18.5) {
			return "저체중입니다\n남들보다는 살짝 마른 편이시네요";
		} else if (bmi < 25) {
			return "정상입니다\n자기관리를 꾸준히 하셨군요!";
		} else if (bmi < 30) {
			return "과체중입니다\n정상범위를 살짝 웃도는 수치입니다!";
		} else if (bmi < 35) {
			return "경도비만입니다\n식사 후 가벼운 운동 한 번씩 어떨까요?";
		} else if (bmi < 40) {
			return "중증도비만입니다\n지금이 관리를 시작할 때입니다!";
		} else {
			return "고도비만입니다\n다양한 합병증에 걸릴 우려가 있어요 조심하세요!";
		}
	}
	
	public static void printBmi(String n, double h, double w, double b, String j) {
		System.out.printf("안녕하세요 %s님\n당신의 BMI지수 측정결과가 나왔습니다\n", n);
		System.out.printf("당신은 %.1fcm에 %.1fkg으로\nBMI지수는 %.1f 나오셨고요\n", h, w, b);
		System.out.printf("따라서 당신은 %s\n", j);
	}
	
	public static void stop() {
		System.out.print("Y를 누르면 프로그램을 종료합니다 : ");
		String y = new Scanner(System.in).next();
//		char c = y.charAt(x); *y의 x번째 문자를 char로 뽑아옴
		if (y.equals("y") || y.equals("Y")) {
			System.out.println("2초 뒤 프로그램을 종료합니다");
			try {
				Thread.sleep(2000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Y가 인식되지 않았습니다");
			stop();
		}
	}
	
	public static void start() {
		printStart();
		String name = getName();
		double height = getHeight();
		double weight = getWeight();
		double bmi = judgeBmi(height, weight);
		String status = judgeStatus(bmi);
		printBmi(name, height, weight, bmi, status);
		stop();
	}
	
	public static void main(String[] args) {
		start();
	}
	
	
	
	
}
