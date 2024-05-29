package com.minju.may281.main;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.minju.http.client.MinjuHttpClient;

// Rest API : a36c75323e66b79cf7cfc8e39c9a5352
// 37.5661367 / 126.9808065 (y / x)
public class LocSearchMain {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// 기준점 주변 반경 5km이내에 검색한 키워드 (입력) 가 포함된 가게들을
		// 거리 기준으로 정렬
		
		// 총 검색 결과 수
		// 현재페이지 결과 수
		
		// 주소
		// 전화번호
		// 상호명
		// 기준점과의 거리
		// 를 출력
		
		try {
			Scanner k = new Scanner(System.in);
			System.out.print("키워드 : ");
			String s = k.next();
			s = URLEncoder.encode(s);
			
			String address = "https://dapi.kakao.com/v2/local/search/keyword.json"
					+ "?y=37.5661367&x=126.9808065&query=" + s + "&radius=5000&sort=distance";
			HashMap<String, String> headers = new HashMap<String, String>();
			headers.put("Authorization", "KakaoAK a36c75323e66b79cf7cfc8e39c9a5352");
			InputStream is = MinjuHttpClient.download(address, headers);
			String str = MinjuHttpClient.convert(is, "UTF-8");
			
			JSONParser jp = new JSONParser();
			
			JSONObject jo = (JSONObject) jp.parse(str);
			
			JSONObject meta = (JSONObject) jo.get("meta");
			System.out.println(meta.get("total_count"));
			System.out.println(meta.get("pageable_count"));
			
			JSONArray documents = (JSONArray) jo.get("documents");
			JSONObject data = null;
			System.out.println("=================================");
			for (int i = 0; i < documents.size(); i++) {
				data = (JSONObject) documents.get(i);
				System.out.println(data.get("address_name"));
				System.out.println(data.get("phone"));
				System.out.println(data.get("place_name"));
				System.out.println(data.get("distance") + "m");
				System.out.println("=================================");
			}
			k.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
