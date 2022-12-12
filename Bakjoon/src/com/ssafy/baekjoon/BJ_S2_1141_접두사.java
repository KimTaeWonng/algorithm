package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_1141_접두사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		String word[] = new String[N];
		
		for(int i=0;i<N;i++) {
			word[i] = br.readLine();
		}
		
		Arrays.sort(word);
		
		//System.out.println(Arrays.toString(word));
		
		int cnt=N;
		
		for(int i=0;i<N-1;i++) {
			boolean check=true;
			
			if(word[i].length()>word[i+1].length()) continue;
			
			for(int j=0;j<word[i].length();j++) {
				if(word[i].charAt(j)!=word[i+1].charAt(j)) {
					check=false;
					break;
				}
			}
			if(check) cnt--;
		}
		
		System.out.println(cnt);
	}

}
