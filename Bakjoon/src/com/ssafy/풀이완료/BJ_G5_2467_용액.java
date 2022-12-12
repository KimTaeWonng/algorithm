package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G5_2467_용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int liquid[] = new int[N];
		
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			liquid[i]= Integer.parseInt(st.nextToken());
		}
		
		int max =0;
		int L=0,R=0;
		if(liquid[0]>=0) {  //모든수가 양수
			L=0;
			R=1;
			
		}else if(liquid[N-1]<=0) {  //모든수가 음수
			L=N-2;
			R=N-1;
			
		}else {
			int left = 0;
			int right = N-1;
			
			max = Integer.MAX_VALUE;
			
			while(left<right) {
				int temp = liquid[left]+liquid[right];
				if(Math.abs(temp)<max) {
					L=left;
					R=right;
					max=Math.abs(temp);
				}
				
				if(temp>0) {   //0보다 크면 줄여줘야하므로 오른쪽을 1칸 줄인다  (오름차순)
					right--;
				}else {
					left++;    //0보다 작으면 늘려줘야하므로 왼쪽을 1칸 늘린다
				}
				
			}
		}
		
		System.out.println(liquid[L]+" "+liquid[R]);

	}

}
