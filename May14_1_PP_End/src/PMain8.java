import java.util.Random;
import java.util.Scanner;

// 주사위 게임 (main함수만 사용 O)
//	유저와 컴퓨터가 각각 주사위를 3개씩 굴려서 그 합이 높은 숫자가
//		나온 쪽이 이기는 게임
//	1번 메뉴
//		유저와 컴퓨터는 각각 주사위 3개씩 굴릴 것
//		유저는 굴린 주사위의값을 확인한 후 (주사위의 합까지)
//		돈을 배팅할 수 있게 해서
//		이기면 그 돈만큼 따고, 지면 잃게 됨
//		소지금보다는 많이 배팅할 수 없고, 기본 소지금은 10000원으로 시작
//		한 판 끝내면 재도전 의사를 물을 것
//		소지금 다 잃으면 메뉴로 돌아가기
//	2번 메뉴
//		전적 확인 (승 / 무 / 패 / 소지금)
//	3번 메뉴
//		대출 기능
//	4번 메뉴
//		상환 기능
//	5번 메뉴
//		프로그램 종료


public class PMain8 {
	

	
	public static void main(String[] args) throws InterruptedException {
		Scanner k = new Scanner(System.in);
		Random r = new Random();
		int menuNo = 0;
		int[] userDice = new int[3];
		int[] comDice = new int[3];
		int[] recentMatchResult = new int[3];
		int userMoney = 10000;
		double loans = 0;
		int repayment = 0;
		int newLoans = 0;
		int userSum = 0;
		int comSum = 0;
		int betMoney = 0;
		String delay = null;
		String rematch = delay;
		a : while (true) {
			System.out.println("┌───────────────────────────────────────┐");
			System.out.println("│\t\tM e n u\t        \t│");
			System.out.println("│\t\t\t\t\t│");
			System.out.println("│\t\t\t\t\t│");
			System.out.println("│\t1.\t\t2.\t\t│");
			System.out.println("│\t\t\t\t\t│");
			System.out.println("│\t주사위 놀이\t전적\t\t│");
			System.out.println("│\t\t\t\t\t│");
			System.out.println("│\t\t\t\t\t│");
			System.out.println("│\t3.\t\t4.\t\t│");
			System.out.println("│\t\t\t\t\t│");
			System.out.println("│\t대출\t\t상환\t\t│");
			System.out.println("│\t\t\t\t\t│");
			System.out.println("│\t\t\t\t\t│");
			System.out.println("│\t5.\t\t\t\t│");
			System.out.println("│\t\t\t\t\t│");
			System.out.println("│\t도박판 탈출\t\t\t│");
			System.out.println("│\t\t\t\t\t│");
			System.out.println("│\t\t\t\t\t│");
			System.out.println("└───────────────────────────────────────┘");
			System.out.print("메뉴 선택 : ");
			menuNo = k.nextInt();
			switch (menuNo) {
			case 1:
				while (true) {
					loans *= 1.005;
					userSum = 0;
					for (int i = 0; i < userDice.length; i++) {
						userDice[i] = r.nextInt(6) + 1;
						System.out.println("-----------------------------------------");
						System.out.print("주사위를 굴리려면 아무 키나 입력하세요 : ");
						delay = k.next();
						System.out.println("데굴데굴..");
						Thread.sleep(500);
						System.out.printf("%d번째 주사위의 눈은 : %d\n", i + 1 , userDice[i]);
						userSum += userDice[i];
					}
					System.out.printf("굴린 주사위의 총 합은 %d입니다!\n", userSum);
					System.out.println("-----------------------------------------");
					System.out.printf("당신은 현재 %d원을 소지 중입니다\n", userMoney);
					System.out.println("베팅액을 입력하세요!");
					System.out.print("베팅액 : ");
					betMoney = k.nextInt();
					if (betMoney > userMoney) {
						System.err.println("소지금보다 더 많은 액수를 베팅할 수 없습니다");
						System.err.println("1초 후 메뉴로 돌아갑니다");
						Thread.sleep(1000);
						break;
					}
					comSum = 0;
					for (int i = 0; i < comDice.length; i++) {
						comDice[i] = r.nextInt(6) + 1;
						System.out.println("-----------------------------------------");
						System.out.println("컴퓨터가 주사위를 굴립니다");
						System.out.println("데굴데굴..");
						Thread.sleep(500);
						System.out.printf("%d번째 주사위의 눈은 : %d\n", i + 1 , comDice[i]);
						comSum += comDice[i];
					}
					System.out.println("-----------------------------------------");
					System.out.printf("컴퓨터가 굴린 주사위의 합은 %d입니다!\n", comSum);
					System.out.println("-----------------------------------------");
					if (userSum > comSum) {
						recentMatchResult[0] += 1;
						System.out.println("승리!");
						System.out.printf("%d원을 획득합니다\n", betMoney);
						userMoney += betMoney;
						System.out.printf("현재 소지금은 %,d원입니다\n", userMoney);
					} else if (userSum < comSum) {
						recentMatchResult[2] += 1;
						System.out.println("패배...");
						System.out.printf("%d원을 잃습니다\n", betMoney);
						userMoney -= betMoney;
						System.out.printf("현재 소지금은 %,d원입니다\n", userMoney);
					} else {
						recentMatchResult[1] += 1;
						System.out.println("무승부");
						System.out.printf("현재 소지금은 %,d원입니다\n", userMoney);
					}
					System.out.println("-----------------------------------------");
					if (userMoney > 0) {
						System.out.print("재도전 하시겠습니까?(y/n) : ");
						rematch = k.next();
						if (rematch.equals("y") || rematch.equals("Y")) {
							continue;
						} else {
							break;
						}
					} else {
						System.out.println("소지금이 없어 메뉴로 돌아갑니다");
						break;
					}
				}
				break;
			case 2:
				System.out.println("당신의 전적은");
				System.out.printf("<%d승 %d무 %d패>\n", recentMatchResult[0], recentMatchResult[1], recentMatchResult[2]);
				System.out.printf("현재 승률 %.2f%%입니다\n", 100 * ((double) recentMatchResult[0] / (recentMatchResult[0] + recentMatchResult[1] + recentMatchResult[2])));
				System.out.printf("소지금 : %,d원\n", userMoney);
				System.out.print("아무 키나 입력하면 메뉴로 돌아갑니다 : ");
				delay = k.next();
				break;
			case 3:
				System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				System.out.println("★\t\t\t\t\t★");
				System.out.println("★\t\t어서오세요\t\t★");
				System.out.println("★\t\t\t\t\t★");
				System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				System.out.println();
				System.out.println("저희 금융은 판당 이율 복리 0.5%입니다");
				System.out.print("빌리시고 싶은 금액을 입력하세요 : ");
				newLoans = k.nextInt();
				loans += newLoans;
				System.out.printf("당신은 현재 %,.0f원의 빚을 지고 있어요!\n", loans);
				userMoney += newLoans;
				System.out.printf("소지금 : %,d원\n", userMoney);
				System.out.print("아무 키나 입력하면 메뉴로 돌아갑니다 : ");
				delay = k.next();
				break;
			case 4:
				System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				System.out.println("★\t\t\t\t\t★");
				System.out.println("★\t\t어서오세요\t\t★");
				System.out.println("★\t\t\t\t\t★");
				System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				System.out.println();
				System.out.printf("당신은 현재 %,.0f원의 빚을 지고 있어요!\n", loans);
				System.out.println("상환하실 금액을 입력해주세요");
				System.out.print("상환금 : ");
				repayment = k.nextInt();
				if (repayment > userMoney) {
					System.out.println("소지금이 부족합니다");
					System.out.println("메뉴로 돌아갑니다");
					break;
				}
				loans -= repayment;
				userMoney -= repayment;
				System.out.printf("소지금 : %,d원\n", userMoney);
				System.out.print("아무 키나 입력하면 메뉴로 돌아갑니다 : ");
				delay = k.next();
				break;
			case 5:
				System.out.println("정말... 떠나실건가요..?");
				System.out.print("프로그램을 종료하려면 아무 키나 입력해주세요");
				delay = k.next();
				break a;
			default:
				System.err.println("잘못된 메뉴 번호입니다");
				System.err.println("1초 후 메뉴로 돌아갑니다");
				Thread.sleep(1000);
				break;
			}
		}
		k.close();
	}
}















