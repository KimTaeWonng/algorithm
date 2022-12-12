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

public class BJ_S5_2628_종이자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> arrR = new ArrayList<>();
		ArrayList<Integer> arrC = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st= new StringTokenizer(br.readLine());
			
			if(st.nextToken().equals("1")) {
				arrR.add(Integer.parseInt(st.nextToken()));
			}
			else {
				arrC.add(Integer.parseInt(st.nextToken()));
			}
		}
		arrR.add(0);
		arrR.add(R);
		
		arrC.add(0);  // 원점과 끝값을 넣어줌
		arrC.add(C);  // 어차피 정렬할거라 ㄱㅊ
		Collections.sort(arrR);
		Collections.sort(arrC);		
		
		int MAX =0;
		for(int i=1;i<arrR.size();i++) {
			for(int j=1;j<arrC.size();j++) {
				MAX = Math.max(MAX, (arrR.get(i)-arrR.get(i-1)) * (arrC.get(j)-arrC.get(j-1)));	//각각의 넓이 구하기	
			}
		}
		
		System.out.println(MAX);
		
		
	}

}
