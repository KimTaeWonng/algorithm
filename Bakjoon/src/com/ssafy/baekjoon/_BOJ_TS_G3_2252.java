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

public class _BOJ_TS_G3_2252 {
	
	public static class jul{  //클래스 선언
		int number;  //노드번호
		int count;   //나보다 키작은 애들 수
		List<Integer> arr = new ArrayList<>();  //나보다 키큰 애들의 배열
		
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	
		int M = Integer.parseInt(st.nextToken());
		
		jul[] j = new jul[N+1];
		
		for(int i=0;i<=N;i++) {
			j[i] = new jul();  //초기화
			j[i].number=i;  //학생번호 
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			j[a].arr.add(b);   	//a학생이 b학생보다 작음을 a의 arr에 넣는다
			j[b].count++;		//b학생 기준에서 나보다 작은 학생이 인원수를 늘려준다
		}
		
		Queue<jul> q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			if(j[i].count==0) {  //정보를 토대로 가장 작은 학생 (count가 0 == 나보다 작은애가 없음)
				q.add(j[i]);
			}
		}
		
		while(!q.isEmpty()) {
			jul temp = q.poll();
			
			for(int i=0;i<temp.arr.size();i++) {  
				int a = temp.arr.get(i);  //a와 키를 쟀을때 a보다 컸던애들의 count를 전부 1씩 줄여줌
				j[a].count--;
				
				if(j[a].count==0) {  //a를 제외했을때 이제 그친구가 가장 작은 학생인 경우
					q.add(j[a]);
				}
			}
			
			bw.write(temp.number+" ");
			
			
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}
