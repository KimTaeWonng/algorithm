package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _BOJ_LCA_G4_3584 {
	
	static int parent[], depth[];
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			
			int N =Integer.parseInt(br.readLine());
			
			parent = new int[N+1];
			depth = new int[N+1];
			visited = new boolean[N+1];
			graph.clear();
			
			for(int i=0;i<N+1;i++) {
				graph.add(new ArrayList<>());
			}
			
			int check[] = new int[N+1];
			
			for(int i=0;i<N-1;i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph.get(a).add(b);
				graph.get(b).add(a);
				check[b]++;				
			}
			
			int root = 0;
			
			for(int i=1;i<=N;i++) {
				if(check[i]==0) {
					root = i;
					break;
				}
			}
			setDepth(root,0);
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			LCA(a,b);
			
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

	

	static void setDepth(int node, int dep) {
		
		visited[node] = true;
		depth[node] = dep;
		
		for(int temp:graph.get(node)) {
			//System.out.println(temp);
			if(!visited[temp]) {
				parent[temp]=node;
				setDepth(temp,dep+1);
			}
			
		}		
	}
	
	static void LCA(int a, int b) throws IOException {
		
		while(depth[a]!=depth[b]) {  //깊이 맞춰주기
			if(depth[a]>depth[b]) {
				a = parent[a];
			}else {
				b = parent[b];
			}
		}
		
		while(a!=b) {  //깊이가 동일해지면 위로올라가면서 공통조상 찾기
			a = parent[a];
			b = parent[b];
		}
		
		bw.write(a+"\n");
		
	}

}
