package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S2_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), "+-", true);  //숫자와 + - 연산자로 입력을 나눠준다

		int sum = 0;

		Queue<String> q = new LinkedList<>();   //나눠준 입력을 받을 큐

		while (st.hasMoreTokens()) {
			q.offer(st.nextToken());     //큐에 전부 넣어버려
		}

		int size = q.size();

		while (!q.isEmpty()) {   //
			if (q.peek().equals("+")) {    //-가 나오기전에 +가 나온다면?
				q.poll(); //연산자 버려주고
				sum+=Integer.parseInt(q.poll()); //값 더해
				
			} else if (q.peek().equals("-")) {    //식 중간에 -가 오면 그 뒤로는 어떤 연산자가 오든 -연산이다
				while (!q.isEmpty()) {
					if (!q.peek().equals("+") && !q.peek().equals("-")) {
						sum -= Integer.parseInt(q.poll());
					} else
						q.poll();
				}
			} else {
				if (q.size() == size)  //만약 식의 맨 처음이면 
					sum += Integer.parseInt(q.poll());  //무조건 더하기이므로
			}
		}
		
		System.out.println(sum);

	}

}
