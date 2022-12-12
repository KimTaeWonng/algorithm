package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_1325_효율적인해킹 {
			
	static int N,M,answer[];
	static ArrayList<Integer>[] l;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		answer = new int[N+1];
		l = new ArrayList[N+1];
		
		for(int i=0;i<=N;i++) {
			l[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			l[a].add(b);			
		}
		
		for(int i=1;i<=N;i++) {
			bfs(i);
		}
		
		int max = 0;
		for(int i=1;i<=N;i++) {
			max = Math.max(answer[i], max);
		}
		
		for(int i=1;i<=N;i++) {
			if(answer[i]==max) {
				bw.write(i+" ");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	static void bfs(int a) {
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		q.add(a);
		visited[a] = true;
		
		while(!q.isEmpty()) {
			
			int temp=q.poll();
			for(int i : l[temp]) {
				if(!visited[i]) {
					visited[i]=true;
					answer[i]++;
					q.add(i);
				}
			}
			
		}
	}

}
