package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_7576_토마토2차원 {
	static int R, C, H, map[][], Max,cnt;
	static int delta[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean[][] visit;
	static Queue<tomato> q = new LinkedList<>();

	static class tomato {
		int pointR;
		int pointC;

		public tomato(int pointR, int pointC) {
			this.pointR = pointR;
			this.pointC = pointC;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		boolean Goahead = false;

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 1) {
					q.offer(new tomato(r, c));
					cnt++;
				}
				if (map[r][c] == 0) {
					Goahead = true;
				}
			}
		}
		
		dfs();

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}

		boolean no = false;

		for (int r = 0; r < R; r++) { // 출력값을 정하는 과정 ( 0이 있으면 -1, 없으면 Max값을 찾아 걸린 일수 구하기)
			for (int c = 0; c < C; c++) {
				if (map[r][c] > Max) {
					Max = map[r][c];
				}
				if (map[r][c] == 0) {
					no = true;
				}
			}
		}

		if (!Goahead)
			bw.write(0 + "\n");
		else if (no)
			bw.write(-1 + "\n");
		else
			bw.write(Max - 1 + "\n");

		bw.flush();
		bw.close();
		br.close();

	}

	static public void dfs() {
		while (!q.isEmpty()) {
			tomato temp = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = temp.pointR + delta[d][0];
				int nc = temp.pointC + delta[d][1];
				
				if (isin(nr, nc) && map[nr][nc] == 0) {
					q.offer(new tomato(nr, nc));
					map[nr][nc] = map[temp.pointR][temp.pointC] + 1;
				}

			}
		}

	}

	static public boolean isin(int r, int c) {
		return (r >= 0 && c >= 0 && r < R && c < C);
	}

}
