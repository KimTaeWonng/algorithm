package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import com.ssafy.baekjoon.BJ_G5_17396_백도어.Vertex;

public class BJ_G5_14284_간선이어가기2 {
	static int N,M,S,T,distance[];
	static boolean[] visit;
	
	static class Vertex implements Comparable<Vertex>{
		int num;
		int cost;
		
		public Vertex(int num, int cost) {
			super();
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(Vertex o) {
			
			return this.cost-o.cost;
		}
		
		
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<Vertex>[] arr;
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		
		arr = new ArrayList[N];
		for(int i=0;i<N;i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			arr[a].add(new Vertex(b,c));
			arr[b].add(new Vertex(a,c));
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken())-1;    //시작점
		T = Integer.parseInt(st.nextToken())-1;	 //끝점
				
		
		distance = new int[N];
		visit = new boolean[N];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[S]= 0;   //첫 시작점은 거리가 0
		
		pq.offer(new Vertex(S,distance[S]));
		
		while(!pq.isEmpty()) {
			Vertex current = pq.poll();
			
			if(visit[current.num]) continue;   //이미 방문했던 곳이면 패스
			
			visit[current.num] =true;
			
			for (int i = 0; i < arr[current.num].size(); i++) {    //경유 해야 할 때 최소거리 판단
				Vertex next = arr[current.num].get(i);
 				if (!visit[next.num] && distance[next.num] > distance[current.num] + next.cost) {
					distance[next.num] = distance[current.num] + next.cost;
					pq.offer(new Vertex(next.num, distance[next.num]));
				}
			}
			
		}
		
		bw.write(distance[T]+"\n");
		
		bw.flush();
		br.close();
		bw.close();
	}

}
