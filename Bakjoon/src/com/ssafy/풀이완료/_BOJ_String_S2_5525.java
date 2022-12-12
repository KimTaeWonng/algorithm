package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class _BOJ_String_S2_5525 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		sb.append("I");

		for (int i = 0; i < N; i++) { // Pn 구하기
			sb.append("OI");
		}
		//System.out.println(sb);

		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		sb2.append(br.readLine()).append(" ");

		int answer = 0;

		for (int i = 0; i < sb2.length()-2; i++) {
			if(sb2.charAt(i)=='I') {
				int cnt=0;
				while(true) {
					if(sb2.charAt(i+1)=='O' && sb2.charAt(i+2)=='I') {
						cnt++;
						i+=2;
					}else break;				
					if(cnt==N) {
						cnt--;
						answer++;
					}
					//if(i>sb2.length()-2) break;
				}
			}
		}

		System.out.println(answer);

	}


}
