package com.ssafy.값좌표압축;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class BJ_S2_18870_좌표압축 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		TreeMap<Integer, Integer> tree = new TreeMap<>();

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] temp = arr.clone();
		Arrays.sort(temp);

		int check=0;
		for(int i : temp) {
			if(!tree.containsKey(i)) {
				tree.put(i, check);
				check++;
			}
		}
		
		for(int i : arr) {
			bw.write(tree.get(i)+" ");
		}


		bw.flush();
		br.close();
		bw.close();
	}

}
