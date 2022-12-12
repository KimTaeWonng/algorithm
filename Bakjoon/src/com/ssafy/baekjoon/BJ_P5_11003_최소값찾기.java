package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_P5_11003_최소값찾기 {
	
	
	//i<L일땐 i개 만큼의 수중에 최소를 찾는다 -> 우선순위 큐를 따로 선언해 거기가 하나씩 넣고, 넣는방식은 deque를 이용해 앞 수를 뒤로옮겼다가 계산 한번이 끝나면 다시 가져오는 식으로(i-L+1이 1보다 커지면 필요없는 수는 poll로 버려둔다)
	//우선순위큐로 인해 최소값은 index가 0인 수

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

	}

}
