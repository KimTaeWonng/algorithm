package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class _BOJ_MST_G3_1774 {
	
	static class distance implements Comparable<distance>{
		God g1;
		God g2;
		double distance;
		
		
		public distance(God g1, God g2, double distance) {
			this.g1 = g1;
			this.g2 = g2;
			this.distance = distance;
		}

		@Override
		public int compareTo(distance o) {
			return Double.compare(this.distance, o.distance);
		}
		
		
	}
	
	static class God{
		int num;
		int x;
		int y;
		
		public God(int num, int x, int y) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
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
	static God[] g;
	static ArrayList<distance> d = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		g = new God[N+1];
		parent = new int[N+1];
		
		
		for(int i=1;i<=N;i++) {
			parent[i] = i;
			st = new StringTokenizer(br.readLine());
			g[i] =new God(i,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			
		}
		
		
		for(int i=0;i<M;i++) {  //이미 연결된 통로
			st = new StringTokenizer(br.readLine());
			unionSet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		
		for(int i=1;i<=N;i++) { // N개중에 2개를 선택하는 모든 경우의 수를 다 구해준다
			for(int j=i+1;j<=N;j++) {
				d.add(new distance(g[i],g[j],Math.sqrt(Math.pow(Math.abs(g[i].x-g[j].x),2)+Math.pow(Math.abs(g[i].y-g[j].y), 2))));
			}
		}
		
		Collections.sort(d);  //distance가 짧은 순으로 오름차순 정렬시켜준다. 
		
		//N-M-1만큼 연결 시켜줘야댐
		
		if(M==N-1) {
			System.out.println(0.00);  //이미 모든게 연결되어 있는 경우 할필요없음
		}else {
			double ans=0;
			long cnt=0;
			for(int i=0;i<d.size();i++) {
				if(unionSet(d.get(i).g1.num, d.get(i).g2.num)) {
					ans+=d.get(i).distance; //이어준 통로의 거리만큼 더하기
					cnt++;
				}
				if(cnt==N-M-1) {  //미리 연결된 통로 이외에 다른 통로를 다 연결해주면 나와
					break;
				}
			}
			
			System.out.printf("%.2f",ans);
		}
		
		
		

	}

}








