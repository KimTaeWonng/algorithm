package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.RootPaneContainer;

public class _BOJ_TRIE_G2_14725 {
	
	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Node{
		Map<String, Node> childNode = new TreeMap<String, Node>();
		
		boolean endOfword;

		public Map<String, Node> getChildNode() {
			return childNode;
		}

		public void setChildNode(Map<String, Node> childNode) {
			this.childNode = childNode;
		}
		
		 
		
	}
	
	static class Trie{
		Node root = new Node();
		
		void insert(int[] arr,String str) {
			Node node = this.root;
			
			int a=0;
			
			for(int i=0;i<arr.length;i++) {
				
				String temp = str.substring(a,a+arr[i]);
				a +=arr[i];
				node = node.childNode.computeIfAbsent(temp, key -> new Node());
			}
			
			node.endOfword = true;
		}

		public void print() throws IOException {
			doPrint(root,0);
			
		}

		private void doPrint(Node node, int cnt) throws IOException {
			Set<String> set = node.getChildNode().keySet();
			Iterator<String> itr = set.iterator();
			
			while(itr.hasNext()) {
				String temp = itr.next();
				
				Node ttemp = node.getChildNode().get(temp);
				for(int i=0;i<cnt;i++) {
					bw.write("--");
				}
				bw.write(temp+"\n");
				doPrint(ttemp,cnt+1);
			}
			
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[K];
			
			StringBuilder sb = new StringBuilder();
			for(int k=0;k<K;k++) {
				String str = st.nextToken();
				sb.append(str);
				arr[k] = str.length();
			}
			
			trie.insert(arr, sb.toString());
			
			
		}
		
		trie.print();
		
		bw.flush();
		bw.close();
		br.close();

	}
	

}
