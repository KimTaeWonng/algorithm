package com.ssafy.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_13023_ABCDE {
	

	static int N,M;
	static List<Integer>[] list;
	static boolean[] visited;
	static boolean abcde;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		list = new ArrayList[N];
		
		for(int i=0;i<N;i++) {
			list[i] = new ArrayList<>();
		}
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=0;i<N;i++) {
			if(abcde) break;
			visited = new boolean[N];
			
			bfs(i,0);
		}
		
		if(abcde) System.out.println(1);
		else System.out.println(0);

	}

	private static void bfs(int n, int cnt) {
		if(cnt==4) {
			abcde = true;
			return;
		}
		
		visited[n] = true;
		for(int i=0;i<list[n].size();i++) {
			if(!visited[list[n].get(i)]) {
				bfs(list[n].get(i),cnt+1);
			}
		}
		visited[n] = false;
		
	}

}
