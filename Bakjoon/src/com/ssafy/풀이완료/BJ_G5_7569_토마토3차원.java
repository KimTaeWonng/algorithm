package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_7569_토마토3차원 {
	static int R, C, H, map[][][], day;
	static int delta[][] = { { 0, 1, 0 }, { 0, -1, 0 }, { 1, 0, 0 }, { -1, 0, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };
	static Queue<tomato> q = new LinkedList<>();

	static class tomato {
		int pointR;
		int pointC;
		int pointH;

		public tomato(int pointR, int pointC, int pointH) {
			this.pointR = pointR;
			this.pointC = pointC;
			this.pointH = pointH;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[R][C][H];

		boolean Goahead = false;
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					map[r][c][h] = Integer.parseInt(st.nextToken());
					if (map[r][c][h] != 0 && map[r][c][h] != -1) {
						q.offer(new tomato(r, c, h));
					}
					if (map[r][c][h] == 0) {
						Goahead = true;
					}
				}
			}
		}

		dfs();

		boolean no = false;
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c][h] > day) {
						day = map[r][c][h];
					}
					if (map[r][c][h] == 0) {
						no = true;
					}
				}
			}
		}

		if (!Goahead)
			bw.write(0 + "\n");
		else if (no)
			bw.write(-1 + "\n");
		else
			bw.write(day - 1 + "\n");

		bw.flush();
		bw.close();
		br.close();

	}

	static public void dfs() {
		while (!q.isEmpty()) {
			tomato temp = q.poll();

			for (int d = 0; d < 6; d++) {
				int nr = temp.pointR + delta[d][0];
				int nc = temp.pointC + delta[d][1];
				int nh = temp.pointH + delta[d][2];
				if (isin(nr, nc, nh) && map[nr][nc][nh] == 0) {
					q.offer(new tomato(nr,nc,nh));
					map[nr][nc][nh] = map[temp.pointR][temp.pointC][temp.pointH] + 1;

				}

			}
		}

	}

	static public boolean isin(int r, int c, int h) {
		return (r >= 0 && c >= 0 && h >= 0 && r < R && c < C && h < H);
	}

}
