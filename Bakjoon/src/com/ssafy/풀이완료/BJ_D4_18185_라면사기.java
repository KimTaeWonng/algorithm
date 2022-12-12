package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_D4_18185_라면사기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long cnt = 0;  //혹시 몰라서 int 오버플로우 날까봐

		for (int i = 0; i < N - 2; i++) {   //맨 처음에 7의 비용으로 살 수 있을때
			if (arr[i] != 0 && arr[i + 1] != 0 && arr[i + 2] != 0) {   		//인접한 세 공장이 가동중일때
				if (arr[i + 1] > arr[i + 2]) {    							// <- 이부분이 반례 
					int Min = Math.min(arr[i], arr[i + 1] - arr[i + 2]);    // <- 세 라면공장중 가운데 라면공장이 세번째 라면공장보다 많이 생성하면 
					arr[i]   -= Min;										// 앞에서부터 3개를 사는거보다 앞에서 2개 사고 i+1 ~ i+3 까지 확인해서 3개 사는게 더 이득이다.
					arr[i+1] -= Min;										// 앞에서 2개 묶어사는거를 최대한 적게 사면 최소비용을 구할수 있다.
					cnt += Min * 5;
					i = i - 1; // 다시 한칸 돌아와서 7의 비용으로 구매가 가능한지 확인
					continue; 
				}
				int Min = Math.min(arr[i], arr[i + 1]);
				Min = Math.min(Min, arr[i + 2]);
				arr[i] -= Min;
				arr[i + 1] -= Min;
				arr[i + 2] -= Min;
				cnt += Min * 7;

			}
		}
		for (int i = 0; i < N - 1; i++) {   //7의 비용을 전부 사고나서 5의 비용 확인
			if (arr[i] != 0 && arr[i + 1] != 0) {        //인접한 두 라면공장이 가동중일때
				int Min = Math.min(arr[i], arr[i + 1]);  //둘중에 min 구하기
				arr[i] -= Min;
				arr[i + 1] -= Min;
				cnt += Min * 5;
			}
		}
		for (int i = 0; i < N; i++) {    //나머지는 하나씩 3의비용으로
			if (arr[i] != 0) {
				cnt += arr[i] * 3;
				arr[i] = 0;
			}
		}

		System.out.println(cnt);

	}

}
