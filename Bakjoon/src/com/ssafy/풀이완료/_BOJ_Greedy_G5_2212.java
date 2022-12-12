package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _BOJ_Greedy_G5_2212 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[] city = new int[N];
		Integer[] distance = new Integer[N-1];
				
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(city);   // 센서의 좌표상 위치를 오름차순으로 정렬
		
		
		for(int i=0;i<N-1;i++) {
			distance[i] = city[i+1]-city[i];   //맞닿은 두 센서 간의 거리를 배열에 저장
		}
		
		Arrays.sort(distance,Collections.reverseOrder());   //이 거리는 내림차순으로 저장 (최소값을 위해 가장 큰것 부터 빼야하기 때문)
		
		if(K>N) {  //기지국이 센서보다 많을경우
			K=N;
		}
		
		int k = K-1;
		int sum=city[N-1]-city[0];  //최대값은 가장 왼쪽, 가장 오른쪽 두 센서간의 거리
		int i=0;
		while(k!=0) {
			sum-=distance[i++];  //1개의 기지국으로 두 센서간의 거리를 0으로 만들어줄수 있다. (가장 먼 distance부터 0으로만들어줌)
			k--;
		}
		
		System.out.println(sum);
		
		
		
		
//		int left  = city[0];
//		int right = city[N-1];
//		int max=0;
//		int maxid=0;
//		
//		for(int i=0;i<K;i++) {			
//			if(i==0) {
//				for(int j=0;j<N;j++) {					
//					distance[j] = Math.min(distance[j], Math.abs(city[j]-city[N/2]));
//					if(max<distance[j]) {
//						max=distance[j];
//						maxid=j;
//					}
//				}
//				
//			}else {
//				distance[maxid]=0;
//				int temp=maxid;
//				max=0;
//				for(int j=0;j<N;j++) {
//					distance[j] = Math.min(distance[j], Math.abs(city[j]-city[temp]));
//					if(max<distance[j]) {
//						max=distance[j];
//						maxid=j;
//					}
//				}
//			}
//		}
//		System.out.println(Arrays.toString(city));
//		System.out.println(Arrays.toString(distance));
//		
//		long cnt=0;
//		int MAX=0;
//		for(int i=0;i<N;i++) {
//			if(distance[i]==0) {
//				cnt+=MAX;
//				MAX=0;
//			}else {
//				MAX = Math.max(MAX, distance[i]);
//			}
//			
//			if(i==N-1 && distance[i]!=0) {
//				cnt+=MAX;
//			}
//		}
//		
//		System.out.println(cnt);
//
	}

}
