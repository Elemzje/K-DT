package com.minju.may272.main;

import java.io.InputStream;

import com.minju.http.client.MinjuHttpClient;

public class HMain3 {
	public static void main(String[] args) {
		try {
			InputStream is = MinjuHttpClient.download("https://www.naver.com");
			String result = MinjuHttpClient.convert(is, "UTF-8");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
