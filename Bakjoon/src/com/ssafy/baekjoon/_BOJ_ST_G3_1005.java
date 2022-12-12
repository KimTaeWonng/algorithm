package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _BOJ_ST_G3_1005 {
	
	public static class build{  //클래스 선언
		int number;  //노드번호
		int count;   //나보다 키작은 애들 수
		int time;
		List<Integer> arr = new ArrayList<>();  //나보다 키큰 애들의 배열
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			build[] building = new build[N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				building[i] = new build();
				building[i].number=i;
				building[i].time = Integer.parseInt(st.nextToken());  //각 건물의 건설시간 
			}
			
			for(int i=0;i<K;i++) {
				st= new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				building[a].arr.add(b);
				building[b].count++;
			}
			//입력 받아서 그래프 연결 처리하기
			
			
			Queue<build> q = new LinkedList<>();
			int[] maxtime = new int[N+1]; //최장시간을 기준으로 판단함.
			
			for(int i=1;i<=N;i++) {
				maxtime[i] = building[i].time;  //일단 자기 건물 시간만
				
				if(building[i].count==0) {  //첫번째 건물 큐에넣기
					q.add(building[i]); 
				}
			}
			
			while(!q.isEmpty()) {
				build temp = q.poll();	
				
				for(int i=0;i<temp.arr.size();i++) {
					int a = temp.arr.get(i);
					maxtime[a] = Math.max(maxtime[a], maxtime[temp.number]+building[a].time);  //최장 시간를 갱신
					building[a].count--; //job finished
					
					if(building[a].count==0) {  //선행 건물 다 건설했으면 큐에 넣기
						q.add(building[a]);
					}
				}
			}
			
			int ans = Integer.parseInt(br.readLine());  //구할 건물 번호
			
			System.out.println(maxtime[ans]);
		}

	}

}
