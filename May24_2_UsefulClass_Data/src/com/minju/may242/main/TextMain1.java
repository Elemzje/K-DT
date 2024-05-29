package com.minju.may242.main;

import java.util.StringTokenizer;

public class TextMain1 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String s1 = "으아ㅏㅏㅏㅏ"; // 정식? NO / 약식 Yes !
		
		String s2 = new String("곧 있으면 점심 ! 너무 신나요 !");
		
		// 외우지말고 찾아보기 !! (자동완성에 있는 기능 읽어보면서 !)
		
		// s2에서 2번째에 있는 글자 출력
		// charAt() : 특정 위치에 있는 글자를 뽑아낼 때
		System.out.println(s2.charAt(2));
		
		// s2는 총 몇 글자인지 출력
		// length() : 총 글자수를 알고 싶을 때
		System.out.println(s2.length());
		
		// s2가 '곧'이라는 단어로 시작하는지
		// startsWith() : 시작하는 단어가 맞는지 확인할 때 (true / false)
		System.out.println(s2.startsWith("곧"));
		
		// s2에 '너무'라는 단어가 있는지
		// contains() : 찾는 글자가 있는지 (true / false)
		System.out.println(s2.contains("너무"));
		
		// s2에서 '점심'을 '회식'으로 바꿔서 출력
		// replace() : 특정한 글자를 다른 글자로 바꿀 때
		System.out.println(s2.replace("점심", "회식"));
		
		// s2에서 2 ~ 5번째 글자만 출력
		// substring() : 원하는 위치의 글자를 뽑을 때 (시작 위치, 끝 위치 - 1)
		System.out.println(s2.substring(2, 6));
		System.out.println("=================");
		
		// String 객체를 생성하는데 형식을 잡아서 
		String s3 = String.format("무게 : %.2fkg", 123.456789);
		System.out.println(s3);
		System.out.println("=================");
		
		// s2에 글자를 추가
		s2 = s2 + " 올해에는 모두 다 잘 됐으면 좋겠어요 !";
		System.out.println(s2);
		s2 += " 모두 부자되세요 ~ ^-^";
		System.out.println(s2);
		
		s2 = new String(s2 + " ㅎㅎㅎㅎㅎ");
		System.out.println(s2);
		
		// String 대량으로 추가
		StringBuffer sb = new StringBuffer(s2);
		sb.append(" 일은 적게 하되 돈은 많이 벌게 해주세요 !");
		sb.append(" ㅋㅋㅋㅋㅋ");
		sb.append(" 근데 일이 너무 많아요");
//		System.out.println(sb.getClass());
		
		String s4 = sb.toString();
		System.out.println(s4);
		System.out.println("=================");
		
		// String 분리
		String s5 = "김비버,박비버,최비버,저스틴비버";
		
		// 1. Split
		String[] s5Ar = s5.split(","); // 골라서 사용할 수 있음
		System.out.println(s5Ar[0]);
		System.out.println(s5Ar[3]);
		System.out.println("=================");

		// 2. StringTokenizer
		StringTokenizer st = new StringTokenizer(s5, ","); // 순서대로 나옴
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
		while (st.hasMoreElements()) {		// 반복문(while) + 순서대로 나옴
			System.out.println(st.nextToken());
		}
		
		// 속도적인 면 : StringTokenizer
		// data속에서 변수가 많다면 : split
		
	}
}
