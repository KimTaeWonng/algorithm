package com.ssafy.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_G5_23629_이얼마나끔찍 {

	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), "x|+|-|/|=", true);
		ArrayList<String> arl = new ArrayList<>();
		boolean madness = false;

		while (st.hasMoreTokens()) {
			arl.add(st.nextToken());
		}

		for (int i = 0; i < arl.size() - 1; i++) { // 끔찍한 수식
			if (arl.get(i).equals("+") || arl.get(i).equals("-") || arl.get(i).equals("x") || arl.get(i).equals("/") || arl.get(i).equals("=")) {
				if (arl.get(i + 1).equals("+") || arl.get(i + 1).equals("-") || arl.get(i + 1).equals("x")
						|| arl.get(i + 1).equals("/") || arl.get(i + 1).equals("=")) {
					System.out.println("Madness!");
					madness = true;
					break;
				}
			}			
		}

		if (!madness) {
			for (int i = 0; i < arl.size(); i++) {
				String temp = arl.get(i);
				temp = temp.replaceAll("ONE", "1");
				temp = temp.replaceAll("TWO", "2");
				temp = temp.replaceAll("THREE", "3");
				temp = temp.replaceAll("FOUR", "4");
				temp = temp.replaceAll("FIVE", "5");
				temp = temp.replaceAll("SIX", "6");
				temp = temp.replaceAll("SEVEN", "7");
				temp = temp.replaceAll("EIGHT", "8");
				temp = temp.replaceAll("NINE", "9");
				temp = temp.replaceAll("ZERO", "0");

				arl.set(i, temp);
				
				String regex1 = "^[0-9|+|]*$";
				String regex2 = "^[+|x|\\-|/|=]$";
				if(!arl.get(i).matches(regex1) && !arl.get(i).matches(regex2)) {
					System.out.println("Madness!");
					System.exit(0);
				}


			}
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < arl.size(); i++) {
				sb.append(arl.get(i));
			}
			System.out.println(sb);

			long answer = Long.parseLong(arl.get(0));

			for (int i = 1; i < arl.size() - 2; i += 2) {
				switch (arl.get(i)) {
				case "+":
					answer += Long.parseLong(arl.get(i + 1));
					break;
				case "-":
					answer -= Long.parseLong(arl.get(i + 1));
					break;
				case "/":
					answer /= Long.parseLong(arl.get(i + 1));
					break;
				case "x":
					answer *= Long.parseLong(arl.get(i + 1));
					break;
				default:
					break;
				}
			}

			//System.out.println(answer);

			String temp = String.valueOf(answer);
			
			temp = temp.replaceAll("1","ONE");
			temp = temp.replaceAll("2","TWO");
			temp = temp.replaceAll("3","THREE");
			temp = temp.replaceAll("4","FOUR");
			temp = temp.replaceAll("5","FIVE");
			temp = temp.replaceAll("6","SIX");
			temp = temp.replaceAll("7","SEVEN");
			temp = temp.replaceAll("8","EIGHT");
			temp = temp.replaceAll("9","NINE");
			temp = temp.replaceAll("0","ZERO");
			
			System.out.println(temp);
		}

	}

}
