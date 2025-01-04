import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

//5
//6 9 5 7 4

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		ArrayDeque<Integer> stack = new ArrayDeque<>();

		ArrayDeque<Integer> answer = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			int height = arr[i];

			if (stack.isEmpty()) {
				stack.add(i);
				answer.add(0);
			} else {
				while (arr[stack.peekLast()] < height) {
					stack.pollLast();
					if (stack.isEmpty())
						break;
				}
				if (stack.isEmpty()) {
					stack.add(i);
					answer.add(0);
				} else {
					answer.add(stack.peekLast() + 1);
					stack.add(i);
				}

			}
		}
		for (Integer num : answer) {
			System.out.print(num + " ");
		}
	}
}