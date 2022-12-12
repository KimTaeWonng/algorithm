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

public class BJ_G5_17396_백도어 {

	static int N, M, ward[];
	static long distance[];
	
	static class Vertex implements Comparable<Vertex>{
		int num;		// 정점번호
		long distance;   // 최단거리
		
		public Vertex(int num, long distance) {
			this.num = num;
			this.distance = distance;
		}

		@Override
		public int compareTo(Vertex o) {			
			return Long.compare(this.distance, o.distance);
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ward = new int[N];
		ArrayList<Vertex>[] arr;
		PriorityQueue<Vertex> pq = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			ward[i] = Integer.parseInt(st.nextToken());
		}
		ward[N - 1] = 0; // 넥서스는 가도됨
		
		arr = new ArrayList[N];
		for(int i=0;i<N;i++) {
			arr[i]= new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a].add(new Vertex(b, c));    	         
			arr[b].add(new Vertex(a, c));   //양방향 
		}
		

		distance = new long[N];
		boolean visit[] = new boolean[N];
		
		for(int i=0;i<N;i++) {
			if(ward[i]==1) visit[i]=true;   //와드 있는곳은 어차피 못가니까 들렀다고 친다
		}
		
		Arrays.fill(distance, Long.MAX_VALUE);
		distance[0] = 0;
		
		pq.offer(new Vertex(0,distance[0]));

		while(!pq.isEmpty()) {
			Vertex current = pq.poll();
						
			if(visit[current.num]) continue;
			
			visit[current.num] = true;


			for (int i = 0; i < arr[current.num].size(); i++) {    //경유 해야 할 때 최소거리 판단
				Vertex next = arr[current.num].get(i);
 				if (!visit[next.num] && distance[next.num] > distance[current.num] + next.distance) {
					distance[next.num] = distance[current.num] + next.distance;
					pq.offer(new Vertex(next.num, distance[next.num]));
				}
			}

		}
		
		
		if(distance[N-1]!=Long.MAX_VALUE)
		bw.write(distance[N-1]+"\n");
		else bw.write(-1+"\n");
		
		bw.flush();
		bw.close();
		br.close();

	}

}
