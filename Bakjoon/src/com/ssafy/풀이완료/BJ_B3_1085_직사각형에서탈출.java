package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_B3_1085_직사각형에서탈출 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
	
		int hansuR,hansuC;
		int squareR,squareC;
		
		st=new StringTokenizer(br.readLine());
		hansuR = Integer.parseInt(st.nextToken());
		hansuC = Integer.parseInt(st.nextToken());
		squareR = Integer.parseInt(st.nextToken());
		squareC = Integer.parseInt(st.nextToken());
		
		int MIN;
		
		int a = Math.min(hansuC, hansuR);
		int b = Math.min(Math.abs(squareC-hansuC),Math.abs(squareR-hansuR));
		MIN = Math.min(a, b);
		
		System.out.println(MIN);

	}

}
