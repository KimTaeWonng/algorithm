package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class BJ_S3_9996_한국이그리울땐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split("\\*",2);
		String patten = "^"+str[0]+".*"+str[1]+"$";
		for(int i=0;i<T;i++) {
			
			String temp = br.readLine();			
			if(Pattern.matches(patten,temp)) {
				System.out.println("DA");
			}else {
				System.out.println("NE");
			}
			
		}

	}

}
