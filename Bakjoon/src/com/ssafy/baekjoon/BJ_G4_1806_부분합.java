package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G4_1806_부분합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		
		long sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum+=arr[i];
		}
		
		boolean cant =false;
		
		if(sum<S) {  //모든 수를 더해도 S보다 작으면 할 필요없음 어차피 못함
			cant = true;
		}
		
		int left=0;
		int right=0;
		
		sum = arr[0];
		int min = 100001;
		
		if(!cant) {
			int leng =0;
			while(true) {
				
				if(sum>=S) {
					if(left==right) {  //하나로 만들 수 있으면 더 볼필요 없음
						min = 1;
						break;
					}else {
						leng = right-left+1;  //현재 길이를 구하고
						min = Math.min(min, leng); //최소값 비교
						sum-=arr[left];  
						left++;   //그 후 길이 줄여줌
						
					}
				}else {
					if(right==N-1) break; //마지막인데 S보다 작으면 걍 나와
					
					right++;
					sum+=arr[right]; //아니면 길이 늘려줌
				}
			
			}
			

			
			System.out.println(min);
		}else {
			System.out.println(0);
		}
		
		

	}

}
