package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _BOJ_ST_G5_21278 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int map[][] = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			Arrays.fill(map[i], (100 * 99 / 2)); // 최대값 N(N-1)/2;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int Ai = Integer.parseInt(st.nextToken());
			int Bi = Integer.parseInt(st.nextToken());
			map[Ai][Bi] = 1;
			map[Bi][Ai] = 1;
		}

		for (int i = 1; i <= N; i++) { // 경 출 도
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;
				for (int k = 1; k <= N; k++) {
					if (i == k || j == k)
						continue;
					if (map[j][k] > map[j][i] + map[i][k]) {
						map[j][k] = map[j][i] + map[i][k];
					}
				}
			}
		}

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if(map[r][c] ==4950) map[r][c]=0;
			}			
		}
		
		int min =Integer.MAX_VALUE;
		
		int store1=0,store2=0;
		for(int i=1;i<=N;i++) {			
			for(int j=i+1;j<=N;j++) {
				int sum=0;
				for(int k=1;k<=N;k++) {
					sum+= Math.min(map[i][k], map[j][k]);
				}
				if(min>sum) {
					min = sum;
					store1=i;
					store2=j;
				}
			}
		}
		
		System.out.println(store1+" "+store2+" "+min*2);

	}

}
