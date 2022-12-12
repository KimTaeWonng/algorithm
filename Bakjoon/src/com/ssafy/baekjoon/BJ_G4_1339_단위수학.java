package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_G4_1339_단위수학 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		Integer[] alphabet = new Integer[26];  //밑에 reverseOrder해주려고 INteger로 선언함
		
		int N = Integer.parseInt(br.readLine());
		
		String[] str = new String[N];
		
		for(int i=0;i<26;i++) {
			alphabet[i]=0;  //초기화
		}
		
		for(int i=0;i<N;i++) {
			str[i] = br.readLine();  //입력받기
			//System.out.println(str[i]);
		}
		
		
		for(int i=0;i<N;i++) {
			int ten = (int) Math.pow(10, str[i].length()-1);  //각 문자열의 최대자리수 구하기
			
			for(int j=0;j<str[i].length();j++) {
				alphabet[str[i].charAt(j)-'A']+=ten;  //각 알파벳의 자리수만큼 입력 (백의자리=100 십의자리=10)
				ten/=10;
			}
		}
		
		Arrays.sort(alphabet,Collections.reverseOrder()); // 가장 큰 자리수가 먼저나오게
		
		int number= 9;
		int ans = 0;
		
		for(int i=0;i<10;i++) { 
			ans += alphabet[i]*number;  //맨앞 = 가장큰 자리수
			number--;
		}
		
		System.out.println(ans);
	

	}

}
