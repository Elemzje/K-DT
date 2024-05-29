package com.minju.may291.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.minju.may291.student.Student;

@SuppressWarnings("unused")
public class CMain2 {
	public static void main(String[] args) {
		// 학생 객체 - 이름 / 국어 / 영어 / 수학 + 속성들 출력 기능
		
		// 학생의 번호를 입력하면 => 그 학생의 정보를 출력할건데
		// 이 떄 어떤걸 써야 할까요 ?
		// 학생 4명 생성
		Scanner k = new Scanner(System.in);
		System.out.print("번호> ");
		int num = k.nextInt();
//		Student s1 = new Student("학생1", 90, 60, 80);
//		Student s2 = new Student("학생2", 80, 70, 60);
//		Student s3 = new Student("학생3", 100, 80, 95);
//		Student s4 = new Student("학생4", 30, 40, 30);
//		HashMap<Integer, Student> hm = new HashMap<Integer, Student>();
//		hm.put(1, s1);
//		hm.put(2, s2);
//		hm.put(3, s3);
//		hm.put(4, s4);
//		hm.get(num).printInfo();
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("학생1", 90, 60, 80));
		students.add(new Student("학생2", 80, 70, 60));
		students.add(new Student("학생3", 100, 80, 95));
		students.add(new Student("학생4", 30, 40, 30));
		
		students.get(num - 1).printInfo();
		k.close();
	}
}
