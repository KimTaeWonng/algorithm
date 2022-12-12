package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_1245_농장관리 {

	static int N, M, map[][], cnt;
	static int deltas[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
	static boolean visited[][], checked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (!visited[r][c]) {
					checked = true;
					dfs(r, c);
					if (checked)
						cnt++;
				}
			}
		}

		System.out.println(cnt);

	}

	private static void dfs(int r, int c) {

		visited[r][c] = true;

		for (int d = 0; d < 8; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if (isin(nr, nc) && map[nr][nc] > map[r][c])
				checked = false;
			else if (isin(nr, nc) && !visited[nr][nc] && map[nr][nc] == map[r][c]) {
				dfs(nr, nc);
			}
		}

	}

	static boolean isin(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
