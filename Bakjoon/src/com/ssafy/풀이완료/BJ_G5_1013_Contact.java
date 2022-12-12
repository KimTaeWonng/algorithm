package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class BJ_G5_1013_Contact {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			
			//정규 표현 식이랑 똑같다. () + | 등등
			
			String str = br.readLine();
			
			boolean YES = false;
			
		
			// ^ = 문자열 시작, $ = 문자열 끝, + = 바로 앞 문자가 하나이상 존재함, | = or 
			// () 괄호안의 문자열을 하나의 문자로 판단
			
			YES = Pattern.matches("^(100+1+|01)+$", str); 
			
			
			if(!YES) System.out.println("NO");
			else System.out.println("YES");
			
		}

	}

}
