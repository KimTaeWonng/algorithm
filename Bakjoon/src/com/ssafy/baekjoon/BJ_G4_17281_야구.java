package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G4_17281_야구 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int inning = Integer.parseInt(br.readLine());
		
		int[][] baseball = new int[inning][9];
		
		int[] player = new int[9];
		boolean[] line = new boolean[9];
		
		for(int i=0;i<inning;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				baseball[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		

	}

}
