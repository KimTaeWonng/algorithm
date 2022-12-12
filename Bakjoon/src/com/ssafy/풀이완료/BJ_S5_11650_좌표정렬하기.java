package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S5_11650_좌표정렬하기 {
	
	static class point implements Comparable<point>{
		int pointX;
		int pointY;
		
		public point(int pointX, int pointY) {
			this.pointX = pointX;
			this.pointY = pointY;
		}
		
		@Override
		public int compareTo(point o) {
			if(this.pointX ==o.pointX)
			return this.pointY-o.pointY;
			else return this.pointX - o.pointX;
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		point[] p = new point[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = new point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(p);
		
		for(int i=0;i<N;i++) {
			bw.write(p[i].pointX+" "+p[i].pointY+"\n");
		}
		
		
		bw.flush();
		bw.close();
		br.close();

	}

}
