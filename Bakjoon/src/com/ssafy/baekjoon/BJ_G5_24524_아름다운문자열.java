package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_G5_24524_아름다운문자열 {
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		char[] S = br.readLine().toCharArray();
		char[] T = br.readLine().toCharArray();
		boolean[] checkT;
		boolean exit = false;
		int cnt=0;
		while (true) {
			int a=0;
			
			checkT = new boolean[T.length];
			
			for (int j = 0; j < T.length; j++) {
				for (int i = a; i < S.length; i++) {
					if (T[j] == S[i]) {
						S[i] = 'Z';
						checkT[j] = true;
						a=i;
						break;
					}
				}
			}
			
			for(int i=0;i<checkT.length;i++) {
				if(checkT[i]==false) {
					exit = true;
					break;
				}
			}
			
			if(exit) {
				break;
			}
			cnt++;
			
		}
		
		System.out.println(cnt);

	}

}
