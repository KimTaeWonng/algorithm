package com.ssafy.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_2589_보물섬 {

	static class point {
		int r;
		int c;
		
		public point() {
			super();
		}

		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int N, M, map[][], deltas[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int max;
	static ArrayList<point> arl = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int r = 0; r < N; r++) {
			String[] str = br.readLine().split("");
			for (int c = 0; c < M; c++) {
				if (str[c].equals("W")) {
					map[r][c] = -1;
				} else {
					map[r][c] = 0;
				}
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] != -1) {
					bfs(r, c);
				}
			}
		}

		System.out.println(max);

	}

	private static void bfs(int r, int c) {
		Queue<point> p = new LinkedList<>();
		boolean visited[][] = new boolean[N][M];
		p.add(new point(r, c));
		visited[r][c] = true;
		point temp = new point(0, 0);
		int cnt = 0;
		point check = new point(-1,-1);
		while (!p.isEmpty()) {

			temp = p.poll();

			for (int d = 0; d < 4; d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];

				if (isin(nr, nc) && map[nr][nc] != -1 && !visited[nr][nc]) {
					p.add(new point(nr, nc));
					map[nr][nc] = map[temp.r][temp.c] + 1;
					visited[nr][nc] = true;
					if (cnt < map[nr][nc]) {
						check = new point(nr, nc);
						cnt = map[nr][nc];
					}
				}
			}
		}

		if (check != null && (check.r !=-1 && check.c!=-1)) {
			visited = new boolean[N][M];

			p.add(check);
			visited[check.r][check.c] = true;
			int first = map[check.r][check.c];

			while (!p.isEmpty()) {

				temp = p.poll();

				for (int d = 0; d < 4; d++) {
					int nr = temp.r + deltas[d][0];
					int nc = temp.c + deltas[d][1];

					if (isin(nr, nc) && map[nr][nc] != -1 && !visited[nr][nc]) {
						p.add(new point(nr, nc));
						map[nr][nc] = map[temp.r][temp.c] + 1;
						visited[nr][nc] = true;
						if (max < map[nr][nc] - first) {
							max = map[nr][nc] - first;
						}
					}
				}
			}
		}

	}

	static boolean isin(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
