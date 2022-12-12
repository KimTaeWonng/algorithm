package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class tower{
	int num;
	int high;

public tower(int num, int high) {
		this.num = num;
		this.high = high;
	}
}

public class BJ_G5_2493_탑 {
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Stack<tower> s = new Stack<>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int high = Integer.parseInt(st.nextToken());
			if (s.isEmpty()) {
				bw.write(0 + " ");
				s.push(new tower(i,high));				
			} else {
				while (true) {
					if (s.isEmpty()) {
						bw.write(0 + " ");
						s.push(new tower(i,high));

						break;
					}
					

					if (high < s.peek().high) {
						bw.write(s.peek().num+1 +" ");
						s.push(new tower(i,high));
						break;
					} else {
						s.pop();
					}

				}
			}
		}

		/*
		 * for(int i=N-1;i>0;i--) { for(int j=i-1;j>=0;j--) { if(tower[i]<tower[j]) {
		 * s.push(j+1); ispush = true; break; } } if(!ispush) { s.push(0); }
		 * ispush=false; }
		 */

		// s.push(0);

		bw.flush();
		bw.close();

	}
}
