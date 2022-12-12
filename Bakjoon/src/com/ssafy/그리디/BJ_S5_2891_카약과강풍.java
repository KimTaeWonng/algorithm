package com.ssafy.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S5_2891_카약과강풍 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		
		Arrays.fill(arr, 1);
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<S;i++) {
			arr[Integer.parseInt(st.nextToken())]--;
		} //손상쓰
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			arr[Integer.parseInt(st.nextToken())]++;
		} //여분쓰
		
		for(int i=1;i<=N;i++) {
			if(i==1) {
				if(arr[i]==2 && arr[i+1]==0) {
					arr[i]--;
					arr[i+1]++;
				}
			}else if(i==N) {
				if(arr[i]==2 && arr[i-1]==0) {
					arr[i]--;
					arr[i-1]++;
				}
			}else {
				if(arr[i]==2 && arr[i-1]==0) {
					arr[i]--;
					arr[i-1]++;
				}else if(arr[i]==2 && arr[i+1]==0){
					arr[i]--;
					arr[i+1]++;
				}
			}
		}
		
		int cnt=0;
		for(int i=1;i<=N;i++) {
			if(arr[i]==0) {
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}
