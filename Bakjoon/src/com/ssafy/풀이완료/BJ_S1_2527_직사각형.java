package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S1_2527_직사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int[] X = new int[4];
		int[] Y = new int[4];
		for (int t = 0; t < 4; t++) {
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 4; i++) {				
				X[i] = Integer.parseInt(st.nextToken());
				Y[i] = Integer.parseInt(st.nextToken());
			}
						
			if(X[1]<X[2] || Y[1]<Y[2] || X[3]<X[0] || Y[3]<Y[0]) {
				System.out.println("d");
			}else if((X[1]==X[2] && Y[0]==Y[3]) || (X[0]==X[3] && Y[0]==Y[3]) || (X[0]==X[3] && Y[1]==Y[2]) || (X[1]==X[2] && Y[1]==Y[2])) {
				System.out.println("c");
			}else if(X[1]==X[2] || Y[1]==Y[2] || Y[3]==Y[0] || X[3]==X[0]) {
				System.out.println("b");
			}else {
				System.out.println("a");
			}
			
		}

	}

}
