package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G4_1976_여행가자 {
	static int N,M,city[];
	
	static int findSet(int a) {
		if(a==city[a]) {
			return a;
		}else {
			return city[a] = findSet(city[a]);
		}
	}
	
	static void unionSet(int a,int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot==bRoot) {
			return;
		}else {
			city[bRoot] = aRoot;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		city = new int[N];
		
		for(int i=0;i<N;i++) {
			city[i] = i;
		}
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a==1) {
					unionSet(i,j);
				}
			}
		}
		
		
		st = new StringTokenizer(br.readLine());
		
		int go = findSet(Integer.parseInt(st.nextToken())-1);
		boolean check=false;
		for(int i=0;i<M-1;i++) {
			
			int a = Integer.parseInt(st.nextToken())-1;
			if(go!=findSet(a)) {
				check=true;
				break;
			}
		}
		
		if(check) System.out.println("NO");
		else System.out.println("YES");
		

	}

}
