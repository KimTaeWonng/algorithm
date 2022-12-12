package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_S5_1010_다리놓기 {

	// 오른쪽수C왼쪽수 조합

	static int N, M, input[];
	static BigInteger cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			cnt = new BigInteger("0");

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			comb(N, M);

			System.out.println(cnt);
		}

	}

	static void comb(int r, int n) {
		// 조합 = n!/(n-r!)r!
		BigInteger N = new BigInteger("1"); // 수가 너무 커서 int long 으론 택도없다
		BigInteger R = new BigInteger("1"); // 최대값인 30C15로 해보면 long도 오버플로우남

		// n!/(n-r)!
		for (int i = n; i > n - r; i--) {
			String K = String.valueOf(i);
			BigInteger k = new BigInteger(K);
			N = N.multiply(k);
			// System.out.println(N);
		}

		// r!
		for (int i = 1; i <= r; i++) {
			String K = String.valueOf(i);
			BigInteger k = new BigInteger(K);
			R = R.multiply(k);
		}
		cnt = N.divide(R);

		return;

	}
}
