package com.ssafy.백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S2_14889_스타트와링크 {

	static int N, map[][], min = Integer.MAX_VALUE;
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(min);

	}

	static void comb(int start, int cnt) {
		if (min != 0) {
			if (cnt == N / 2) {

				min = Math.min(min, answer());
				return;
			}

			for (int i = start; i < N; i++) {
				if (!visited[i]) {
					visited[i] = true;
					comb(i + 1, cnt + 1);
					visited[i] = false;
				}
			}
		}
	}

	private static int answer() {

		int team1 = 0;
		int team2 = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] && visited[j]) {
					team1 += map[i][j] + map[j][i];
				}
				if (!visited[i] && !visited[j]) {
					team2 += map[i][j] + map[j][i];
				}
			}
		}

		int ans = Math.abs(team1 - team2);

		return ans;
	}

}
