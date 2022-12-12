package com.ssafy.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S3_19941_햄버거분배 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean visited[] = new boolean[N];
		
		char[] ham = br.readLine().toCharArray();
		
		
		int cnt = 0;
		
		for(int i=0;i<N;i++) {
			
			if(ham[i]=='H') continue;
			
			for(int j=-K;j<=K;j++) {
				
				if(i+j<0 || i+j>=N) continue;
				
				if(ham[i+j]=='H' &&  !visited[i+j]) {
					cnt++;
					visited[i+j] = true;
					break;
				}
				
			}
			
		}
		
		System.out.println(cnt);

	}

}
