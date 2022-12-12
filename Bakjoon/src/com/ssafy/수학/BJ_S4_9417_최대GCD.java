package com.ssafy.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S4_9417_최대GCD {
	static int[] number,arr;
	static int N,max;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N =Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			
			String[] str = br.readLine().split(" ");
			number = new int[str.length];
			visited = new boolean[str.length];
			arr = new int[2];
			max=0;
			
			for(int j=0;j<str.length;j++) {
				number[j] = Integer.parseInt(str[j]);
			}
			
			comb(0,0);
			System.out.println(max);
		}

	}
	
	static void comb(int start, int cnt) {
		if(cnt==2) {
			max = Math.max(max, gcd(arr[0],arr[1]));
			return;
		}
		
		for(int i=start;i<number.length;i++) {
			if(visited[i]) continue;
			
			visited[i]=true;
			arr[cnt] = number[i];
			comb(i+1,cnt+1);
			visited[i]=false;
		}
	}
	
	static int gcd(int a, int b) {
		if(a>=b) {
			if(a%b==0) {
				return b;
			}else {
				return gcd(b,a%b);
			}
		}else {
			if(b%a==0) {
				return a;
			}else {
				return gcd(a,b%a);
			}
		}
	}

}
