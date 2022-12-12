package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_2470_두용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] liquid = new int[n]; 
		int answer1=0,answer2=0;
		
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			liquid[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(liquid);
		
		if(liquid[0]>0) {        //모두 산성용액
			answer1= liquid[0];
			answer2= liquid[1];
		}
		else if(liquid[n-1]<0) { //모두 알칼리성 용액
			answer1=liquid[n-2];
			answer2=liquid[n-1];
		}
		else {
			int left= 0;
			int right=n-1;
			int max = Integer.MAX_VALUE;
			
			while(left<right) {
				int temp = liquid[left]+liquid[right];
				int abstemp = Math.abs(temp);
				if(abstemp<max) {
					answer1 = liquid[left];
					answer2 = liquid[right];
					max =abstemp;			
				}
								
				if(temp>0) {
					right--;
				}
				else {
					left++;
				}				
			}			
		}
		

		bw.write(answer1+" "+answer2);
		
		bw.flush();
		bw.close();
		br.close();
		

	}

}
