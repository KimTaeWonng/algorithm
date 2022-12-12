package com.ssafy.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S2_11048_이동하기 {

	static int[][] memo, map;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		memo = new int[N][M];
		map = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		memo[0][0] = map[0][0];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (isin(r - 1, c - 1)) {
					memo[r][c] = Math.max(Math.max(memo[r - 1][c] + map[r][c], memo[r][c - 1] + map[r][c]),
							memo[r - 1][c - 1] + map[r][c]);
				} else if (isin(r - 1, c)) {
					memo[r][c] = memo[r - 1][c] + map[r][c];
				} else if (isin(r, c - 1)) {
					memo[r][c] = memo[r][c-1] + map[r][c];
				}
			}
		}
		
		System.out.println(memo[N-1][M-1]);

	}

	public static boolean isin(int r, int c) {
		return r < N && r >= 0 && c < M && c >=0;
	}

}
