package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_G5_1759_암호만들기 {
	static int L,C;
	static String input[],password[];
	static String moum = "aeiou";
	static ArrayList<String> arr = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		st= new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		input = new String[C];
		password = new String[C];
		
		//boolean[] Select = new boolean[C]; 
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<C;i++) {
			input[i]=st.nextToken();
		}
		
		Arrays.sort(input);
		
		comb(0,0);
		
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
		
	

	}
	
	public static void comb(int cnt,int start) {
		if(cnt==L) {  //기저조건
			int one=0;  //모음
			int two=0;  //자음
			StringBuilder sb = new StringBuilder();
			
			for(int i=0;i<L;i++) {
				if(moum.contains(password[i])) {
					one++;
				}else two++;
			}
			if(one>=1 && two>=2) {				
				for(int i=0;i<L;i++) {
					sb.append(password[i]);
				}
			}
			
			if(sb.length()!=0) {
				arr.add(sb.toString());
			}
			return;
		}
		
		
		for(int i=start;i<C;i++) {
			password[cnt]=input[i];
			comb(cnt+1,i+1);
			
		}
		
		
		
		
	}

}
