package com.minju.may242.main;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TextMain2 {
	// 뭔가 입력 받을건데
	// a/b/c/d/e/f/g/...
	// ex) 1/2/a/3 => 총합 : 6 / 평균 : 2
	// 숫자라면.. 총합을 구하고 / 평균을 구하고 => 출력
	// 글자라면.. 넘기게
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("입력 : ");
		String s = k.next();
		StringTokenizer st = new StringTokenizer(s, "/");
		int sum = 0;
		int count = 0;
		while (st.hasMoreElements()) {
			try {
				sum += Integer.parseInt(st.nextToken());
				count++;
			} catch (Exception e) {
				continue;
			}
		}
		System.out.println(sum);
		System.out.println((double) sum / count);
		k.close();
	}
	
}
