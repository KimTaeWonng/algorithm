package com.ssafy.소수만들기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_G4_1153_네개의소수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		if (N < 8) {
			System.out.println(-1);
		} else {
			
			int A=0,B=0;
			if(N%2==0) {
			A = N / 2;
			B = N / 2;
			}else {
				A = N/2;
				B = N/2+1;
			}
			int a = 0, b = 0, c = 0, d = 0;

			if (A % 2 != 0) { // 골드바흐 사용을 위해 두 수를 짝수로 만들어준다
				A -= 1;
				B += 1;
			}

			int cnt = 1;

			if (A == 4) { // 예외적으로 4인경우 2,2밖에없음
				a = 2;
				b = 2;
			} else {
				a = A / 2;
				b = A / 2;
				int temp=0,temp2=0;
				if (a % 2 == 0) { // 짝수인경우

					cnt = 1;
					while (A > cnt) {

						temp=a- cnt;
						temp2=b+ cnt;

						if (isPrime(temp) && isPrime(temp2)) {
							break;
						}

						cnt += 2;
					}

				} else { // 홀수는 먼저 소수판정부터
					cnt = 2;
					temp = a;temp2=b;
					while (A > cnt) {

						if (isPrime(temp) && isPrime(temp2)) {
							break;
						}

						temp=a- cnt;
						temp2=b+ cnt;

						cnt += 2;
					}
				}

				bw.write(temp + " " + temp2 + " ");
			}

			c = B / 2;
			d = B / 2;
			int temp=0,temp2=0;
			if (c % 2 == 0) { // 짝수인경우

				cnt = 1;
				while (B > cnt) {

					temp=c- cnt;
					temp2=d+ cnt;

					if (isPrime(temp) && isPrime(temp2)) {
						break;
					}

					cnt += 2;
				}

			} else { // 홀수는 먼저 소수판정부터
				cnt = 2;
				temp=c;temp2=d;
				while (B > cnt) {

					if (isPrime(temp) && isPrime(temp2)) {
						break;
					}

					temp=c- cnt;
					temp2=d+ cnt;

					cnt += 2;
				}
			}

			bw.write(temp + " " + temp2 + "\n");

		}

		bw.flush();
		bw.close();
		br.close();

	}

	static boolean isPrime(int N) {
		if (N == 1) {
			return false;
		}
		if (N == 2) {
			return true;
		}

		if (N % 2 == 0) {
			return false;
		}

		for (int i = 3; i <= Math.sqrt(N); i += 2) {
			if (N % i == 0) {
				return false;
			}
		}
		return true;
	}

}
