package com.ssafy.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _BOJ_TP_G3_1644 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt=0;
		ArrayList<Integer> prime = new ArrayList<>();
		
		prime.add(2);
		
		for(int i=3;i<=N;i++) {
			if(isPrime(i)) {
				prime.add(i);
			}
		}
		
		
		//System.out.println(prime.toString());
		int start=0,end=0;
		int sum=0;
		while(true) {
			
			if(sum==N) {  //맞으면
				cnt++;
				sum-=prime.get(start);
				start++;
				
			}
			
			else if(sum>N || end==prime.size()) {  //N보다 커지면 or 배열의 끝
				sum-=prime.get(start);
				start++;
			}else if(sum<N) { //작으면
				sum+=prime.get(end);
				end++;
			}
			
			if(start==prime.size()) { //종료 조건
				break;
			}
			
			//System.out.println(start+" "+end+" "+sum);
			
			
			
			
		}
		System.out.println(cnt);

	}
	
	static boolean isPrime(int num) { // 소수판정함수
		if(num%2==0 && num!=2) {
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
