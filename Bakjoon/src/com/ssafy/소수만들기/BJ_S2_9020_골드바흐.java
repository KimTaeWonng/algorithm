package com.ssafy.소수만들기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S2_9020_골드바흐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int A = N/2;
			int B = N/2;
			
			if(N==4) {
				bw.write(2+" "+2+"\n");
			}
			
			else if(A%2==0) {  //짝수
				int cnt=1;
				int temp=0,temp2=0;
				while(A>cnt) {
					temp  = A-cnt;
					temp2 = B+cnt;
					
					if(isPrime(temp) && isPrime(temp2)) {
						break;
					}
					
					cnt+=2;
				}
				
				bw.write(temp+" "+temp2+"\n");
			}else {
				int cnt=2;
				int temp=A,temp2=B;
				while(A>1) {
					
					if(isPrime(temp) && isPrime(temp2)) {
						break;
					}
					
					temp  = A-cnt;
					temp2 = B+cnt;
					
					cnt+=2;
				}
				
				bw.write(temp+" "+temp2+"\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		

	}

	static boolean isPrime(int N) {
		if(N==1) {
			return false;
		}
		if(N==2) {
			return true;
		}
		
		if(N%2==0) {
			return false;
		}
		
		for(int i=3;i<=Math.sqrt(N);i+=2) {
			if(N%i==0) {
				return false;
			}
		}
		return true;
	}
}
