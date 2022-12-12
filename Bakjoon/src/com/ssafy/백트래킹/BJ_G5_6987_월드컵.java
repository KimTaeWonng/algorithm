package com.ssafy.백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G5_6987_월드컵 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int d = 0; d < 4; d++) {
			int score[][] = new int[6][3];
			boolean impassible = false;

			st = new StringTokenizer(br.readLine());

			int wins = 0;
			int draws = 0;
			int loses = 0;
			int hasDraw = 0;

			for (int i = 0; i < 6; i++) {
				int win = Integer.parseInt(st.nextToken());
				int draw = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());

				if (win + draw + lose != 5) {
					impassible = true;
					break;
				}
				
				if(draw!=0) {
					hasDraw++;
				}

				wins += win;
				draws += draw;
				loses += loses;
				
				score[i][0] = win;
				score[i][1] = draw;
				score[i][2] = lose;
			}
			
			if(wins!=loses || draws%2!=0) {
				impassible = true;
			}

			if (impassible) {
				System.out.print(0 + " ");
			} else {
				System.out.print(1 + " ");
			}
		}

	}

}
