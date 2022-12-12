package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 스트링안쓰고팰린드롬수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		System.out.println(isP(N));
	}
	
	static boolean isP(int num) {
		int length=0;
		
		int temp = num;
		
		while(temp>10) {
			temp/=10;
			length++;
		}		
		
		if(length==1) {
			if(num%10!=num/10) {
				return false;
			}
			return true;
		}
		
		else{for(int i=1;i<=length/2;i++) {
			double a=num%(int)Math.pow(10, i)/(int)Math.pow(10, i-1);
			double b=(num/(int)Math.pow(10,length-i+1))%10;
			if(a != b) {
				return false;
			}
		}
		
		return true;
		}
		
	}
		

}
