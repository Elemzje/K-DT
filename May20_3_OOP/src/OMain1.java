
// 가위바위보
//	1. 등장인물 누구 ? => 심판 / ??? / ???
//		=> 다 같이 한자리에 있음
//		=> 심판한테는 룰북이 있음
//		1을 입력하면 가위 / 2를 입력하면 바위 / 3을 입력하면 보
//	2. 각 객체들 속성? 행동?
//	3. 한 판 질동안 몇승 / 몇무 했는지


public class OMain1 {
	public static void main(String[] args) {
		Referee r = new Referee();
		User u = new User();
		Computer c = new Computer();
		r.start(c, u);
	}
}
