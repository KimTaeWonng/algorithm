package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G4_17298_오큰수 {
	
//	static class number{
//		int value;
//		int cnt;
//		
//		public number(int value, int cnt) {
//			super();
//			this.value = value;
//			this.cnt = cnt;
//		}
//		
//		
//	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 여기까지 입력받기
		
		Stack<Integer> s = new Stack<>();
		
		for(int i=0;i<N;i++) {
			
			
			
			while(!s.isEmpty() && arr[s.peek()]<arr[i]) {
				arr[s.pop()]=arr[i];
			}
			
			s.push(i);
		}
		
		for(int i=0;i<N;i++) { //스택에서 아직 안빠져나온애들은 -1처리
			if(s.isEmpty()) {
				break;
			} 
			
			arr[s.pop()] = -1;
		}
		
		for(int i=0;i<N;i++) {
			bw.write(arr[i]+" ");
		}
		
		bw.flush();
		br.close();
		bw.close();

	}

}
