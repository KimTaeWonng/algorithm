package com.ssafy.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_2141_우체국 {
	
	static class vill implements Comparable<vill>{
		long location;
		long people;
		
		public vill(long location, long people) {
			super();
			this.location = location;
			this.people = people;
		}

		@Override
		public int compareTo(vill o) {
			if(this.location==o.location) {
				return (int) (this.people-o.people);
			}else {
				return (int) (this.location-o.location);
			}
			
			
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		vill[] V = new vill[N];
		long total = 0; // 총 인구수
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			long location = Long.parseLong(st.nextToken());
			long people = Long.parseLong(st.nextToken());
			
			V[i] = new vill(location, people);
			
			total +=people;
		}
		
		Arrays.sort(V);
		
		long min = 0;
		long ans = 0;
		
		for(int i=0;i<N;i++) {
			vill temp = V[i];
			
			min += temp.people;
			if(min>=(total+1)/2) {
				ans = temp.location;
				break;
			}
		}
		
		System.out.println(ans);

	}

}
