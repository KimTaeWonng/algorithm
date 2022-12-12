package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_1260_DFS와BFS {
	static int N,M,V;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		int[][] Matrix = new int[N+1][N+1];
		boolean[] visit = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			Matrix[a][b] = Matrix[b][a] = 1;
		}
		
		dfs(Matrix,visit,V);
		System.out.println();		
		bfs(Matrix,V);

	}
	
	public static void bfs(int[][] arr, int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		boolean[] visit = new boolean[N+1];
		boolean first = false;
		if(!first) {
			System.out.print(V+" ");
			first=true;
		}
		
		while(!q.isEmpty()) {
			int current = q.poll();
				
			for (int i = 1; i < N+1; i++) {
				if (!visit[i] && arr[current][i]==1) {
					
					q.offer(i);
					visit[i] = true;
				}
			}
			if(current!=V)
			System.out.print(current+" ");
		}
	}
	
	public static void dfs(int[][]arr,boolean[] visited, int start) {
		visited[start]=true;
		System.out.print(start+" ");
		
		for (int j = 1; j < N+1; j++) {
			if (!visited[j] && arr[start][j] > 0) {
				dfs(arr, visited, j);
			}

		}
	}

}
