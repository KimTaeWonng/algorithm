package com.ssafy.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_S5_2581_소수 {
	
	static int a,b,sum,min;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		a = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());
		
		for(int i=a;i<=b;i++) {
			if(isPrime(i)) {
				sum +=i;
				
				if(min==0) {
					min=i;
				}
			}
		}
		
		if(min==0) {
			System.out.println(-1);
		}else {
			System.out.println(sum+"\n"+min);
		}
		
		

	}

	static boolean isPrime(int num) {
		if(num==1) {
			return false;
		}
		if(num==2) {
			return true;
		}
		
		if(num%2==0) {
			return false;
		}
		
		
		for(int i=3;i<=Math.sqrt(num);i+=2) {
			if(num%i==0) {
				return false;
			}
		}
		
		return true;
	}

}
