package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S4_10157_자리배정 {
	static int MAX,C,R,map[][];
	static boolean sold[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		R= Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		
		int K= Integer.parseInt(br.readLine());
		
		map = new int[R][C];
		sold = new boolean[R][C];
		int ticket=1;
		MAX = R*C;
		
		map[0][0]=ticket;
		sold[0][0]=true;
		ticketing(0,0,2);
		
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c]==K) {
					System.out.println((r+1)+" "+(c+1));
				}
			}
		}
		if(K>MAX) System.out.println(0);

	}
	
	public static void ticketing(int r,int c,int cnt) {
		if(cnt>MAX) return;
		
		for (int i = 1; i <= C; i++) {
			if (c + i < C && sold[r][c + i] == false) { // 내 오른쪽으로 갈 수 있을때
				map[r][c + i] = cnt;
				sold[r][c + i] = true;
				cnt++;
			} else {
				c = c + i - 1;
				break;
			}
		}

		for (int i = 1; i <= R; i++) {
			if (r + i < R && sold[r + i][c] == false) { // 내 아래로 갈 수 있을때
				map[r + i][c] = cnt;
				sold[r + i][c] = true;
				cnt++;
			} else {
				r = r + i - 1;
				break;
			}
		}

		for (int i = 1; i <= C; i++) {
			if (c - i >= 0 && sold[r][c - i] == false) { // 내 왼쪽으로 갈 수 있을떄
				map[r][c - i] = cnt;
				sold[r][c - i] = true;
				cnt++;
			} else {
				c = c - i + 1;
				break;
			}
		}

		for (int i = 1; i <= R; i++) {
			if (r - i >= 0 && sold[r - i][c] == false) { // 내 위로 갈 수 있을때
				map[r - i][c] = cnt;
				sold[r - i][c] = true;
				cnt++;
			} else {
				r = r - i + 1;
				break;
			}
		}

		ticketing(r, c, cnt);
	}

}
