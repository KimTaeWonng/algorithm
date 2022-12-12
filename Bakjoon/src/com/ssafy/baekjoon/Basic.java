package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Basic {

	//입력한 수의 자리수 구하기 N은 최대 9자리수인 자연수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] length = {1,2,3,4,5,6,7,8,9};
		
//		for(int i=0;i<length.length;i++) {    Collection 사용 
//			if(N<Math.pow(10, length[i])) {
//				System.out.println(i+1);
//				break;
//			}
//		}
		
		int cnt=0;      //Switch 사용
		
		while(N!=0) {
			N/=10;
			cnt++;
		}
		
		switch(cnt) {
		case 1:
			System.out.println(1);
			break;
		case 2:
			System.out.println(2);
			break;
		case 3:
			System.out.println(3);
			break;
		case 4:
			System.out.println(4);
			break;
		case 5:
			System.out.println(5);
			break;
		case 6:
			System.out.println(6);
			break;
		case 7:
			System.out.println(7);
			break;
		case 8:
			System.out.println(8);
			break;
		case 9:
			System.out.println(9);
			break;			
		}
		
		
		
		

	}

}
