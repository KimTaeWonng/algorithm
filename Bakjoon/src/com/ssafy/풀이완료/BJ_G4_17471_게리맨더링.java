package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_17471_게리맨더링 {
	
	static int N, people[],min;
	static boolean red[];  //red or blue
	static ArrayList<Integer>[] arl;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		people = new int[N+1];
		arl = new ArrayList[N+1];
		red = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1;i<=N;i++) {
			people[i] = Integer.parseInt(st.nextToken());
			arl[i] = new ArrayList<>();
		}
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for(int j=0;j<M;j++) {
				arl[i].add(Integer.parseInt(st.nextToken()));   // i와 인접한 것들 넣어줌
			}
		}
		
		min = Integer.MAX_VALUE;
		
		poll(0);
		
		if(min==Integer.MAX_VALUE) System.out.println(-1);  //해없음
		else System.out.println(min);

	}
	
	static void poll(int cnt) {
		
		if(cnt == N+1) {
			
			if(divide()) {
				
				int r=0;
				int b=0;
				
				for(int i=1;i<=N;i++) {
					if(red[i]) r+= people[i];
					else b+=people[i];
				}
				
				min = Math.min(min, Math.abs(r-b));
			}
			
			return;
		}
		
		red[cnt] = true;  //2번
		poll(cnt+1);
		
		red[cnt] = false; //1번
		poll(cnt+1);
			
		
	}
	
	static boolean divide() {
		boolean visited[] = new boolean[N+1];
		
		int r = 0;
		int b = 0;
		for(int i=1;i<=N;i++) {
			if(red[i]) {
				r=i;
				break;
			}
		}
		
		for(int i=1;i<=N;i++) {
			if(!red[i]) {
				b=i;
				break;
			}
		}
		
		if(r ==0 || b==0) return false;
		
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(r);
		visited[r] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i=0;i<arl[temp].size();i++) {
				if(visited[arl[temp].get(i)] || !red[arl[temp].get(i)]) continue;
				
				visited[arl[temp].get(i)]=true;
				q.offer(arl[temp].get(i));
			}
		}
		
		q.offer(b);
		visited[b] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i=0;i<arl[temp].size();i++) {
				if(visited[arl[temp].get(i)] || red[arl[temp].get(i)]) continue;
				
				visited[arl[temp].get(i)]=true;
				q.offer(arl[temp].get(i));
			}
		}
		
		for(int i=1;i<=N;i++) {
			if(!visited[i]) return false; //구역이 세군데 이상으로 나뉨
		}
		
		
		return true;
		
	}
}
