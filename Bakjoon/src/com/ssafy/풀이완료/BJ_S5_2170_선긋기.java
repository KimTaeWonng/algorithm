package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_S5_2170_선긋기 {
	
	static class line implements Comparable<line>{
		int x;
		int y;
		
		public line(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(line o) {	  //시작 부분이 짧은 순서대로 정렬
			if(this.x==o.x)
				return this.y-o.y;
			else 
				return this.x-o.x;
		}

		@Override
		public String toString() {
			return "line [x=" + x + ", y=" + y + "]";
		}
		
		
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		line[] L = new line[N];
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			L[i] = new line(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}		
		//여기까지 입력받기
		Arrays.sort(L);
		//System.out.println(L[0].toString());
		
		int left=0;
		int right=0;
		int distance=0;
		
		for(int i=0;i<N;i++) {
			if(i==0) {  //첫 선분은 그냥 받아온다
				left = L[i].x;
				right = L[i].y;
			}else {
				if(right<L[i].x) {  //만약 현재 그은 선분보다 더 오른쪽에  시작점이 주어지면
					distance+=right-left;  //지금까지 그었던 거리를 구하고
					left = L[i].x;
					right = L[i].y;			//다음 선분으로 이동
					
				}else if(right<L[i].y) {    //중첩구간에서 오른쪽만 길어질경우
					right = L[i].y;
				}
			}
		}
		//System.out.println(left+" "+right);
		
		distance+=right-left;  //다 구한뒤 계산되지 않은 마지막 선의 거리까지 더해주면
		
		System.out.println(distance);

	}

}
