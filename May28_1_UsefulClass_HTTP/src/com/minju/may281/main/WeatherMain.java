package com.minju.may281.main;

import java.io.InputStream;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.minju.http.client.MinjuHttpClient;

public class WeatherMain {
	// https://api.openweathermap.org/data/2.5/weather?q={city name}&appid=42008a8c8e7402a3fc9d3b1a7df8fee9&units=metric&lang=kr
	
	// 도시의 이름을 콘솔에서 입력 (영어로 ex : seoul)
	
	// 나라 이름
	// 도시 이름
	// description
	// 기온
	// 체감온도
	// 최저기온
	// 최고기온
	// 기압
	// 습도
	// 출력
	
	public static void main(String[] args) {
		String address = new String("https://api.openweathermap.org"
				+ "/data"
				+ "/2.5"
				+ "/weather"
				+ "?q={city name}"
				+ "&appid=42008a8c8e7402a3fc9d3b1a7df8fee9"
				+ "&units=metric"
				+ "&lang=kr");
		Scanner k = new Scanner(System.in);
		System.out.print("도시 이름(영어) : ");
		String location = k.next();
		address = address.replace("{city name}", location);
		try {
			InputStream is = MinjuHttpClient.download(address);
			String str = MinjuHttpClient.convert(is, "UTF-8");
			
			JSONParser jp = new JSONParser();
			
			JSONObject jo = (JSONObject) jp.parse(str);
//			System.out.println(jo);
			
			JSONObject sys = (JSONObject) jo.get("sys");
			System.out.println("나라 이름 : " + sys.get("country"));
			
			System.out.println("도시 이름 : " + jo.get("name"));
			
			JSONArray weather = (JSONArray) jo.get("weather");
			
			JSONObject wth = (JSONObject) weather.get(0);
			System.out.println("날씨 : " + wth.get("description"));
			
			JSONObject main = (JSONObject) jo.get("main");
			System.out.println("기온 : " + main.get("temp") + "℃");
			System.out.println("체감온도 : " + main.get("feels_like") + "℃");
			System.out.println("최저기온 : " + main.get("temp_min") + "℃");
			System.out.println("최고기온 : " + main.get("temp_max") + "℃");
			System.out.println("기압 : " + main.get("pressure") + "hPa");
			System.out.println("습도 : " + main.get("humidity") + "%");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		k.close();
		
	}
}
