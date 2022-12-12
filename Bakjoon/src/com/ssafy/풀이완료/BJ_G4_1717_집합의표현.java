package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G4_1717_집합의표현 {
	
	static int N;
	static int set[];
	
	static void makeSet() {
		set = new int[N+1];
		for(int i=0;i<=N;i++) {
			set[i]=i;
		}
	}
	
	static int findSet(int a) {    //1 연산에서 쓸 함수   // a,b가 포함된 집합인가?
		if(a==set[a]) {
			return a;
		}else {
			return set[a] = findSet(set[a]);
		}
	}
	
	static void unionSet(int a,int b) {  //0 연산에서 쓸 함수   a집합에  b집합을 포함시킨다.
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot==bRoot) {   //이미 합집합이다
			return;
		}else {
			set[bRoot] = aRoot;  //B를 A에 포함시킴 
			return;
		}
		
	}
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		makeSet();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			switch(Integer.parseInt(st.nextToken())) {
			case 0:  // 집합을 합칠때
				unionSet(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
				break;
			case 1:  // 집합이 합집합인지 판별할때
				if(findSet(Integer.parseInt(st.nextToken()))!=findSet(Integer.parseInt(st.nextToken()))) {
					System.out.println("NO");
				}else {
					System.out.println("YES");
				}
			}
		}

	}

}
