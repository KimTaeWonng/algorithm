package com.ssafy.정규표현식;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BJ_B1_15881_PPAP {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		br.readLine();
		String temp = br.readLine();
		
		String regex = "pPAp";
		
		Pattern p = Pattern.compile(regex);
		
		Matcher m = p.matcher(temp);
		
		int ans=0;
		
		while(m.find()) {
			ans++;
		}
		
		System.out.println(ans);

	}

}
