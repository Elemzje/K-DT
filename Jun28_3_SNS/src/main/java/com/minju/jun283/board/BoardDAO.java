package com.minju.jun283.board;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.minju.db.manager.MinjuDBManager;
import com.minju.jun283.member.Member;

public class BoardDAO {
	private int BOARDCOUNT = 0;
	
	private static final BoardDAO BOARDDAO = new BoardDAO();
	
	private BoardDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static BoardDAO getBoardDAO() {
		return BOARDDAO;
	}
	
	public void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}
	
	public void countBoard() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = MinjuDBManager.connect("minjuPool");
			String sql = "select count(*) from jul01_board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			BOARDCOUNT = rs.getInt("count(*)");
			MinjuDBManager.close(con, pstmt, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void posting(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			req.setCharacterEncoding("UTF-8");
			con = MinjuDBManager.connect("minjuPool");
			String sql = "insert into jul01_board values(jul01_board_seq.nextval, ?, ?, default)";
			pstmt = con.prepareStatement(sql);
			String m_id = ((Member) req.getSession().getAttribute("m")).getM_id();
			String b_content = req.getParameter("content");
			pstmt.setString(1, m_id);
			pstmt.setString(2, b_content);
			if (pstmt.executeUpdate() == 1) {
				BOARDCOUNT++;
			} else {
				req.setAttribute("r", "[게시 실패]");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "[게시 실패]");
		} finally {
			MinjuDBManager.close(con, pstmt, null);
		}
	}
	
	private int getCountMsg(String search) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = MinjuDBManager.connect("minjuPool");
			String sql = "select count(*) from jun28_member, jul01_board where b_content like '%'||?||'%' and b_m_id = m_id";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			MinjuDBManager.close(con, pstmt, rs);
		}
	}
	
	public void searchBoardMsg(HttpServletRequest req) {
		String search = req.getParameter("search");
		req.getSession().setAttribute("search", search);
	}
	
	public void getPage(int pageNum, HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = MinjuDBManager.connect("minjuPool");
			
			int boardCount = BOARDCOUNT;
			String search = (String) req.getSession().getAttribute("search");
			if (search == null) {
				search = "";
			} else {
				boardCount = getCountMsg(search);
				if (boardCount == 0) {
					req.setAttribute("no", "검색 결과가 없습니다.");
				}
			}
			req.setAttribute("boardCount", boardCount);
			int postPerPage = 3;
			int pageCount = (int) Math.ceil(boardCount / (double) postPerPage);
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("pageNum", pageNum);
			
			int start = (postPerPage * (pageNum - 1)) + 1;
			int end = (pageNum == pageCount) ? boardCount : (start + postPerPage - 1);
			
			String sql = "select * from (select rownum rn, b_no, b_content, b_m_id, b_time, m_img from("
					+ "select * from jun28_member, jul01_board where b_m_id = m_id and b_content like '%'||?||'%' order by b_time desc))"
					+ "where rn between ? and ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			ArrayList<Board> boards = new ArrayList<Board>();
			Board board = null;
			
			while (rs.next()) {
				board = new Board(rs.getInt("b_no"), rs.getString("b_m_id"), rs.getString("b_content"), rs.getDate("b_time"), URLDecoder.decode(rs.getString("m_img"), "UTF-8"));
				boards.add(board);
			}
			req.setAttribute("boards", boards);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MinjuDBManager.close(con, pstmt, rs);
	}
	
	public void write(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = MinjuDBManager.connect("minjuPool");
			String b_m_id = ((Member) req.getSession().getAttribute("m")).getM_id();
			String b_content = req.getParameter("content").replace("\r\n", "<br>");
			
			String formerToken = (String) req.getSession().getAttribute("formerToken");
			
			String token = req.getParameter("token");
			
			if (formerToken == null || !token.equals(formerToken)) {
				String sql = "insert into jul01_board values(jul01_board_seq.nextval, ?, ?, default)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, b_m_id);
				pstmt.setString(2, b_content);
				
				if (pstmt.executeUpdate() == 1) {
					req.setAttribute("r", "작성 성공");
					req.getSession().setAttribute("formerToken", token);
					BOARDCOUNT++;
				}
			} else {
				req.setAttribute("r", "새로고침");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "글 쓰기 실패");
		}
		MinjuDBManager.close(con, pstmt, null);
	}
	
	public void Update(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = MinjuDBManager.connect("minjuPool");
			int b_no = Integer.parseInt(req.getParameter("b"));
			String sql = "update jul01_board set b_content = ?, b_time = sysdate where b_no = ?";
			pstmt = con.prepareStatement(sql);
			String b_content = URLDecoder.decode(req.getParameter("content"), "UTF-8");
			pstmt.setString(1, b_content);
			pstmt.setInt(2, b_no);
			if (pstmt.executeUpdate() == 1) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
