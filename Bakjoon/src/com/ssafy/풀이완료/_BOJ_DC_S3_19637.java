package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _BOJ_DC_S3_19637 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		
		String[] str = new String[N];
		int[] n = new int[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			str[i] = st.nextToken();
			n[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			int power = Integer.parseInt(br.readLine());
			int left = 0;
			int right = N-1;
			
			while(left<=right) {
				int mid = (left+right)/2;
								
				if(power<=n[left]) {   //왼쪽보다 작으면 무조건 얘다
					bw.write(str[left]+"\n");
					break;
				}
				
				
				if(power<=n[mid]) {
					right=mid-1;
				}
				else if(power>n[mid]) {
					left=mid+1;
				}
				
				if(power>n[left] && power<=n[left+1]) {   //이거도
					bw.write(str[left+1]+"\n");
					break;
				}else if(power<=n[right] && power>n[right-1]) {  //무조건임
					bw.write(str[right]+"\n");
					break;
				}
				
				
			}
		}
		bw.flush();
		bw.close();
		br.close();
		
		
		
		
		
	}

}
