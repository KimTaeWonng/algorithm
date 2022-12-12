package com.ssafy.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S3_2607_비슷한단어 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()) - 1;

		String First = br.readLine();
		int ans = 0;

		for (int t = 0; t < T; t++) {

			String first = First;
			String temp = br.readLine();

			if (Math.abs(First.length() - temp.length()) > 1)
				continue;

			int min = Math.min(First.length(), temp.length());
			int cnt = 0;

			for (int i = 0; i < min; i++) {
				if (first.length() > temp.length()) {
					if (first.contains(String.valueOf(temp.charAt(i)))) {
						cnt++;
						first = first.replaceFirst(String.valueOf(temp.charAt(i)), "a");
					}
				} else {
					if (temp.contains(String.valueOf(first.charAt(i)))) {
						cnt++;
						temp = temp.replaceFirst(String.valueOf(first.charAt(i)), "a");
					}
				}
			}

			if (First.length() == temp.length()) {
				if (min - cnt <= 1) {
					ans++;
				}
			} else {
				if (min == cnt) {
					ans++;
				}
			}

		}

		System.out.println(ans);

	}

}
