package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_3273_두수의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);   //정렬
		int left=0;
		int right=N-1;
		
		int target = Integer.parseInt(br.readLine());
		int cnt=0;
		
		//여기까지 입력받기
		
		while(left<right) {
			if(arr[left]+arr[right]==target) { //찾았으면
				left++;    //그 다음 쌍은 무조건 arr[left]보다 큰 수
				right--;   //그 다음 쌍은 무조건 arr[right]보다 작은 수
				cnt++;
				
			}else if(arr[left]+arr[right]>target) { //크면
				right--;
				
			}else {  //작으면
				left++;  
			}
		}
		
		System.out.println(cnt);

	}

}
