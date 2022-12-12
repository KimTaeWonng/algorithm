package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class _BOJ_Tree_S5_9733 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Scanner sc = new Scanner(System.in);
		int tokenCounter=0;
		int re = 0, pt = 0, cc = 0, ea = 0, tb = 0, cm = 0, ex = 0, total = 0;

			
			while (tokenCounter!=24) {
				String str =sc.next();
				tokenCounter++;
				switch (str) {
				case "Re":
					re++;
					break;
				case "Pt":
					pt++;
					break;
				case "Cc":
					cc++;
					break;
				case "Ea":
					ea++;
					break;
				case "Tb":
					tb++;
					break;
				case "Cm":
					cm++;
					break;
				case "Ex":
					ex++;
					break;
				default:
					break;
				}
				total++;
				// str = br.readLine();
			}
		

		double db = (double) re / total;
		System.out.printf("Re %d %.2f\n", re, db);
		db = (double) pt / total;
		System.out.printf("Pt %d %.2f\n", pt, db);
		db = (double) cc / total;
		System.out.printf("Cc %d %.2f\n", cc, db);
		db = (double) ea / total;
		System.out.printf("Ea %d %.2f\n", ea, db);
		db = (double) tb / total;
		System.out.printf("Tb %d %.2f\n", tb, db);
		db = (double) cm / total;
		System.out.printf("Cm %d %.2f\n", cm, db);
		db = (double) ex / total;
		System.out.printf("Ex %d %.2f\n", ex, db);
		System.out.println("Total " + total + " 1.00");
		sc.close();

	}

}
