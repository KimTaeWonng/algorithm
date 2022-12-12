package com.ssafy.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _BOJ_TP_G5_2096 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		
		int max[] = new int[3];
		int min[] = new int[3];
		
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(i==0) {  //처음은 수를 그대로 집어넣음
				max[0]=min[0]=a;
				max[1]=min[1]=b;
				max[2]=min[2]=c;
			}
			
			else {
				int temp1 = max[0],temp2 = max[2]; //수가 달라지니 미리 선언
				int temp3 = min[0],temp4 = min[2];
				max[0] = Math.max(max[0], max[1])+a;
				min[0] = Math.min(min[0], min[1])+a;
				
				max[2] = Math.max(max[2], max[1])+c;
				min[2] = Math.min(min[2], min[1])+c;
				
				max[1] = Math.max(max[1], Math.max(temp1, temp2))+b;
				min[1] = Math.min(min[1], Math.min(temp3, temp4))+b;
								
			}
			
		}
		
		System.out.print(Math.max(max[0], Math.max(max[1], max[2]))+" ");
		System.out.print(Math.min(min[0], Math.min(min[1], min[2]))+" ");

	}

}
