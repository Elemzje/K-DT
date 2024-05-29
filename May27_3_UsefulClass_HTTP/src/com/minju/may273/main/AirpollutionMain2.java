package com.minju.may273.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.minju.http.client.MinjuHttpClient;

// 미세먼지 => 파싱 => 값들을 => txt파일에 담기
// (프로그램 실행시) 날짜, 측정구, 미세먼지, 초미세먼지, 오존, 통합대기환경지수
// 날짜형식 : 연-월-일-오전/오후-시-요일
// 단위 X

public class AirpollutionMain2 {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\sdedu\\Desktop\\Test/Airpollution.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-a-hh-E");
			String d1 = sdf.format(now);
			
			String address = "http://openapi.seoul.go.kr:8088"
					+ "/4f626857416f6c6c3632586a416843"
					+ "/xml"
					+ "/RealtimeCityAir"
					+ "/1"
					+ "/25"
					+ "/";
			
			InputStream is = MinjuHttpClient.download(address);
			
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "UTF-8");
			
			int type = xpp.getEventType();
			String tagName = null;
			
			StringBuffer sb = new StringBuffer();
			
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
				} else if (type == XmlPullParser.TEXT) {
					if (tagName.equals("MSRSTE_NM")) {
						sb.append(d1 + ",");
						sb.append(xpp.getText() + ",");
					} else if (tagName.equals("PM10")) {
						sb.append(xpp.getText() + ",");
					} else if (tagName.equals("PM25")) {
						sb.append(xpp.getText() + ",");
					} else if (tagName.equals("O3")) {
						sb.append(xpp.getText() + ",");
						if (xpp.getText().equals("0")) {
							sb.append("0\r\n");
						}
					} else if (tagName.equals("IDEX_MVL")) {
						sb.append(xpp.getText() + "\r\n");
					}
				} else if (type == XmlPullParser.END_TAG) {
					tagName = "";
				}
				xpp.next();
				type = xpp.getEventType();
			}
			bw.append(sb.toString());
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
























