package com.ssafy.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_1253_좋다 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = 0;
		int cnt = 0;
		for(int i=0;i<N;i++) {
			int temp = arr[i];
			int l = 0;
			int r = N-1;
			
			
			
			while(l<r) {
				//다른 수에 어떤 수가 포함되지 않아야 한다
				if(l==i) {
					l++;
					continue;
				}
				//다른 수에 어떤 수가 포함되지 않아야 한다
				if(r==i) {
					r--;
					continue;
				}
				left = arr[l];
				right = arr[r];
				int sum = left + right;
				
				if(sum==temp) {
					cnt++;
					break;
				}
				
				if(sum>temp) {
					r--;
				}
				
				if(sum<temp) {
					l++;
				}				
			}
		}
		
		System.out.println(cnt);

	}

}
