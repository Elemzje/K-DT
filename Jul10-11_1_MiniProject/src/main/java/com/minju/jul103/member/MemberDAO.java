package com.minju.jul103.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void login(Member m, HttpServletRequest req, HttpServletResponse res) {
		try {
			req.setCharacterEncoding("UTF-8");
			Member loginMember = ss.getMapper(MemberMapper.class).pwCheck(m);
			if (m.getM_pw().equals(loginMember.getM_pw())) {
				Cookie ck = new Cookie("lastLoginId", m.getM_id());
				ck.setMaxAge(60 * 60 * 24);
				res.addCookie(ck);
				req.getSession().setAttribute("loginMember", loginMember);
				req.getSession().setMaxInactiveInterval(60 * 60 * 24 * 3);
				req.setAttribute("r", "로그인 성공!");
			} else {
				req.setAttribute("r", "로그인 실패! (비밀번호 틀림)");
			}
		} catch (Exception e) {
			req.setAttribute("r", "로그인 실패! (존재하지 않는 ID)");
			e.printStackTrace();
		}
		
	}
	
	public boolean loginCheck(HttpServletRequest req) {
		if (req.getSession().getAttribute("loginMember") != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}
	
	public void signin(Member m, HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
			int i = ss.getMapper(MemberMapper.class).doSignin(m);
			if (i == 1) {
				req.setAttribute("r", "회원가입 성공");
			} else {
				req.setAttribute("r", "회원가입 실패");
			}
		} catch (Exception e) {
			req.setAttribute("r", "회원가입 실패");
			e.printStackTrace();
		}
	}
	
	public void update(Member m, HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
			int i = ss.getMapper(MemberMapper.class).updateInfo(m);
			if (i == 1) {
				req.setAttribute("r", "정보 수정 성공");
			} else {
				req.setAttribute("r", "정보 수정 실패");
			}
		} catch (Exception e) {
			req.setAttribute("r", "정보 수정 실패");
			e.printStackTrace();
		}
	}
	
	public void delete(Member m, HttpServletRequest req) {
		try {
			if (ss.getMapper(MemberMapper.class).deleteAccount(m) == 1) {
				req.setAttribute("r", "계정 삭제 성공");
			} else {
				req.setAttribute("r", "계정 삭제 실패");
			}
		} catch (Exception e) {
			req.setAttribute("r", "계정 삭제 실패");
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
