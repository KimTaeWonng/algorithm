package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S3_2606_바이러스 {
	
	static int N;
	static int[] parents;  //parents 의 값은 자신의 부모노드를 가리킨다. 
	
	// 단위집합 생성
		public static void MakeSet() {
			parents = new int[N+1];
			//자신의 부모노드를 자신의 값으로 세팅
			for(int i=1;i<=N;i++) {
				parents[i]=i;
			}	
		}
		
		//a 의 집합 찾기: a의 대표자 찾기
		public static int findSet(int a) {
			//내가 대표자일때
			if(a==parents[a]) {
				return a;
			}
			//아닐때는 대표자를 찾을때까지 재귀하고, 그 대표자를 나의 값에 덮어쓴다.
			return parents[a] = findSet(parents[a]);
			
		}
		//a,b 두 집합 합치기
		public static boolean union(int a, int b) {
			int aRoot = findSet(a);
			int bRoot = findSet(b);
			//이미 둘은 같은 집합이다. = 대표자가 같다.
			if(aRoot == bRoot) return false;
			
			parents[bRoot] = aRoot;
			return true;
		}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		int M = Integer.parseInt(br.readLine());
		
		MakeSet();  //N만큼 노드 생성
		
		for(int i=0;i<M;i++) { //M개 주어진 만큼 연결
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);			
		}
		
		int cnt=0;
		for(int i=1;i<=N;i++) {
			//System.out.println(findSet(i));
			if(findSet(i)==findSet(1)) {
				cnt++;
			}
		}
		cnt--; // 숙주인 1번 컴퓨터는 제외
		System.out.println(cnt);

	}

}
