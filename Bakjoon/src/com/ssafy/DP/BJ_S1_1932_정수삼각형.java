package com.ssafy.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S1_1932_정수삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] memo = new int[N][];

		for (int i = 0; i < N; i++) {
			memo[i] = new int[i + 1];
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j <= i; j++) {
				memo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				memo[i - 1][j] += Math.max(memo[i][j], memo[i][j + 1]);
			}
		}

		System.out.println(memo[0][0]);

	}

}
