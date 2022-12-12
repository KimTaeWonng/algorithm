package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _BOJ_DC_G5_3020 {
	
	//석순 bottom 종유석 top
	//종유석은 H-높이로 구해서 그 수 보다 작으면 안부수는거
	//다 해놓고 두 리스트 정렬한 후 이분법으로 구함.
	
	
	//위에꺼 말고 걍 하는게 더 편할듯
	
	static int N,H;
	static int[] top,bottom;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		top = new int[H+1];    //석순하고 종유석 높이들 카운트 할거임
		bottom = new int[H+1];
		
		for(int i=0;i<N;i++) {
			if(i%2==0) {
				bottom[Integer.parseInt(br.readLine())]++;   //석순의 높이
			}else {
				top[Integer.parseInt(br.readLine())]++;    //종유석 길이 
			}
		}
		
		for(int i=1;i<=H;i++) {
			if(i==1) {   //1일땐 같은 높이의 돌 개수가 곧 부순 개수
				continue;
			}
			// 1 2 3 4 5
			bottom[i]+=bottom[i-1];  //어차피 내 밑에건 다 부서져
			top[i]+=top[i-1];	//얘도
		}
		
		int min = Integer.MAX_VALUE; //최소값
		int cnt = 0;				 //최소값인 개수
		
		for(int i=1;i<=H;i++) {
			
			int breakB=bottom[H]-bottom[i-1];	//아래꺼 깬 개수
			int breakT=top[H]-top[H-i];			//위에꺼 깬 개수
			
			if(min>breakB+breakT) {  //새로운 최소값을 찾았으면 다시 초기화
				min = breakB+breakT;
				cnt=1;
			}else if(min==breakB+breakT) {  //현재 최소값이랑 같은놈
				cnt++;
			}
		}
		
		bw.write(min+" "+cnt);
		
		bw.flush();
		br.close();
		bw.close();
		
		

	}

}
