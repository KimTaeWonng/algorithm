package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_G3_2457_공주님의정원 {
	
	static class flower implements Comparable<flower>{
		int start_M;
		int start_D;
		int end_M;
		int end_D;
		
		
		public flower(int start_M, int start_D, int end_M, int end_D) {
			this.start_M = start_M;
			this.start_D = start_D;
			this.end_M = end_M;
			this.end_D = end_D;
		}


		@Override
		public int compareTo(flower o) {
			if(this.end_M==o.end_M && this.end_D==o.end_D) {
				if(this.start_M==o.start_M) {
					return (this.start_D-o.start_D);
				}else {
					return (this.start_M-o.start_M);
				}
			}else {
				if(this.end_M==o.end_M) {
					return (this.end_D-o.end_D)*-1;
				}else {
					return (this.end_M-o.end_M)*-1;
				}
			}
		}


		@Override
		public String toString() {
			return "flower [start_M=" + start_M + ", start_D=" + start_D + ", end_M=" + end_M + ", end_D=" + end_D
					+ "]";
		}	
		
		
		
	}
	
	//	3월1일 전에 가장 오래 피는 꽃을 선택
	//	그 이후엔 그 꽃보다 빨리 피면서, 가장 오래 피는 꽃을 선택
	//	선택한 꽃이 11월 30일보다 크면 종료

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<flower> beforeMarch = new ArrayList<>();
		ArrayList<flower> afterMarch = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			if(a<3 || (a==3&&b==1)) {
				beforeMarch.add(new flower(a,b,c,d));   //3월 전에 피는 꽃은 여기에
			}else{
				afterMarch.add(new flower(a,b,c,d));	//그 이후론 여기에
			}
		}
		//여기까지 입력 받는다
		
		Collections.sort(beforeMarch);    //정렬 기준 - 꽃이 지는날이 높은순으로 정렬한다 (피는 날은 상관없음)
		Collections.sort(afterMarch);
		
		//System.out.println(beforeMarch);
		//System.out.println(afterMarch);
		
		int cnt=0;
		int lastM=0,lastD=0;
		boolean no = false;  // 조건에 부합 불가능
		boolean yes = false; // 3월1일~11월30일까지 꽃이 핌
		if(!beforeMarch.isEmpty()) {
			lastM=beforeMarch.get(0).end_M;
			lastD=beforeMarch.get(0).end_D;
			cnt++;
		}
		
		if(cnt==0) {  //3월1일 전에 피는 꽃이 없다.
			no = true;
		}
		
		if(lastM==12) {    //3월 전에 피는꽃이 12월까지 살아있는 경우
			yes=true;
		}
		if(afterMarch.isEmpty()&& !yes) {   // 3월1일 이후 피는 꽃이 하나도없는 경우
			no = true;
		}
		int size = afterMarch.size();
		while(!yes && size!=0) {
			if(no) break;			
			for(int i=0;i<size;i++) {
			
					if(afterMarch.get(i).start_M<lastM || (afterMarch.get(i).start_M==lastM && afterMarch.get(i).start_D<=lastD)) {  //조건에 부합하는 경우(지는날보다 빨리 필경우)
						cnt++;
						lastM = afterMarch.get(i).end_M; 
						lastD = afterMarch.get(i).end_D;
						size = i;   // 현재 i보다 뒤에있는 것들은 지는날이 i보다 빠르므로 볼 필요없다.
						if(lastM==12) {
							yes = true;						
						}
						break;
					}
			
				if(i==size-1) { //마지막 꽃을 봤는데도 연속으로 심을 수 없는 경우
					no = true;
				}

			}
		}
		
		if(!yes) System.out.println(0);  
		else System.out.println(cnt);
		

	}

}
