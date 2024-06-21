package com.minju.jun213.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class HJGameEngine {
	private int win = 0;
	private int lose = 0;
	private int t = 0;
	
	private static final HJGameEngine HGE = new HJGameEngine();
	
	private HJGameEngine() {
		// TODO Auto-generated constructor stub
	}

	public static HJGameEngine getHge() {
		return HGE;
	}
	
	public void doHJ(HttpServletRequest request) {
		int comNum = new Random().nextInt(100) + 1;
		String user = request.getParameter("user");
		String com = comNum % 2 == 0 ? "even" : "odd";
		if (com.equals(user)) {
			request.setAttribute("r", "승리");
			win++;
		} else {
			request.setAttribute("r", "패배");
			lose++;
		}
		t++;
		request.setAttribute("com", com);
		request.setAttribute("user", user);
		request.setAttribute("t", t);
		request.setAttribute("w", win);
		request.setAttribute("l", lose);
		request.setAttribute("wr", String.format("%.2f" ,((double) win / t) * 100 ));
	}
	
	public void reset(HttpServletRequest request) {
		win = 0;
		lose = 0;
		t = 0;
		request.setAttribute("r", "전적 리셋 완료 !");
	}
}
