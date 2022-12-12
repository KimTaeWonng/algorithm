package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G4_9935_문자열폭발 {

	// 첫째줄에 주어진 문자열을 스택에 거꾸로 넣고(후입선출), 폭발문자열을 판별할 진짜 스택에 하나씩 넣어본다
	// 스택에 하나씩 넣다가 폭발 문자열 첫글자를 발견하면 폭발 문자열의 길이만큼 계속 확인하여 폭발문자열이 맞는지 확인,
	// 만약 맞으면 이전까지 들어왔던 문자열을 전부 pop하고(문자열길이-1) 추가로 문자열길이-1만큼 더 pop하여 다시 넣는다.
	// (이전에 넣엇던 게 폭발문자열의 일부 일 수도 있음) 그렇게해서 첫 스택이 빌때까지 하다가 결과를 도출
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		Stack<Character> st1 = new Stack<>(); // 하나씩 넣어볼거
		Stack<Character> st2 = new Stack<>(); // 먼저 넣을거

		char[] ch = br.readLine().toCharArray();

		for (int i = 0; i < ch.length; i++) {
			st1.push(ch[i]);     //처음에 넣고
		}

		while (!st1.isEmpty()) {
			st2.push(st1.pop());   //후입선출을 위해 다시 옮겨준다
		}

		char[] bomb = br.readLine().toCharArray();

		// System.out.println(bomb);
		while (!st2.isEmpty()) {
			char c = st2.pop();
			
			// System.out.println(c);
			
			if (c == bomb[0]) {    //이번에 꺼낸 문자열이 폭발문자열의 시작부분일경우		
				int boom = 1;
				st1.push(c);
				for (int i = 1; i < bomb.length; i++) {
					if (!st2.isEmpty()) {     //주어진 문자열보다 폭발문자열이 길 경우를 방지
						c = st2.pop();
						if (c == bomb[i]) {   //폭발 문자열과 계속 비교해준다
							st1.push(c);
							boom++;
							;
						} else {   //아니면 즉시 탈출
							st2.push(c); //꺼냈던거는 다시 집어넣고
							break;
						}
					}
				}
				// System.out.println(st1);
				if (boom == bomb.length) {   //방금 집어넣은 문자열이 폭발문자열과 정확히 일치할경우
					for (int i = 0; i < bomb.length; i++) { //넣은만큼 꺼내서 버려준다
						st1.pop();
					}
					for (int i = 0; i < bomb.length - 1; i++) {  
						if (!st1.isEmpty())  
							st2.push(st1.pop());     //이전에 집어넣은게 다시 폭발문자열일 가능성이 있으므로 뺴내서 다시 집어넣어줌
					}
				}

			} else {
				st1.push(c);   //별 이상없으면 걍 넣어
			}

		}

		StringBuilder sb = new StringBuilder();

		while (!st1.isEmpty()) {
			st2.push(st1.pop());  //sb에 넣기위해서 다시 후입선출 만들어줌
		}

		while (!st2.isEmpty()) {
			sb.append(st2.pop());
		}

		if (sb.length() == 0)
			System.out.println("FRULA");   
		else
			System.out.println(sb);

	}

}
