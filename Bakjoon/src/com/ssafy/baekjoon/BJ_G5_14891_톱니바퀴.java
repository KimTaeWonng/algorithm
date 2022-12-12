package com.ssafy.baekjoon;

import java.util.Scanner;
import java.io.FileInputStream;

public class BJ_G5_14891_톱니바퀴 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		

		int[] mag1 = new int[8];
		int[] mag2 = new int[8];
		int[] mag3 = new int[8];
		int[] mag4 = new int[8];

		int magNo;
		int Turn;
		int answer;
		boolean oto2;
		boolean tto3;
		boolean thto4;

		

			/////////////////////////////////////////////////////////////////////////////////////////////
			String str = sc.next();
			for (int i = 0; i < 8; i++) {
				mag1[i] = str.charAt(i)-'0';
			}
			str = sc.next();
			for (int i = 0; i < 8; i++) {
				mag2[i] = str.charAt(i)-'0';
			}
			str = sc.next();
			for (int i = 0; i < 8; i++) {
				mag3[i] = str.charAt(i)-'0';
			}
			str = sc.next();
			for (int i = 0; i < 8; i++) {
				mag4[i] = str.charAt(i)-'0';
			}
			answer = 0;
			int K;
			K = sc.nextInt();
			for (int i = 0; i < K; i++) {
				magNo = sc.nextInt();
				Turn = sc.nextInt();

				oto2 = false;
				tto3 = false;
				thto4 = false;

				if (Turn == 1) {
					switch (magNo) {
					case 1:
						if (mag1[2] != mag2[6])
							oto2 = true;
						if (mag2[2] != mag3[6])
							tto3 = true;
						if (mag3[2] != mag4[6])
							thto4 = true;
						turn(mag1);

						if (oto2)
							turnR(mag2);
						if (oto2 && tto3)
							turn(mag3);
						if (oto2 && thto4 && tto3)
							turnR(mag4);
						// for(int x=0; x<8;x++){
						// System.out.println(mag2[x]);}

						break;
					case 2:
						if (mag1[2] != mag2[6])
							oto2 = true;
						if (mag2[2] != mag3[6])
							tto3 = true;
						if (mag3[2] != mag4[6])
							thto4 = true;
						turn(mag2);
						if (oto2)
							turnR(mag1);
						if (tto3)
							turnR(mag3);
						if (tto3 && thto4)
							turn(mag4);
						break;

					case 3:
						if (mag1[2] != mag2[6])
							oto2 = true;
						if (mag2[2] != mag3[6])
							tto3 = true;
						if (mag3[2] != mag4[6])
							thto4 = true;
						turn(mag3);
						if (oto2 && tto3)
							turn(mag1);
						if (tto3)
							turnR(mag2);
						if (thto4)
							turnR(mag4);
						break;
					case 4:
						if (mag1[2] != mag2[6])
							oto2 = true;
						if (mag2[2] != mag3[6])
							tto3 = true;
						if (mag3[2] != mag4[6])
							thto4 = true;
						turn(mag4);
						if (oto2 && tto3 && thto4)
							turnR(mag1);
						if (tto3 && thto4)
							turn(mag2);
						if (thto4)
							turnR(mag3);
						break;
					}
				} else if (Turn == -1) {
					switch (magNo) {
					case 1:
						if (mag1[2] != mag2[6])
							oto2 = true;
						if (mag2[2] != mag3[6])
							tto3 = true;
						if (mag3[2] != mag4[6])
							thto4 = true;
						turnR(mag1);
						if (oto2)
							turn(mag2);
						if (oto2 && tto3)
							turnR(mag3);
						if (oto2 && tto3 && thto4)
							turn(mag4);

						break;
					case 2:
						if (mag1[2] != mag2[6])
							oto2 = true;
						if (mag2[2] != mag3[6])
							tto3 = true;
						if (mag3[2] != mag4[6])
							thto4 = true;
						turnR(mag2);
						if (oto2)
							turn(mag1);
						if (tto3)
							turn(mag3);
						if (tto3 && thto4)
							turnR(mag4);
						break;

					case 3:
						if (mag1[2] != mag2[6])
							oto2 = true;
						if (mag2[2] != mag3[6])
							tto3 = true;
						if (mag3[2] != mag4[6])
							thto4 = true;
						turnR(mag3);
						if (oto2 && tto3)
							turnR(mag1);
						if (tto3)
							turn(mag2);
						if (thto4)
							turn(mag4);
						break;
					case 4:
						if (mag1[2] != mag2[6])
							oto2 = true;
						if (mag2[2] != mag3[6])
							tto3 = true;
						if (mag3[2] != mag4[6])
							thto4 = true;
						turnR(mag4);
						if (oto2 && tto3 && thto4)
							turn(mag1);
						if (tto3 && thto4)
							turnR(mag2);
						if (thto4)
							turn(mag3);
						break;
					}
				}

			}

			if (mag1[0] == 1)
				answer = answer + 1;
			if (mag2[0] == 1)
				answer = answer + 2;
			if (mag3[0] == 1)
				answer = answer + 4;
			if (mag4[0] == 1)
				answer = answer + 8;

			System.out.println(answer);

		

	}

	public static void turn(int[] a) {
		int temp = a[7];
		for (int i = 6; i >= 0; i--) {
			a[i + 1] = a[i];
		}
		a[0] = temp;

	}

	public static void turnR(int[] a) {
		int temp = a[0];
		for (int i = 0; i < 7; i++) {
			a[i] = a[i + 1];
		}
		a[7] = temp;

	}
}