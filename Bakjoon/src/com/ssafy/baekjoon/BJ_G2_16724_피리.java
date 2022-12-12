package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_G2_16724_피리 {
	
	static int N,M;
	static char[][] map;
	static int[] parent;
	static HashSet<Integer> hs = new HashSet<>();
	
	static int findSet(int a) {
		if(a==parent[a]) {
			return a;
		}else {
			return parent[a] = findSet(parent[a]);
		}
	}
	
	static void unionSet(int a, int b) {
		int aA = findSet(a);
		int bB = findSet(b);
		
		if(aA>=bB) {
			parent[aA] = bB;
		}else {
			parent[bB] = aA;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		parent = new int[N*M];
		
		for(int r=0;r<N;r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		for(int i=0;i<parent.length;i++) {
			parent[i] = i;
		}
		//여기까지 입력 받기
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				int temp = r*M+c;
				int next = go(r,c);
				if(findSet(temp)==findSet(next)) {
					continue;
				}else {
					unionSet(temp, next);
				}
			}
		}
		
		
		for(int i=0;i<parent.length;i++) {
			hs.add(findSet(i));
		}
		
		System.out.println(hs.size());

	}
	
	static int go(int r, int c) {
		int temp1 = r;
		int temp2 = c;
		
		if(map[r][c]=='U') {
			temp1--;
		}
		if(map[r][c]=='D') {
			temp1++;
		}
		if(map[r][c]=='L') {
			temp2--;
		}
		if(map[r][c]=='R') {
			temp2++;
		}
		
		return temp1*M+temp2;
		
	}
	
	
	

}
