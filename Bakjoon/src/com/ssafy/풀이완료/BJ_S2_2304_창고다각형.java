package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_2304_창고다각형 {
	
	static class Building implements Comparable<Building>{
		int located;
		int height;
		
		public Building(int located, int height) {
			this.located = located;
			this.height = height;
		}

		@Override
		public int compareTo(Building o) {
			return this.located - o.located;
		}

		@Override
		public String toString() {
			return "Building [located=" + located + ", height=" + height + "]";
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Building[] b = new Building[N];
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			b[i] = new Building(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(b);   //위치 순으로 정렬
		
		//for(int i=0;i<N;i++) {
		//	System.out.println(b[i]);
		//}
		
		int MAX = 0;
		for(int i=0;i<N;i++) {
			MAX = Math.max(MAX, b[i].height);
		}
		
		int sum=0;
		int maxLeft=0,maxRight=0;
		Building temp=null;
		for(int i=0;i<N;i++) {    //앞에서부터 가장 높은 건물까지
			if(i==0) {
				temp=b[i];
			}else {
				if(temp.height<b[i].height) {
					sum+=temp.height * (b[i].located - temp.located);
					temp = b[i];
					
				}
			}
			
			if(temp.height==MAX) {
				maxLeft = temp.located;
				break;
			}
		}
		
		for(int i=N-1;i>=0;i--) {  // 뒤에서부터 가장 높은 건물까지
			if(i==N-1) {
				temp=b[i];
			}else {
				if(temp.height<b[i].height) {
					sum+=temp.height * (temp.located - b[i].located);
					temp = b[i];
					
				}
			}
			
			if(temp.height==MAX) {
				maxRight = temp.located;
				break;
			}
		}
		
		sum+= MAX * (maxRight - maxLeft + 1);    // 가장 높은 건물이 2개 이상인경우 왼쪽과 오른쪽 좌표 차이 +1만큼 면적 추가
		
		System.out.println(sum);

	}

}
