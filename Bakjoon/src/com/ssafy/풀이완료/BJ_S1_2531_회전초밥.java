package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_S1_2531_회전초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N,D,K,C;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+K-1];  // 앞에 초밥 테이블
		int[] krr = new int[K-1];    // 테이블 원형으로 만들어줄 배열
		int[] drr = new int[D+1];    // 내가 먹은거
		
		for(int i=0;i<N+K-1;i++) {  //N+K-1만큼 만들어줌 (회전 초밥 모양으로)
			if(i<K-1) {
				int temp = Integer.parseInt(br.readLine());
				arr[i] = temp;
				krr[i] = temp;
			}
			else if(i<N) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			else {
				arr[i] = krr[i-N];
			}
		}
		
		//System.out.println(Arrays.toString(arr));
		
		int count = 0;
		for(int i=0;i<K;i++) {
			if(drr[arr[i]]==0) {  //일단 맨앞에 K개 먹어봐
				count++;
			}
			
			drr[arr[i]]++;
		}
		int max = count;
		
		for(int i=1; i<N; i++) {
			if(drr[C]==0) {
				max = Math.max(max, count+1);    //추가쿠폰 찬스
			}else {
				max = Math.max(max, count);      //써봤자 똑같은 맛
			}
			
			int last = i+K-1;
			if(drr[arr[last]]==0) {    //다음 접시 새로운 맛이면 카운트 늘려줌
				count++;
			}
			drr[arr[last]]++;
			
			drr[arr[i-1]]--;
			if(drr[arr[i-1]]==0) { //접시 빼기 이전에 한번밖에 안먹었던거면 카운트 줄여줌 
				count--;
			}
			
			
		}
		
		
		System.out.println(max);

	}

}
