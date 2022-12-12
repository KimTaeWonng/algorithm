package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _BOJ_DP_S3_14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] d = new int[N + 6];
		int[] p = new int[N+6];
		int memo[] = new int[N + 6];


		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			d[i] = a;
			p[i] = b;
		}
		
		
		for (int i = 0; i <= N; i++) {
			memo[i] = 0;
		}
		int max=0;

		for (int i = 1; i <= N+1; i++) {
			memo[i] =  Math.max(memo[i], max);
			memo[i+d[i]] = Math.max(memo[i+d[i]], memo[i]+p[i]);
			max = Math.max(memo[i], max);
		}
		System.out.println(max);

	}

}
