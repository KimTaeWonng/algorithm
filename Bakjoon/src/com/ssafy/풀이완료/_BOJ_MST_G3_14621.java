package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _BOJ_MST_G3_14621 {
	
	static class mst implements Comparable<mst>{
		int from;
		int to;
		int weight;
		
		public mst(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(mst o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
		
	}
	
	static int findSet(int a) {
		if(a==parent[a]) {
			return a;
		}
		
		return parent[a] = findSet(parent[a]);
	}
	
	static boolean unionSet(int a, int b) {
		int aR = findSet(a);
		int bR = findSet(b);
		
		if(aR==bR) {
			return false;
		}
		
		if(aR>bR) {
			parent[aR] = bR;
		}else {
			parent[bR] = aR;
		}
		return true;
	}
	
	static int N,M,parent[];
	static boolean gender[];
	static mst[] m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		gender = new boolean[N+1];
		m = new mst[M];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1;i<=N;i++) {
			parent[i]=i;
			
			if(st.nextToken().equals("M")) {  
				gender[i]=true;
			}
		}
		//parent, gender 초기화 합니다
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			m[i] = new mst(a,b,c);
		}
		
		Arrays.sort(m);
		
		long ans=0;
		long cnt=0;
		
		for(int i=0;i<m.length;i++) {
			if(gender[m[i].from]!=gender[m[i].to] && unionSet(m[i].from,m[i].to)) {
//				System.out.println(m[i].from+" "+m[i].to+" "+m[i].weight);
				ans+= m[i].weight;
				cnt++;
			}
			if(cnt==N-1) {
				break;
			}
			
		}
		
		if(cnt!=N-1) {
			System.out.println(-1);
		}else 
			System.out.println(ans);

	}

}
