package com.ssafy.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S4_3986_좋은단어 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();

			if (temp.length % 2 != 0)
				continue;

			Stack<Character> s = new Stack<>();

			boolean good = true;

			for (int j = 0; j < temp.length; j++) {
				if (s.size() == 0) {
					s.add(temp[j]);
					continue;
				}

				if (!s.isEmpty() && s.peek() != temp[j]) {
					s.add(temp[j]);
					continue;
				}

				if (s.peek() == temp[j]) {
					s.pop();
					continue;
				}

				
			}
			
			if(good && s.isEmpty()) cnt++;

		}
		System.out.println(cnt);

	}

}
