package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G4_1939_중량제한 {
	static class bridge{
		int island;
		int weight;
		
		public bridge(int island, int weight) {
			super();
			this.island = island;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "bridge [island=" + island + ", weight=" + weight + "]";
		}
		
		
		
	}
	static int N,M;
	static bridge[] B;
	
	static int findSet(int a) {
		if(B[a].island == a) {
			return a;
		}else {
			return B[a].island = findSet(B[a].island);
		}
	}
	
	static void unionSet(int a, int b, int c) {
		int aR = findSet(a);
		int bR = findSet(b);
		
		if(aR==bR) {
			if(a)
			return;
		}else {
			if(a>b) {
				B[aR].island = bR;
			}else {
				B[bR].island = aR;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		

	}

}
