package com.ssafy.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S4_10610_30 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int arr[] = new int[10];
		
		String[] temp = br.readLine().split("");
		
		int check=0;
		
		for(int i=0;i<temp.length;i++) {
			arr[Integer.parseInt(temp[i])]++;
			
			check +=Integer.parseInt(temp[i]);
		}
		
		if(check%3!=0 || arr[0]==0) {
			System.out.println(-1);
		}else {
			StringBuilder sb = new StringBuilder();
			int cnt=0;
			while(cnt!=temp.length) {
				
				if(arr[9]!=0) {
					sb.append(9);
					arr[9]--;
					cnt++;
					continue;
				}
				if(arr[8]!=0) {
					sb.append(8);
					arr[8]--;
					cnt++;
					continue;
				}
				if(arr[7]!=0) {
					sb.append(7);
					arr[7]--;
					cnt++;
					continue;
				}
				if(arr[6]!=0) {
					sb.append(6);
					arr[6]--;
					cnt++;
					continue;
				}
				if(arr[5]!=0) {
					sb.append(5);
					arr[5]--;
					cnt++;
					continue;
				}
				if(arr[4]!=0) {
					sb.append(4);
					arr[4]--;
					cnt++;
					continue;
				}
				if(arr[3]!=0) {
					sb.append(3);
					arr[3]--;
					cnt++;
					continue;
				}
				if(arr[2]!=0) {
					sb.append(2);
					arr[2]--;
					cnt++;
					continue;
				}
				if(arr[1]!=0) {
					sb.append(1);
					arr[1]--;
					cnt++;
					continue;
				}
				if(arr[0]!=0) {
					sb.append(0);
					arr[0]--;
					cnt++;
					continue;
				}
				
			}
			
			System.out.println(sb);
			
		}
		

	}

}
