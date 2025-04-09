//50
//30
//24
//5
//28
//45
//98
//52
//60
// 전위순회로 주어진걸 후위순회로 뽑아야함 >> 참고로 이진탐색 트리

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder post = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;

		BST bst = new BST();

		while ((line = br.readLine()) != null && !line.equals("")) {
			StringTokenizer st = new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				bst.insert(num);
			}
		}

		bst.postOrder();

		System.out.println(post);

	}

	static class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	static class BST {
		Node root;

		BST() {
			root = null;
		}

		void insert(int value) {
			root = insertRec(root, value);
		}

		private Node insertRec(Node root, int value) {
			if (root == null) {
				root = new Node(value);
				return root;
			}

			if (root.value > value) {
				root.left = insertRec(root.left, value);
			} else {
				root.right = insertRec(root.right, value);
			}

			return root;
		}

		void postOrder() {
			postRec(root);
		}

		// 후위 순회 : left > right > root
		private void postRec(Node root) {
			if (root == null)
				return;

			postRec(root.left);
			postRec(root.right);
			post.append(root.value).append("\n");

		}
	}
}
