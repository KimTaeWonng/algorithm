package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_9205_맥주 {
	
	static class point{
		int r,c;

		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			point home = new point(a,b);
			
			point[] conv = new point[N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				conv[i] = new point(a,b);
			}
			
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			point festi = new point(a,b);
			//여기까지 입력받음
			
			
			Queue<point> p = new LinkedList<>();
			
			p.add(home);  //집에서 출발
			
			boolean visited[] = new boolean[N];
			boolean end = false;  //갈수 있는지 없는지
			
			while(!p.isEmpty()) {
				
				point temp = p.poll();
				
				if(Math.abs(temp.r-festi.r)+Math.abs(temp.c-festi.c)<=1000) {  //현재 지점에서 목적지를 갈수있다면
					end = true;
					break;
				}
				
				for(int i=0;i<N;i++) {
					
					if(!visited[i] && Math.abs(temp.r-conv[i].r)+Math.abs(temp.c-conv[i].c)<=1000) {  //현재지점에서 갈수있는 편의점을 전부 찾는다
						visited[i]=true;
						p.add(conv[i]);
					}
					
				}
				
			}
			
			if(end) bw.write("happy\n");
			else bw.write("sad\n");
			
			
			
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}
