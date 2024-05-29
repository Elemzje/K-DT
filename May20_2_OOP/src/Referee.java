
public class Referee {
	public User callMe() {
		return new User();
	}
	
	public void callUser(Friend f, User u) {
		System.out.println("전국 업다운 선수권 대회에 오신 여러분 환영합니다");
		System.out.printf("먼저 홍코너 %s선수입니다\n", f.name);
		System.out.printf("다음은 청코너 %s선수입니다\n", u.name);
	}
	
	public int getFriendAnswer(Friend f) {
		System.out.printf("%s선수 답을 적어서 제출하세요\n", f.name);
		int answer = f.writeAnswer();
		System.out.println("------------------");
		return answer;
	}
	
	public int sayAnswer(User u) {
		System.out.println("정답을 말해주세요 !");
		System.out.print("정답 : ");
		return u.answerNum();
	}
	
	public int getTimes(User u, int answer) {
		int time = 0;
		System.out.printf("%s선수의 대답 시간입니다\n", u.name);
		while (true) {
			time++;
			int userAnswer = sayAnswer(u);
			if (answer == userAnswer) {
				break;
			} else if (userAnswer < answer) {
				System.out.println("UP!");
			} else {
				System.out.println("DOWN!");
			}
			System.out.println("------------------");
		}
		return time;
	}
	
	public void judgeResult(User u, int time) {
		System.out.printf("%s선수가 %d회만에 정답을 맞췄습니다!", u.name, time);
	}
	
	public void start(Friend f) {
		User u = callMe();
		callUser(f, u);
		int answer = getFriendAnswer(f);
		int time = getTimes(u, answer);
		judgeResult(u, time);
	}
	
	
}
