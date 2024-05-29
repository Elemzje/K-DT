package com.minju.may242.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExampleMain1 {
	// 학생의 (이름/생년월일(yyyy.MM.dd)/국어/수학/영어)를 입력받아서
	// 학생의 나이, 총점, 평균점수 값을 출력
	// split => StringTokenizer
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("정보를 아래와 같이 입력해주세요");
		System.out.println("========================================");
		System.out.println("이름/생년월일(yyyy.MM.dd)/국어/수학/영어");
		System.out.println("========================================");
		System.out.print("정보 : ");
		String info = k.next();
		System.out.println(info);
		String[] infoAr = info.split("/");
		String name = infoAr[0];
		System.out.printf("이름 : %s\n", name);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date birthday = null;
		try {
			birthday = sdf.parse(infoAr[1]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date now = new Date();
//		int age = now.getYear() - birthday.getYear() + 1; // 옛날나이 계산
		int age = now.getYear() - birthday.getYear();
		if (now.getMonth() < birthday.getMonth()) {
			age--;
		} else if (now.getMonth() == birthday.getMonth() && now.getDate() < birthday.getDate()) {
			age--;
		} // 만나이 계산
		
		
		System.out.println("나이 : " + age);
		int score = 0;
		int sum = 0;
		int count = 0;
		for (int i = 2; i < infoAr.length; i++) {
			score = Integer.parseInt(infoAr[i]);
			sum += score;
			count++;
		}
		System.out.println("총점 : "+ sum);
		System.out.printf("평균 : %.2f\n", (double) sum / count);
		k.close();
	}
}
