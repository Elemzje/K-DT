package com.minju.jun212.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class RSPGameEngine {
	private int win = 0;
	private int draw = 0;
	private int lose = 0;
	private int t = 0;
	
	// private : class 내부에서만 사용 가능 / 외부로는 사용이 불가능
	private static final RSPGameEngine RGE = new RSPGameEngine();
	
	private RSPGameEngine() {
		// TODO Auto-generated constructor stub
	}
	
	// Controller에서 사용하기 위한 getter (public)
	public static RSPGameEngine getRge() {
		return RGE;
	}


	public void rspMatch(HttpServletRequest request) {
		int rsp = Integer.parseInt(request.getParameter("rsp"));
		int comrsp = new Random().nextInt(3) + 1;
		String result = null;
		if (comrsp == rsp) {
			result = "무";
			draw++;
		} else if (rsp - comrsp == 2 || rsp - comrsp == -1) {
			result = "승";
			win++;
		} else {
			result = "패";
			lose++;
		}
		t++;
		
		request.setAttribute("rsp", rsp);
		request.setAttribute("comrsp", comrsp);
		request.setAttribute("result", result);
		request.setAttribute("win", win);
		request.setAttribute("draw", draw);
		request.setAttribute("lose", lose);
		request.setAttribute("t", t);
	}
	
	public void reset(HttpServletRequest request) {
		t = 0;
		win = 0;
		draw = 0;
		lose = 0;
		request.setAttribute("result", "전적 초기화 완료 !");
		
	}
}
