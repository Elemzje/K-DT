package com.minju.jun283.member;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minju.db.manager.MinjuDBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberDAO {
	private static final MemberDAO MEMBERDAO = new MemberDAO();
	
	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static MemberDAO getMemberDAO() {
		return MEMBERDAO;
	}
	
	public boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("m");
		if (m != null) {
			req.setAttribute("loginPage", "member/loginInfo.jsp");
			return true;
		}
		req.setAttribute("loginPage", "member/login.jsp");
		return false;
	}
	
	public void register(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			req.setCharacterEncoding("UTF-8");
			String path = req.getServletContext().getRealPath("img");
			System.out.println(path);
			MultipartRequest mr = new MultipartRequest(req, path, 100 * 1024 * 1024, 
					"UTF-8", new DefaultFileRenamePolicy());
			
			String m_id = mr.getParameter("id");
			String m_pw = mr.getParameter("pw");
			String m_name = mr.getParameter("name");
			String m_phone_no = mr.getParameter("phoneNum");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date m_birthday = sdf.parse(mr.getParameter("birthday"));
			String m_img = mr.getFilesystemName("image");
			m_img = URLEncoder.encode(m_img, "UTF-8");
			m_img = m_img.replace("+", " ");
			
			con = MinjuDBManager.connect("minjuPool");
			String sql = "insert into jun28_member values(?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_pw);
			pstmt.setString(3, m_name);
			pstmt.setString(4, m_phone_no);
			pstmt.setDate(5, new java.sql.Date(m_birthday.getTime()));
			pstmt.setString(6, m_img);
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "[가입 성공]");
			} else {
				req.setAttribute("r", "[가입 실패]");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "[가입 실패]");
		} finally {
			MinjuDBManager.close(con, pstmt, null);
		}
	}
	
	public void login(HttpServletRequest req, HttpServletResponse res) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			req.setCharacterEncoding("UTF-8");
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			con = MinjuDBManager.connect("minjuPool");
			String sql = "select * from jun28_member where m_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			String m_id = rs.getString("m_id");
			String m_pw = rs.getString("m_pw");
			String m_name = rs.getString("m_name");
			String m_phone_no = rs.getString("m_phone_no");
			Date m_birthday = rs.getDate("m_birthday");
			String m_img = rs.getString("m_img");
			
			if (pw.equals(m_pw)) {
				Member m = new Member(m_id, m_pw, m_name, m_phone_no, m_birthday, m_img);
				req.getSession().setAttribute("m", m);
				req.getSession().setMaxInactiveInterval(60 * 60 * 24 * 5);
			}
			
			Cookie c = new Cookie("lastLoginId", id);
			c.setMaxAge(1800);
			res.addCookie(c);
			
		} catch (Exception e) {
		}
		MinjuDBManager.close(con, pstmt, rs);
	}
	
	public void update(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			req.setCharacterEncoding("UTF-8");
			String path = req.getServletContext().getRealPath("img");
			MultipartRequest mr = new MultipartRequest(req, path, 100*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			
			con = MinjuDBManager.connect("minjuPool");
			String sql = "update jun28_member set m_pw = ?, m_name = ?, m_phone_no = ?, m_birthday = ?, m_img = ? where m_id = ?";
			String m_pw = mr.getParameter("pw");
			String m_name = mr.getParameter("name");
			String m_phone_no = mr.getParameter("phoneNum");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date m_birthday = sdf.parse(mr.getParameter("birthday"));
			String m_img = mr.getFilesystemName("img");
			if (m_img == null) {
				Member m = (Member) req.getSession().getAttribute("m");
				m_img = m.getM_img();
			}
			m_img = URLEncoder.encode(m_img, "UTF-8");
			m_img = m_img.replace("+", " ");
			String m_id = mr.getParameter("id");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_pw);
			pstmt.setString(2, m_name);
			pstmt.setString(3, m_phone_no);
			pstmt.setDate(4, new java.sql.Date(m_birthday.getTime()));
			pstmt.setString(5, m_img);
			pstmt.setString(6, m_id);
			
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "[수정 성공]");
			} else {
				req.setAttribute("r", "[수정 실패]");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "[수정 실패]");
		} finally {
			MinjuDBManager.close(con, pstmt, null);
		}
	}
	
	public void getInfo(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			req.setCharacterEncoding("UTF-8");
			con = MinjuDBManager.connect("minjuPool");
			String sql = "select * from jun28_member where m_id = ?";
			pstmt = con.prepareStatement(sql);
			Member m = (Member) req.getSession().getAttribute("m");
			String m_id = m.getM_id();
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m.setM_pw(rs.getString("m_pw"));
				m.setM_name(rs.getString("m_name"));
				m.setM_phone_no(rs.getString("m_phone_no"));
				m.setM_birthday(rs.getDate("m_birthday"));
				m.setM_img(rs.getString("m_img"));
			}
			req.getSession().setAttribute("m", m);
			MinjuDBManager.close(con, pstmt, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = MinjuDBManager.connect("minjuPool");
			String sql = "delete from jun28_member where m_id = ?";
			String m_id = ((Member) req.getSession().getAttribute("m")).getM_id();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "[삭제 성공]");
			} else {
				req.setAttribute("r", "[삭제 실패]");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "[삭제 실패]");
		}finally {
			MinjuDBManager.close(con, pstmt, null);
		}
	}
	
	
	
	
	
	
	
	
}
