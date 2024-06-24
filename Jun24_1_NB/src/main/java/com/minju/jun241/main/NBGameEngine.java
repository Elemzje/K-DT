package com.minju.jun241.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class NBGameEngine {
	private int t = 0;
	
	// charAt() : 해당 인덱스에 있는 문자(char)를 반환
	// char 자료형은 ascii (특정 정수값) 코드값으로 사용되기 때문에
	
	private String getNum() {
		Random r = new Random();
		int h = r.nextInt(10);
		String hund = Integer.toString(h);
		int ten = r.nextInt(10);
		while (h == ten) {
			ten = r.nextInt(10);
		}
		int o = r.nextInt(10);
		while (o == h || o == ten) {
			o = r.nextInt(10);
		}
		return hund + ten + "" + o;
	}
	
	private String num = getNum();
	
	private NBGameEngine() {
	}
	
	private final static NBGameEngine NGE = new NBGameEngine();
	
	public static NBGameEngine getNGE() {
		return NGE;
	}
	
	public void judge(HttpServletRequest request) {
		String guess = request.getParameter("guess");
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < 3; i++) {
			if (num.charAt(i) == guess.charAt(i)) {
				strike++;
			} else {
				for (int j = 0; j < 3; j++) {
					if (num.charAt(i) == guess.charAt(j)) {
						ball++;
					}
				}
			}
		}
		t++;
		String result = "실패";
		if (strike == 3) {
			result = "성공";
		}
		request.setAttribute("guess", guess);
		request.setAttribute("r", result);
		request.setAttribute("strike", strike);
		request.setAttribute("ball", ball);
		request.setAttribute("t", t);
		request.setAttribute("con", "<script>alert('ㅊㅋㅊㅋ');</script>");
	}
	
	public void reset(HttpServletRequest request) {
		num = getNum();
		t = 0;
		request.setAttribute("r", "초기화 성공!");
	}
	
}
