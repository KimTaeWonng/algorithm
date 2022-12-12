package com.ssafy.baekjoon;

import java.io.*;
import java.util.*;

public class _BOJ_String_S5_2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		String[] str = s.split("");
		int cnt = 0;
		for (int i = 0; i < str.length; i++) {
			switch (str[i]) {
			case "c":
				if (i + 1 < str.length && (str[i + 1].equals("-") || str[i + 1].equals("="))) {
					cnt++;
					i += 1;
				} else
					cnt++;
				break;
			case "d":
				if (i + 1 < str.length && str[i + 1].equals("-")) {
					cnt++;
					i += 1;
				} else if (i + 2 < str.length && str[i + 1].equals("z") && str[i + 2].equals("=")) {
					cnt++;
					i += 2;
				} else
					cnt++;
				break;
			case "l":
				if (i + 1 < str.length && str[i + 1].equals("j")) {
					cnt++;
					i += 1;
				} else
					cnt++;
				break;
			case "n":
				if (i + 1 < str.length && str[i + 1].equals("j")) {
					cnt++;
					i += 1;
				} else
					cnt++;
				break;
			case "s":
				if (i + 1 < str.length && str[i + 1].equals("=")) {
					cnt++;
					i += 1;
				} else
					cnt++;
				break;
			case "z":
				if (i + 1 < str.length && str[i + 1].equals("=")) {
					cnt++;
					i += 1;
				} else
					cnt++;
				break;
			default:
				cnt++;
			}

		}
		
		System.out.println(cnt);

	}

}
