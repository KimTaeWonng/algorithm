package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_1092_배 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> crain = new ArrayList<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int c = Integer.parseInt(st.nextToken());
			crain.add(c);
		}

		int M = Integer.parseInt(br.readLine());

		ArrayList<Integer> box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int c = Integer.parseInt(st.nextToken());
			box.add(c);
		}

		Collections.sort(crain);    //크레인은 오름차순 정렬
		Collections.sort(box,Collections.reverseOrder());   //박스무게는 내림차순 정렬
		boolean No = false;
		
		if (crain.get(N-1) <box.get(0)) { //모든 크레인이 어떤 박스를 담을수 없다면?
			No = true;
		}

		int time = 0;
		if (!No) {
			while (!box.isEmpty()) { //박스를 전부 옮길때까지
				int boxIdx = 0;
				for(int i=N-1;i>=0;i--) {
					if(boxIdx==box.size()) break; //마지막 박스까지 다 훑어봤으면
					if(crain.get(i)>=box.get(boxIdx)) {
						box.remove(boxIdx); // 꺼낼수있으면 꺼내
					}else {
						boxIdx++;   //못꺼냈으면 그 다음 가벼운 박스로
						i++;        //못꺼냈으므로 크레인을 바꾸면안됨 
					}
				}
				time++;   //1분씩 증가
			}
		}

		if (No)
			bw.write(-1+"");
		else
			bw.write(time+"");
		
		bw.flush();
		bw.close();
		br.close();
		

	}

}
