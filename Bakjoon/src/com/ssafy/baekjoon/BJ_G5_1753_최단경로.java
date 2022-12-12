package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_1753_최단경로 {
	
	static class LinkNode implements  Comparable<LinkNode>{
    	int i;     //노드 번호
    	int cost;  //최단 거리
    	int aCost; //출발지 에서의 누적 비용
    	LinkNode link;
    	
		public LinkNode(int i, int cost,LinkNode link) {
			this.i = i;
			this.cost = cost;
			this.link = link;
		}
		
		

		public LinkNode(int i, int aCost) {
			this.i = i;
			this.aCost = aCost;
		}



		@Override
		public int compareTo(LinkNode o) {
			
			return this.aCost-o.aCost;
		}
    	
    	
    }
	
	static int V,E,K;
	static LinkNode[] ln;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());
		
		ln = new LinkNode[V+1];
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			ln[a] = new LinkNode(b, c, ln[a]);
		}
		
		dij();
		

	}
	
	public static void dij() {
		boolean visit[] = new boolean[V+1];
		int distance[] = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		PriorityQueue<LinkNode> pq = new PriorityQueue<>();
		
		distance[K]=0;
		pq.offer(new LinkNode(K, 0));
		
		for(int i=0;i<=V;i++) {
			int temp = 0;
			int min = Integer. MAX_VALUE;
			
			for(int j=1;j<=V;j++) {
				if(!visit[j] && distance[j]<min) {
					min = distance[j];
					temp = j;
				}
			}
			
			visit[temp] = true;
			
			LinkNode next = ln[temp];
			
			while(next!=null) {
				if(!visit[next.i] && distance[next.i]>distance[temp]+next.cost) {
					distance[next.i] = distance[temp]+next.cost;
				}
				
				next = next.link;
			}
		
			
		}
		for(int k=1;k<=V;k++) {
			if(distance[k]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}else System.out.println(distance[k]);
		}
	}

}
