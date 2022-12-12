package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_D4_18186_라면사기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N];
		
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		long cnt=0; //가장 큰값이 10^6의 3승 int형으로 표현 불가
		
		if(B<=C) {   //묶어 사는게 더 비싸거나 할인이 없으면 굳이 살 필요가 없다.
			C=B;
		}
		
			for(int i=0;i<N-2;i++) {
				if(arr[i]!=0 && arr[i+1]!=0 && arr[i+2]!=0) {   //세 공장에서 하나씩 살 수 있을때
					if(arr[i+1]>arr[i+2]) {  // 반례 부분 (앞에 2개를 먼저 산 뒤에 3개를 사야함) 
						long Min = Math.min(arr[i], arr[i+1]-arr[i+2]);
						arr[i]-=Min;
						arr[i+1]-=Min;
						cnt+=(long)(B+C)*Min;
						i-=1;
						continue;
					}
					
					long Min = Math.min(arr[i], arr[i+1]); //아니면 걍 3개씩 사버려
					Min = Math.min(Min,arr[i+2]);
					arr[i]-=Min;
					arr[i+1]-=Min;
					arr[i+2]-=Min;
					cnt+=(long)(B+2*C)*Min;
				}
			}
			
			for(int i=0;i<N-1;i++) {	//그다음 2개씩 사버려
				if(arr[i]!=0 && arr[i+1]!=0) {
					long Min= Math.min(arr[i], arr[i+1]);
					arr[i]-=Min;
					arr[i+1]-=Min;
					cnt+=(long)(B+C)*Min;					
				}
			}
			
			for(int i=0;i<N;i++) {
				if(arr[i]!=0) {
					cnt+=B*arr[i];
					arr[i]=0;
				}
			}
		
		
		
		System.out.println(cnt);
		


	}

}
