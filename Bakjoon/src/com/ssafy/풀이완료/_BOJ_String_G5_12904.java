package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G5_12904_A와B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder S = new StringBuilder();
		StringBuilder T = new StringBuilder();

		S.append(br.readLine());
		T.append(br.readLine());
		while (true) {
			if (S.length() >= T.length())
				break;

			switch (T.charAt(T.length() - 1)) {        //뒤에꺼 지움
			case 'A':
				T.deleteCharAt(T.length() - 1);
				//System.out.println(T);
				break;
			case 'B':
				T.deleteCharAt(T.length() - 1);
				T.reverse();
				//System.out.println(T);
				break;
			}

		}
		boolean check = false;

		for (int i = 0; i < T.length(); i++) {
			if (S.charAt(i) != T.charAt(i)) {
				check = true;
				break;
			}
		}
		if (check)
			System.out.println(0);
		else
			System.out.println(1);

	}
}
