package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_G5_1038_감소하는수 {
	
	static ArrayList<Long> arr = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long num=9;
		boolean noSearch = false;
		boolean justNum = false;
		
			if(N<=9) { //한자리수는 그 수 자체가 감소하는 수
				justNum=true;				
			}
			else if(N>=1023) { //이 이상은 -1
				noSearch=true;
			}else {
				for(int i=0;i<10;i++) {
					down(i,1);
				}
			}
			
			Collections.sort(arr);
			
			
			
			
		
		
		if(noSearch) System.out.println(-1);
		else if(justNum) System.out.println(N);
		else System.out.println(arr.get(N));

	}
	
	static void down(long num, long length) {
		if(length>10) return; // 숫자의 길이가 10을 넘어가면 어차피 감소하는수 못만듬
		
		arr.add(num);
		for(int i=0;i<num%10;i++) {
			down(num*10+i,length+1);
		}
	}

}
