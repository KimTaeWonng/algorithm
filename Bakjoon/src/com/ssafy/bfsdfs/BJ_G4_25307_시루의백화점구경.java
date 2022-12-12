package com.ssafy.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_25307_시루의백화점구경 {

	static int N, M, K, map[][], deltas[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean[][] visited, check, visitedMnq;
	static Queue<point> p = new LinkedList<>();
	static Queue<point> chair = new LinkedList<>();
	static int startR, startC, min = Integer.MAX_VALUE;

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
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		visitedMnq = new boolean[N][M];
		startR = 0;
		startC = 0;
		boolean ishave = false;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 2) {
					ishave = true;
				} else if (map[r][c] == 3) {
					if (K == 0) {
						map[r][c] = 1;
					} else
						p.add(new point(r, c));
				} else if (map[r][c] == 4) {
					startR = r;
					startC = c;
				}
			}
		}

		Mnqbfs();

//		for (int r = 0; r < N; r++) {
//			for (int c = 0; c < M; c++) {
//				System.out.print(map[r][c] + " ");
//			}
//			System.out.println();
//		}
		map[startR][startC]=4;

		bfs(startR, startC);
		

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}

	}

	static void bfs(int r, int c) {

		Queue<point> q = new LinkedList<>();
		q.add(new point(r, c));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			point temp = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];

				if (!isin(nr, nc))
					continue;
//&& 
				if (!visited[nr][nc] && map[nr][nc] != 1) {
					if (map[nr][nc] == 2) {
						min = map[temp.r][temp.c] - 3;
						return;
					} else {
						q.add(new point(nr, nc));
						map[nr][nc] = map[temp.r][temp.c] + 1;
						visited[nr][nc] = true;

					}
				}
			}
		}

	}

	static boolean isin(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

	static void Mnqbfs() {
		Queue<point> q = new LinkedList<>();

		int temp = p.size();
		for (int i = 0; i < temp; i++) {
			point mnq = p.poll();

			q.add(mnq);
			visitedMnq[mnq.r][mnq.c] = true;

			while (!q.isEmpty()) {
				point m = q.poll();

				for (int d = 0; d < 4; d++) {
					int nr = m.r + deltas[d][0];
					int nc = m.c + deltas[d][1];

					if (isin(nr, nc) && !visitedMnq[nr][nc] && Math.abs(mnq.r - nr) + Math.abs(mnq.c - nc) <= K) {
						map[nr][nc] = 1;
						q.add(new point(nr, nc));
						visitedMnq[nr][nc] = true;
					}
				}
			}

		}

	}

}
