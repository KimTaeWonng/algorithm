package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_G4_1744_수묶기 {

	// 배열에 모든 수를 오름차순으로 담고 각 조건에 따라 다르게 계산
	// 둘다 음수일 경우 묶어서 곱한다.
	// 음수와 0일 경우 곱한다.
	// 음수와 양수일 경우 더한다. (먼저 고른 음수만 더한다)
	// 양수와 0일경우 더한다. (0을 더한다)
	// 1과 양수일경우 더한다. (1을 더한다)
	// 1보다 큰 두 양수일 경우 곱한다.

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		boolean[] check = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int M = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] > 1) {
				M++; // 1보다 큰 양수의 갯수
			}
		}

		int cnt = 0;

		if (N == 1) {
			cnt = arr[0];
			check[0] = true;
		}
		if (N != 1 && arr[0] < 0) { // 음수와 양수가 섞여있을때 or 음수만 존재할때는 이렇게
			if (M % 2 == 0) { //만약 M이 짝수면 이렇게 
				for (int i = 0; i < N - 1; i++) {
					if (arr[i] < 0 && arr[i + 1] < 0) {
						cnt += arr[i] * arr[i + 1];
						check[i] = true;
						check[i + 1] = true;
						i++;
					} else if (arr[i] < 0 && arr[i + 1] == 0) {
						check[i] = true;
						check[i + 1] = true;
						i++;
					} else if (arr[i] < 0 && arr[i + 1] > 0) {
						cnt += arr[i];
						check[i]=true;
					} else if (arr[i] == 0) {
						check[i]=true;
					} else if (arr[i] == 1 && arr[i + 1] > 0) {
						cnt += 1;
						check[i]=true;
					} else if (arr[i] > 1 && arr[i + 1] > 1) {
						cnt += arr[i] * arr[i + 1];
						check[i] = true;
						check[i + 1] = true;
						i++;
					}
				}
			}
			if(M%2==1) {   // M이 홀수면 양수의 계산은 내림차순(큰것 두개를 먼저 묶는 식)으로 해야한다.
				int i=0;
				while(arr[i]<=1 && i<N-1) { //음수부터 1까지는 정상적으로 진행
					if (arr[i] < 0 && arr[i + 1] < 0) {
						cnt += arr[i] * arr[i + 1];
						check[i] = true;
						check[i + 1] = true;
						i++;
					} else if (arr[i] < 0 && arr[i + 1] == 0) {
						check[i] = true;
						check[i + 1] = true;
						i++;
					} else if (arr[i] < 0 && arr[i + 1] > 0) {
						cnt += arr[i];
						check[i]=true;
					} else if (arr[i] == 0) {
						check[i]=true;
					} else if (arr[i] == 1 && arr[i + 1] > 0) {
						cnt += 1;
						check[i]=true;
					}
					i++;
				}
				i=1;
				while(i<=M) {  //여기서부터 1보다 큰 양수의 시작    현재 오름차순이므로 배열의 끝부분에서부터 곱해준다.
					if(i==M) {
						check[N-M]=true;
						cnt+=arr[N-i];
					}else {
						cnt+=arr[N-i]*arr[N-1-i];
						check[N-i]=true;
						check[N-i-1]=true;
						i++;
					}
					i++;
				}
			}
		}

		if (N != 1 && arr[0] >= 0) { // 전부 0보다 클 때는 반대로 내림차순하여 곱한다
			for (int i = N - 1; i > 0; i--) {
				if (arr[i - 1] != 0 && arr[i - 1] != 1) {  //0과 1은 더해줘야 하므로 곱하지말자
					cnt += arr[i] * arr[i - 1];
					check[i - 1] = true;
					check[i] = true;
					i--;
				} else {
					cnt += arr[i];
					check[i]=true;
				}
			}
		}

		if (M%2==0 && arr[0] < 0 && !check[N - 1]) {   //이 부분은 위에서 분기가 
			cnt += arr[N - 1];
		}
		
		if(M%2==1 && arr[0]<0 && !check[N-M]) {    // N-1에서 끝나므로 혹시 마지막에 계산하는 
			cnt += arr[N-M];
		}

		if (arr[0] >= 0 && !check[0]) {				// 하나가 빠졌을 경우 확인하여 더해주는 곳
			cnt += arr[0]; 
		}

		System.out.println(cnt);

	}

}
