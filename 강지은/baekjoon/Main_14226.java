import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14426 {
	
	static int N, M;
	static class Node {
		HashMap<Character, Node> child;
		boolean isEnd;
		public Node() {
			this.child = new HashMap<>();
			this.isEnd = false;
		}
	}
	
	static class Trie {
		Node root;
		public Trie() {
			this.root = new Node();
		}
		
		void insert(char[] word) {
			Node node = this.root;
			
			for (int i = 0; i < word.length; i++) {
				char c = word[i];
				node.child.putIfAbsent(c, new Node());
				node = node.child.get(c);
			}
			
			node.isEnd = true;
		}
		
		boolean search(char[] word) {
			Node node = this.root;
			
			for (int i = 0; i < word.length; i++) {
				char c = word[i];
				if (node.child.containsKey(c)) {
					node = node.child.get(c);
				} else {
					return false;
				}
			}
			
			return true;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Trie trie = new Trie();
		
		for (int i = 0; i < N; i++) {
			char[] word = br.readLine().toCharArray();
			trie.insert(word);
		}
		
		int count = 0;
		for (int i = 0; i < M; i++) {
			char[] newWord = br.readLine().toCharArray();
			if (trie.search(newWord)) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}

	
}
