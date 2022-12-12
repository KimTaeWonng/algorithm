package com.ssafy.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_5014_스타트링크 {
	
	static int F,G,S,U,D,cnt[];
	static boolean visited[],go;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		visited = new boolean[F+1];
		cnt = new int[F+1];
		if(U==0 && S<G) {
			
		}else if(D==0 && S>G) {
			
		}else {
			bfs(S);
		}
		
		if(go) {
			System.out.println(cnt[G]);
		}else {
			System.out.println("use the stairs");
		}
	}

	private static void bfs(int floor) {


		Queue<Integer> q = new LinkedList<>();
		
		q.add(floor);
		visited[floor] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			//System.out.println(temp);
			if(temp==G) {
				go= true;
				return;
			}
//			if(Math.abs(temp-G)==U-D) {
//				//System.out.println(111);
//				go=true;
//				cnt+=2;
//				return;
//			}
			if(isin(temp-D)&& !visited[temp-D]) {
				q.add(temp-D);
				visited[temp-D] = true;
				cnt[temp-D] = cnt[temp] +1;
			}
			if(isin(temp+U)&& !visited[temp+U]) {
				q.add(temp+U);
				visited[temp+U] = true;
				cnt[temp+U] = cnt[temp] +1;
			}
		}
		
	}
	
	static boolean isin(int floor) {
		return floor<=F && floor>=1;
	}
	

}
