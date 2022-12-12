package com.ssafy.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_S3_11478_서로다른부분문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		HashSet<String> hs = new HashSet<>();

		String str = br.readLine();
		int cnt = 1;

		while (cnt != str.length()) {
			for (int i = 0; i < str.length()-cnt+1; i++) {
				hs.add(str.substring(i, i+cnt));
			}
			cnt++;
		}
		
		System.out.println(hs.size()+1);

	}

}
