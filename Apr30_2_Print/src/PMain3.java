
public class PMain3 {
	public static void main(String[] args) {
		// print
		System.out.print("1weoi");
		System.out.print("2weoi");
		System.out.println();
		System.out.println("---------");
		// System.out.println();
		// ln과 \n이 유사함

		// printf (Formatting - 형식 지정)
		// System.out.printf("%??", 값); 의 형태

		// 정수 (decimal)
		// %d : 정수데이터가 들어올 자리(decimal, 10진수)
		// %xd : 빈칸을 띄어쓰기로 채워서 숫자를 나타냄
		// %0xd : 빈자리를 0으로 채워서 x자리의 숫자로 만들어줌
		System.out.printf("%d\n", 1);
		System.out.printf("%3d\n", 1);
		System.out.printf("%010d\n", 1);
		System.out.println("---------");

		// 실수 (float)
		// %f : 실수데이터가 들어올 자리
		// %.xf : 소수점 이하의 자릿수
		// 잘리는 부분은 반올림처리
		// 빈자리는 0으로 채워줌
		System.out.printf("%f\n", 123.456789);
		System.out.printf("%.3f\n", 123.456789);
		System.out.printf("%.10f\n", 123.456789);
		System.out.println("---------");

		// 문자열 (String)
		// %s : 글자데이터가 들어올 자리
		// 숫자 : 그냥 입력하면 됨
		// 문자 : 그냥 입력하게 되면 Java의 문법으로 해석하기에
		// => 오류가 발생
		// => System.out.printf("%s", "내용"); 의 형태
		System.out.printf("%s\n", "헉? 내일 휴일이라고요?");
		System.out.println("---------");

		// 오늘 날짜 기준으로 연도 => xxxx년
		System.out.printf("%d년\n", 2024);
		// 월 => xx월
		System.out.printf("%02d월\n", 4);
		// 일 => xx일
		System.out.printf("%d일\n", 30);
		// 연-월-일의 형태로 붙여서 ex) 날짜 : xxxx-xx-xx
		System.out.printf("날짜\t: %4d-%02d-%2d\n", 2024, 4, 30);
		// 날씨 : 더움
		System.out.printf("날씨\t: %s\n", "더움");
		// 기온 : 23도
		System.out.printf("기온\t: %d℃\n", 23);
		// 습도 : 20.21%
		// %% : %를 글자로 표현하고 싶을 때 (printf에서만!)
		System.out.printf("습도\t: %.2f%%\n", 20.21);
	}
}
