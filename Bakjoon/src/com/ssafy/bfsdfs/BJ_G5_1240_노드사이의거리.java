package com.ssafy.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_1240_노드사이의거리 {
	
	static class node{
		int to;
		int distance;
		public node(int to, int distance) {
			super();
			this.to = to;
			this.distance = distance;
		}
		
		
	}
	
	static int N,M;
	static boolean visited[];
	static ArrayList<node> no[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		no = new ArrayList[N+1];
		
		for(int i=0;i<=N;i++) {
			no[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			no[to].add(new node(from, distance));
			no[from].add(new node(to,distance));
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			bw.write(go(a,b)+"\n");
		}
		bw.flush();

	}

	private static int go(int a, int b) {
		int answer = 0;
		visited = new boolean[N+1];
		Queue<node> q = new LinkedList<>();
		
		q.add(new node(a,0));
		visited[a] = true;
		
		while(!q.isEmpty()) {
			
			node temp = q.poll();
			
			if(temp.to==b) {
				answer = temp.distance;
				break;
			}
			
			for(node n : no[temp.to]) {
				if(!visited[n.to]) {
					q.add(new node(n.to, temp.distance + n.distance));
					visited[n.to] = true;
				}
			}
			
		}
		
		return answer;
		
		
		
	}

}
