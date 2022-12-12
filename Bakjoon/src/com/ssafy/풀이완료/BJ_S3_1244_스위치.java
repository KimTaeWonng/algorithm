package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_1244_스위치 {
	
	static class Student{
		int gender;
		int number;
		
		
		public Student(int gender, int number) {
			this.gender = gender;
			this.number = number;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] Switch = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			Switch[i]=Integer.parseInt(st.nextToken());
		}
		
		int S = Integer.parseInt(br.readLine());
		Student[] student = new Student[S]; 
		
		for(int i=0;i<S;i++) {
			st = new StringTokenizer(br.readLine());
			student[i] = new Student(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			
			switch(student[i].gender) {
			case 1:
				int k=1;
				while(student[i].number*k<=n) {
					if(Switch[student[i].number*k]==1) Switch[student[i].number*k]=0;
					else if(Switch[student[i].number*k]==0) Switch[student[i].number*k]=1;
					k++;
				}
				break;
				
			case 2:
				k=0;
				int num = student[i].number;
				while(true) {
					if(Switch[num-k]==Switch[num+k]) {
						if(num-k>1 && num+k<n)    //n==8
							k++;
						else break;
					}else {
						k--;
						break;
					}
				}
				
				for(int j=num-k;j<=num+k;j++) {
					if(Switch[j]==1) Switch[j]=0;
					else Switch[j]=1;
				}
				break;
			}
			
			//System.out.println(Arrays.toString(Switch));
			
		}
		int line=0;
		for(int i=1;i<=n;i++) {
			
			if(line==20) {
				System.out.println();
				line=0;
			}
			System.out.print(Switch[i]+" ");
			line++;
		}
			

	}

}
