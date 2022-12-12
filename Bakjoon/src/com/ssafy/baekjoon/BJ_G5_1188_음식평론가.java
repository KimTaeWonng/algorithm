package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G5_1188_음식평론가 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int C = gcd(A,B);  //A와 B의 최대공약수
		
		if(C==B) {
			System.out.println(0);  //통째로 나눠주면 댐
		}else {
			System.out.println(B-C); //B명에게 A/B만큼의 크기의 소세지를 준다.
		}

	}

	static int gcd(int a, int b) { //최대공약수 구하는 함수
		while (b != 0) {
			int r = a % b;

			a = b;
			b = r;
		}
		return a;
	}

}
