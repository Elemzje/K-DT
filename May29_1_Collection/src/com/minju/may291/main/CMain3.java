package com.minju.may291.main;

import java.util.HashMap;
import java.util.Scanner;

import com.minju.may291.student.Student;

public class CMain3 {
	public static void main(String[] args) {
		// 학생의 이름을 입력했을 때
		// 그 학생의 전체 정보를 출력하고 싶음
		
		HashMap<String, Student> hm = new HashMap<String, Student>();
		hm.put("학생1", new Student("학생1", 90, 60, 80));
		hm.put("학생2", new Student("학생2", 80, 70, 60));
		hm.put("학생3", new Student("학생3", 100, 80, 95));
		hm.put("학생4", new Student("학생4", 30, 40, 30));
		Scanner k = new Scanner(System.in);
		System.out.print("이름> ");
		hm.get(k.next()).printInfo();
		k.close();
	}
}
