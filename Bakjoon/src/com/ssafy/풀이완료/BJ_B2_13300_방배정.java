package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_B2_13300_방배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] student = new int[7][2];
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			
			student[grade][gender]++;
		}
		int answer = 0;
		for(int i=0;i<2;i++) {
			for(int j=1;j<=6;j++) {
				int k = student[j][i]/K;
				if(student[j][i]%K==0) {
					answer+=k;
				}else answer+=k+1;
			}
		}
		
		System.out.println(answer);

	}

}
