// 지역변수(Local Variable)
//		메소드 속에서 만든 변수
//		그 행동을 하는 동안에만 필요한 임시변수로..
// 메소드 파라미터 (Parameter)
//		그 행동을 하는데 필요한 재료
// 리턴되는 값
//		그 행동을 한 후에 결과물
// 멤버변수 (Member Variable)
//		그 객체의 속성


public class Doctor {
	String name;
	int age;
	
	public void printDoctorInfo() {
		System.out.println(name + " " + age);
	}
	
	public void callGuest(Guest g) {
		System.out.println(name + " : " + g.name + "님 들어오세요");
	}
	
	public double askHeight(Guest g) {
		System.out.print(name + " : " + g.name + " 환자분 키가 어떻게 되나요?");
		double h = g.answerHeight();
		if (h >= 1 && h <= 300) {
			System.out.println("========");
			System.out.println("나보다 좀 작네 ㅋ");
			System.out.println("========");
		} else if (h < 1 || h > 300) {
			System.out.println("========");
			System.out.println("어허 ! 노 장난 !");
			System.out.println("========");
		}
		return (h >= 1 && h <= 300) ? h : askHeight(g);
	}
	
	public double askWeight(Guest g) {
		System.out.print(name + " : " + g.name + " 환자분 몸무게가 어떻게 되나요?");
		double w = g.answerWeight();
		if (w >= 1) {
			System.out.println("========");
			System.out.println("...ㅋ");
			System.out.println("========");
		} else if (w < 1) {
			System.out.println("========");
			System.out.println("진심 사람이세요 ?");
			System.out.println("========");
		}
		return (w >= 1) ? w : askHeight(g);
	}
	
	
	public double calcBMI(Guest g) {
		double bmi = g.weight / ((g.height / 100) * (g.height / 100));
		return bmi;
	}
	
	public String getBMI(Guest g) {
		if (g.bmi >= 40) {
			return "고도비만";
		} else if (g.bmi >= 35) {
			return "중증도비만";
		} else if (g.bmi >= 30) {
			return "경도비만";
		} else if (g.bmi >= 25) {
			return "과체중";
		} else if (g.bmi >= 18.5) {
			return "정상";
		} else {
			return "저체중";
		}
	}
	
	public void tellResult(Guest g) { 
		System.out.printf("%s씨의 키는 %.1fcm이고, 몸무게는 %.1fkg\n", g.name, g.height, g.weight);
		System.out.printf("체질량지수 : %.1f\n", g.bmi);
		System.out.printf("당신은 %s입니다\n", g.bmiResult);
	}
	
	
	public void start() {
		Guest g = new Guest();
		callGuest(g);
		g.sayHello();
		g.height = askHeight(g);
		g.weight = askWeight(g);
		g.bmi = calcBMI(g);
		g.bmiResult = getBMI(g);
		tellResult(g);
	}
	
	
	
	// BMI (체질량지수) : 
	//		몸무게 / (키의 제곱)
	//		18.5 미만 저체중
	//		18.5 이상 정상
	//		25 이상 과체중
	//		30 이상 경도비만
	//		35 이상 중증도비만
	//		40 이상 고도비만
	
	
	
	
	
	
}
