package com.minju.jul042.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void regTest(Test t, HttpServletRequest req) {
		// View 파라미터 3개(t_y, t_m, t_d -> t_date 합쳐줄리없죠?)
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			Date t_date = sdf.parse(t.getT_y() + "." + t.getT_m() + "." + t.getT_d());
			t.setT_date(t_date);
			int res = ss.getMapper(TestMapper.class).regTest(t);
			if (res == 1) {
				req.setAttribute("r", "시험 등록 성공");
			} else {
				req.setAttribute("r", "시험 등록 실패");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			req.setAttribute("r", "시험 등록 실패");
		}
	}
	
	public void getAllTest(HttpServletRequest req) {
		try {
			List<Test> tests = ss.getMapper(TestMapper.class).getAllTest();
			req.setAttribute("tests", tests);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
