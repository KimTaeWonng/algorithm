package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_G4_1043_거짓말 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] trust = new boolean[N+1];
		
		st= new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<T;i++) {
			trust[Integer.parseInt(st.nextToken())]=true;
		}
		
		int[][] talk = new int[M][];
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			talk[i]=new int[K];
			for(int k=0;k<K;k++) {
				talk[i][k]=Integer.parseInt(st.nextToken());
				//System.out.print(talk[i][k]+" ");
			}
			//System.out.println();
		}
		
		boolean sayTrue;
		for(int i=0;i<N;i++) { // 최대 사람 명수만큼 반복하면 최악의 경우에도 모든 수를 구할 수 있다 n<50이라 가능
			for(int j=0;j<M;j++) {
				sayTrue = false;
				int K = talk[j].length;
				for(int k=0;k<K;k++) {
					if(trust[talk[j][k]]) {  //파티에 진실을 아는 사람이 한명이라도 있으면
						sayTrue=true;
						break;
					}
				}
				if(sayTrue) {
					for(int k=0;k<K;k++) {
						trust[talk[j][k]]=true;   //진실을 말했으므로 같이 있던 사람들도 모두 진실을 아는 사람이 된다.
					}
					
				}
			}
		}
		int cnt=0;
		for(int i=0;i<M;i++) {
			sayTrue=false;
			for(int j=0;j<talk[i].length;j++) {
				if(trust[talk[i][j]])    //파티에서 진실을 아는 사람이 한명도 없는 경우에만 cnt가 증가
					sayTrue=true;
			}
			if(!sayTrue) {
				cnt++;
			}
		}
		
		System.out.println(cnt);

			

	}

}
