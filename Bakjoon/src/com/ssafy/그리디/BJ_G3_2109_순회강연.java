package com.ssafy.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_G3_2109_순회강연 {
	
	static class appo implements Comparable<appo>{
		int money;
		int day;
		
		public appo(int money, int day) {
			super();
			this.money = money;
			this.day = day;
		}

		@Override
		public int compareTo(appo o) {
			if(this.money==o.money) {
				return this.day-o.day;
				
			}else {
				return o.money-this.money;
			}
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		appo[] ap = new appo[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			ap[i] = new appo(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(ap);
		

		
		int cnt=0;
		int ans=0;
		boolean full[] = new boolean[10001];
		for(int i=0;i<N;i++) {
			int m = ap[i].money;
			int d = ap[i].day;
			
			for(int j=d-1;j>=0;j--) {
				if(!full[j]) {
					full[j]=true;
					ans+=m;
					break;
				}
			}
		}
		
		System.out.println(ans);

	}

}
