package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_5639_이진검색트리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		while(true) {
			if(br.readLine().equals("60")) break;
			q.offer(Integer.parseInt(br.readLine()));
		}
		
		int N = q.size();
		
		System.out.println(N);


	}

}
