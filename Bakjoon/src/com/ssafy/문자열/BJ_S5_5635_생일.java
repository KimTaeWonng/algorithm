package com.ssafy.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_S5_5635_생일 {
	
	static class student implements Comparable<student>{
		String name;
		int day;
		int month;
		int year;
		public student(String name, int day, int month, int year) {
			super();
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}
			
		@Override
		public int compareTo(student o) {
			if(this.year==o.year) {
				if(this.month==o.month) {
					return this.day-o.day;
				}
				
				return this.month-o.month;
			}
			return this.year-o.year;
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		student[] s = new student[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			
			s[i] = new student(name, day, month, year);
			
		}
		
		Arrays.sort(s);
		
		System.out.println(s[N-1].name);
		System.out.println(s[0].name);

	}

}
