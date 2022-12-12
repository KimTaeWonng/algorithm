package com.ssafy.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_3107_IPv6 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String ipv6 = br.readLine().replace("::", ":change:");
		String[] tempi = ipv6.split(":");

		ArrayList<String> arl = new ArrayList<>();
		int cnt = 0;
		while (cnt < tempi.length) {
			arl.add(tempi[cnt]);
			cnt++;
		}
		//System.out.println(Arrays.toString(tempi));
		for (int i = 0; i < arl.size(); i++) {
			String temp = arl.get(i);

			if (temp.equals("change")) {
				arl.set(i, "0000");
				while (arl.size() < 8) {
					arl.add(i, "0000");
				}
			} else if (temp.length() < 4) {
				while (temp.length() < 4) {
					temp = "0" + temp;
				}
				arl.set(i, temp);
			}
		}
		//System.out.println(arl);
		StringBuilder sb = new StringBuilder();
		if (arl.size() == 9) {
			sb.append(arl.get(1));
			for (int i = 2; i < 9; i++) {
				sb.append(":" + arl.get(i));
			}
		} else {
			sb.append(arl.get(0));
			for (int i = 1; i < 8; i++) {
				sb.append(":" + arl.get(i));
			}
		}

		System.out.println(sb);

	}

}
