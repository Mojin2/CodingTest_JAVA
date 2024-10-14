import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test = 0; test < T; test++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			String[] arr = new String[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = st.nextToken();
			}

			Arrays.sort(arr, (a, b) -> {
				return a.length() - b.length();
			});

			Trie trie = new Trie();

			boolean flag = false;

			for (int i = 0; i < arr.length; i++) {
				if (!trie.insert(arr[i])) {
					flag = true;
					break;
				}
			}
			if (flag) {
				System.out.println("NO");

			} else {
				System.out.println("YES");
			}

		}
	}
}

class Node {
	HashMap<Character, Node> child;
	boolean endOfWord;

	public Node() {
		this.child = new HashMap<>();
		this.endOfWord = false;
	}
}

class Trie {
	Node root;

	public Trie() {
		this.root = new Node();
	}

	public boolean insert(String str) {
		Node node = this.root;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (node.endOfWord == true) {
				node.child.putIfAbsent(c, new Node());
				return false;
			}
			node.child.putIfAbsent(c, new Node());
			node = node.child.get(c); // 자식노드로 이동
		}
		node.endOfWord = true;
		return true;
	}

	boolean search(String str) {
		Node node = this.root;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (node.child.containsKey(c)) {
				node = node.child.get(c);
			} else {
				return false;
			}
		}
		return node.endOfWord;
	}

}