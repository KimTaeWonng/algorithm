package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S5_10814_나이순정렬 {
	
	static class Person implements Comparable<Person>{
		int age;
		String name;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			return (this.age-o.age);
		}
		
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Person[] p = new Person[N];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = new Person(Integer.parseInt(st.nextToken()),st.nextToken());			
		}
		
		Arrays.sort(p);
		
		for(int i=0;i<N;i++) {
			System.out.println(p[i].age + " "+p[i].name);
		}

	}

}
