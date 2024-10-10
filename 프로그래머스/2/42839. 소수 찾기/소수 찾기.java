import java.util.Arrays;
import java.util.HashSet;

public class Solution {

	static HashSet<Integer> ans = new HashSet<>();

	public static void main(String[] args) {
		String numbers = "011";
		int ans = solution(numbers);
		System.out.println(ans);
	}

	public static int solution(String numbers) {
		int answer = 0;

		String[] list = numbers.split("");

		for (int i = 1; i <= list.length; i++) {
			combination(list, new String[i], new boolean[list.length], 0, i);
		}

		return ans.size();
	}

	private static void combination(String[] list, String[] out, boolean[] visited, int depth, int r) {
		if (depth == r) {
			check(out);
			return;
		}

		for (int i = 0; i < list.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				out[depth] = list[i];
				combination(list, out, visited, depth + 1, r);
				visited[i] = false;
			}
		}
	}

	private static void check(String[] out) {
		String t = String.join("", out);
		int num = Integer.parseInt(t);
		if (isPrime(num)) {
			ans.add(num);
		}

	}

	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
