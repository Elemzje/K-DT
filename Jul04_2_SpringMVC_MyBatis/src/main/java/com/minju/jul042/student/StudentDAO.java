package com.minju.jul042.student;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// SqlSessionTemplate
//	SqlSession의 하위클래스
//	(public class SqlSessionTemplate implements SqlSession)의 구조
//		=> SqlSession의 기능은 다 들어있고, 뭔가 더 추가됨
//		자동연결 / 자동해제
//		자동 commit

@Service
public class StudentDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void regStudent(Student s, HttpServletRequest req) {
//		System.out.println(s.getS_name());
//		System.out.println(s.getS_nickname());
		
		try {
			// 연결 - 자동(SqlSessionTemplate 때문에) - connect, close 필요 X
			
			// 값을 받아오기 & 객체로 만들기 - Spring이 해결을 자동으로 해줌
			
			// SQL 수행 - MyBatis를 활용...
			//	interface를 가져온다
			StudentMapper sm = ss.getMapper(StudentMapper.class);
			
			// interface에 있는 abstract method(추상 메소드) 호출
			//	-자동-> 연결이 되어있는 mapper.xml의 해당 부분이 실행
			if (sm.regStudent(s) == 1) {
				req.setAttribute("r", "학생 등록 성공");
				// ss.commit(); => commit 자동 !
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "학생 등록 실패");
		}
	}
	
	
	public void getAllStudent(HttpServletRequest req) {
		try {
//			List<Student> students = ss.getMapper(StudentMapper.class).getAllStudent();
//			req.setAttribute("students", students);
			
			req.setAttribute("students", ss.getMapper(StudentMapper.class).getAllStudent());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
