package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_2473_세용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int liquid[] = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(liquid);

		int L = 0, R = 0, M = 0;
		if (liquid[0] >= 0) { // 모든수가 양수
			L = 0;
			M = 1;
			R = 2;

		} else if (liquid[N - 1] <= 0) { // 모든수가 음수
			L = N - 3;
			M = N - 2;
			R = N - 1;

		} else {
			long max = Long.MAX_VALUE;
			for (int i = 0; i < N; i++) {  //left,right 잡아놓고 다른 모든 수를 찾아 본다
				int left = 0;
				int right = N - 1;
				
				long temp = 0;

				while (left < right) {

//					if (i == left || i == right)
//						continue;

					temp = liquid[left] + liquid[right] + liquid[i];  //세 용액 섞어

					if (max > Math.abs(temp) && (i!=left && i!=right)) {  //만약 i가 left,right와 중복된 수인 경우 걍 넘어감
						L = left;
						M = i;
						R = right;
						max = Math.abs(temp);
					}

					if (temp > 0) {
						right--;
					} else {
						left++;
					}
				}
			}
		}
		
		int ans[] = {L,M,R};
		Arrays.sort(ans);

		System.out.println(liquid[ans[0]] + " " + liquid[ans[1]] + " " + liquid[ans[2]]);

	}

}
