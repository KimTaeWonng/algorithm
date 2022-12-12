package com.ssafy.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_S5_8979_올림픽 {
	
	static class Country implements Comparable<Country>{
		int number;
		int gold;
		int silver;
		int bronze;
		int rank;
		
		public Country(int number, int gold, int silver, int bronze, int rank) {
			super();
			this.number = number;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
			this.rank = rank;
		}

		

		@Override
		public int compareTo(Country o) {
			if(this.gold==o.gold) {
	            if(this.silver==o.silver) {
	                return o.bronze-this.bronze;
	            }
	            else {
	                return o.silver-this.silver;
	            }
	        }
	        else {
	            return o.gold-this.gold;
	        }
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		ArrayList<Country> arl = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			
			arl.add(new Country(number, gold, silver, bronze, 0));
			
		}
		Collections.sort(arl);
		
		arl.get(0).rank=1;
		
		for(int i=1;i<arl.size();i++) {
			Country temp = arl.get(i-1);
			int g = temp.gold;
			int s = temp.silver;
			int b = temp.bronze;
			int r = temp.rank;
			
			Country now = arl.get(i);
			
			if(now.gold==g && now.silver==s && now.bronze==b) {
				now.rank=r;
			}else {
				now.rank=i+1;
			}
			
		}
		
		for(int i=0;i<arl.size();i++) {
			if(arl.get(i).number==M) {
				System.out.println(arl.get(i).rank);
				break;
			}
		}
		

	}

}
