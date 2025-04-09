import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//7
//A B C
//B D .
//C E F
//E . .
//F . G
//D . .
//G . .

public class Main {

	static StringBuilder pre = new StringBuilder();
	static StringBuilder in = new StringBuilder();
	static StringBuilder post = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Node root = new Node("A");

		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String parent = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();

			if (parent.equals("A")) {
				if (!left.equals(".")) {
					root.setLeft(new Node(left));
				}
				if (!right.equals(".")) {
					root.setRight(new Node(right));
				}
			} else {
				addData(root, parent, left, right);
			}
		}

		preOrder(root);

		inOrder(root);

		postOrder(root);

		System.out.println(pre);
		System.out.println(in);
		System.out.println(post);

	}

	// 전위순회 : root > left > right
	private static void preOrder(Node node) {
		if (node == null)
			return;

		pre.append(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}

	// 중위선회 : left > root > right
	private static void inOrder(Node node) {
		if (node == null)
			return;

		inOrder(node.left);
		in.append(node.data);
		inOrder(node.right);
	}

	// 후위순회 : left > right > root
	private static void postOrder(Node node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		post.append(node.data);
	}

	private static void addData(Node node, String parent, String left, String right) {
		if (node == null)
			return;
		if (node.data.equals(parent)) {
			if (!left.equals(".")) {
				node.setLeft(new Node(left));
			}
			if (!right.equals(".")) {
				node.setRight(new Node(right));
			}
		}

		else {
			addData(node.left, parent, left, right);
			addData(node.right, parent, left, right);
		}
	}

	static class Node {
		Object data;
		Node left;
		Node right;

		Node(Object data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		Object getLeft() {
			return this.left;
		}

		Object getRight() {
			return this.right;
		}

		void setLeft(Node newNode) {
			this.left = newNode;
		}

		void setRight(Node newNode) {
			this.right = newNode;
		}

	}
}
