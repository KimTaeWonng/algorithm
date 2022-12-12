package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AB {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		boolean imp = false;
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(arr[i]>1440) {
				imp = true;
				break;
			}
		}
		
		int ans = 0;
		
		if(!imp) {
			Arrays.sort(arr);
			
			int left = 0;
			int right = N-1;
			
			while(left<right) {
				if(arr[left]==0) {
					left++;
					continue;
				}
				
				if(arr[right]==0) {
					right--;
					continue;
				}
				
				if(right-1>=0 && arr[right]==arr[right-1]) {
					ans+= arr[right];
					arr[right]=0;
					arr[right-1]=0;
					continue;
				}
				
				arr[left]--;
				arr[right]--;
				ans++;
			}
			
			for(int i=0;i<N;i++) {
				if(arr[i]!=0) {
					ans+=arr[i];
					break;
				}
			}
		}
		
		if(imp || ans>1440) System.out.println(-1);
		else System.out.println(ans);
		

	}

}
