package com.ssafy.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_13565_침투 {

	static int N, M, map[][], deltas[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean visited[][];
	static boolean check;

	static class point {
		int r;
		int c;

		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

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
			String[] str = br.readLine().split("");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(str[c]);
			}
		}

		for (int c = 0; c < M; c++) {
			if (!check) {
				if (map[0][c] == 0) {
					System.out.println(1);
					bfs(0, c);
				}
			}
		}

		if (check) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	private static void bfs(int r, int c) {

		Queue<point> q = new LinkedList<>();
		q.add(new point(r, c));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			point temp = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
				if (isin(nr, nc) && !visited[nr][nc] && map[nr][nc] == 0) {
					if (nr == N - 1) {
						check = true;
						return;
					}
					q.add(new point(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}

	}

	public static boolean isin(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
