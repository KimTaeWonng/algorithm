package com.ssafy.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S5_1316_그룹단어체커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		for(int i=0;i<N;i++) {
			
			boolean[] arr = new boolean[26];
			boolean check= false;
			
			char[] temp = br.readLine().toCharArray();
			
			for(int c=0;c<temp.length;c++) {
				
				if(arr[temp[c]-'a']) {
					if(temp[c]!=temp[c-1]) {
						check = true;
						break;
					}
				}
				
				arr[temp[c]-'a'] = true;
				
			}
			
			if(!check) cnt++;
			
		}
		
		System.out.println(cnt);

	}

}
