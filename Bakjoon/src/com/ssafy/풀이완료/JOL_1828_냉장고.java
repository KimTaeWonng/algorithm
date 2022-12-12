package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JOL_1828_냉장고 {
	
	static class Temp{    //객체 생성
		int min;
		int max;
		
		public Temp(int min, int max) {
			this.min = min;
			this.max = max;
		}

		@Override
		public String toString() {
			return "Temp [min=" + min + ", max=" + max + "]";
		}
				
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N =Integer.parseInt(br.readLine());
		Temp[] temp = new Temp[N];
		
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			temp[n] = new Temp(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(temp,new Comparator<Temp>() {

			@Override
			public int compare(Temp o1, Temp o2) {
				// TODO Auto-generated method stub
				if(o1.max==o2.max) {
					return o1.min - o2.min;
				}else {
					return o1.max - o2.max;
				}
			}
		});
		
		
		//System.out.println(Arrays.toString(temp));
		int rifereirateorr =1; // 냉장고
		int MAX=temp[0].max;
		for(int i=1;i<N;i++) {
			if(MAX<temp[i].min) {
				rifereirateorr++;
				MAX=temp[i].max;
			}
		}
		
		System.out.println(rifereirateorr);


	}

}
