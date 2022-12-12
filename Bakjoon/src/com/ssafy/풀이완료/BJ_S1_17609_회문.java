package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_S1_17609_회문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			int cnt = 0;

			String str = br.readLine();

			int direct = 0;
			int reverse = str.length() - 1;

			while (direct <= reverse) {
				if (str.charAt(direct) == str.charAt(reverse)) {
					direct++;
					reverse--;
				} else {
					cnt=1;

					int d = direct + 1;
					int r = reverse;

					while (d <= r) { // 왼쪽꺼 삭제
						if (str.charAt(d) == str.charAt(r)) {
							d++;
							r--;
						}else {
							cnt++;
							break;
						}
						
					}

					d = direct;
					r = reverse - 1;

					while (d <= r) { // 오른쪽꺼 삭제
						if (str.charAt(d) == str.charAt(r)) {
							d++;
							r--;
						}else {
							cnt++;
							break;
						}
						
					}					
					break;
				}
			}

			if(cnt>1) {
				System.out.println(cnt-1);
			}else
				System.out.println(cnt);

		}

	}

}
