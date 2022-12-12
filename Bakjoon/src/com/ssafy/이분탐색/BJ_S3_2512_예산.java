package com.ssafy.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_2512_예산 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int money[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		int total = 0;
		for(int i=0;i<N;i++) {
			money[i] = Integer.parseInt(st.nextToken());
			total +=money[i];
		}
		
		Arrays.sort(money);
		
		int limit = Integer.parseInt(br.readLine());
		
		int ans = 0;
		
		if(total<=limit) {
			System.out.println(money[N-1]);
		}else {
			int left = 0;
			int right = money[N-1];
			while(left<=right) {
				int mid = (left + right) /2; //한계값
				int sum = 0;
				
				for(int m : money) {
					if(m>=mid) sum += mid;
					else sum+=m;
				}
				
				if(sum>limit) {
					right = mid-1;
				}else {
					left = mid+1;
					ans = Math.max(ans, mid);
				}
			}

			System.out.println(ans);
		}
		

	}

}
