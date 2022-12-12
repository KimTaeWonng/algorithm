package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BJ_S2_18352_특정거리도시 {
	
	static class LinkNode implements Comparable<LinkNode>{
		int num;
		int cost;

		public LinkNode(int num, int cost) {
			super();
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(LinkNode o) {
			return this.cost-o.cost;
		}				
	}
	
	static int N,M,K,X,cnt;
	static ArrayList<LinkNode>[] node;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		node = new ArrayList[N+1];	
		
		for(int i=0;i<=N;i++) {
			node[i]= new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			node[a].add(new LinkNode(b, 1));
		}
		
		cnt=0;
		dijkstra();
		
		if(cnt==0) System.out.println(-1);
		
		bw.flush();
		bw.close();
		br.close();

	}

	private static void dijkstra() throws IOException {
		int distance[] = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<LinkNode> pq = new PriorityQueue<>();
		
		distance[X]=0;
		pq.offer(new LinkNode(X, 0));
		
		while(!pq.isEmpty()) {
			LinkNode current = pq.poll();
			int num  = current.num;
			int cost = current.cost;
			
			if(distance[num]<cost) {
				continue;
			}
			
			for(int i=0;i<node[num].size();i++) {
				int temp = node[num].get(i).num;
				int temp2 = node[num].get(i).cost+cost;
				distance[temp] = Math.min(distance[temp], temp2);
				pq.offer(new LinkNode(temp,temp2));
			}
			
		}
		
		for(int i=0;i<=N;i++) {
			if(distance[i]==K) {
				cnt++;
				bw.write(i+"\n");
			}
		}
	
	}

}
