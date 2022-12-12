package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_G4_2812_크게만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String[] str = br.readLine().split("");

		Deque<Integer> dq = new ArrayDeque<>();
		int cnt = 0;
		while (cnt != N) {
			while (K > 0 && !dq.isEmpty() && Integer.parseInt(str[cnt]) > dq.getLast()) {

				K--;
				dq.removeLast();
			}
			dq.addLast(Integer.parseInt(str[cnt]));
			cnt++;
		}

		while (cnt != N) {
			dq.addLast(Integer.parseInt(str[cnt])); // 다 지우고 남은거 다 큐에 넣기

			cnt++;
		}
		
		int size = dq.size();
		for (int i = 0; i < size-K; i++) {  // 같은 수가 여러개있을때 대비
			System.out.print(dq.removeFirst());
		}

	}

}
