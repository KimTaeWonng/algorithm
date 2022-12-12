package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _BOJ_LCA_G3_11437 {
	
	static int parent[], depth[];
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		depth = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=0;i<N+1;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);  //양방향 연결
			
		}
		
		setDepth(1,0);  //깊이 완료
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());			
			
			LCA(a,b);
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	static void setDepth(int node, int dep) {  // 깊이설정
		
		visited[node]=true;
		depth[node]=dep;
		
		for(int temp:graph.get(node)) {  //기준 노드의 자식들에게
			
			if(!visited[temp]) {  //아직 깊이설정안됨 
				parent[temp] = node;  
				setDepth(temp,dep+1);
			}			
		}		
	}
	
	static void LCA(int a,int b) throws IOException {
		
		while(depth[a]!=depth[b]) {  // step 1. 공통 조상을 찾기 전에 두 노드의 깊이를 맞춰준다.
			
			if(depth[a]>depth[b]) {  //a,b 중  더 깊이있는 노드를 부모노드로 올려줌
				a = parent[a];
			}else {
				b = parent[b];
			}
			
		}
		
		while(a!=b) { //step 2. 깊이를 맞춰준 후 두 노드가 같아질 때 까지 부모 노드로 올라간다.
			a = parent[a];
			b = parent[b];
		}
		
		
		bw.write(a+"\n");  //step 3. step2의 while문 을 빠져나오면 둘의 공통조상을 찾은 것. 출력한다
		
		
		
	}
	
	

}
