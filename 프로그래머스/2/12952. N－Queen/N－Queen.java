import java.util.*;

class Solution {

    private ArrayDeque<Integer> queue = new ArrayDeque<>();
	private int n;
	private int answer;
	private int[] number;

	public int solution(int m) {
		n = m;
		
		int[] dp = new int[m];
		number = new int[m];
		for (int i = 0; i < n; i++) {
			number[i] = i;
		}

		backtrack();

		return answer;
	}

	private void backtrack() {
if (!check(queue)) {
			return;
		}
		if (queue.size() == n) {

			if (check(queue)) {
//				for (Integer a : queue) {
//					System.out.print(a + " ");
//				}
//				System.out.println();
				answer++;
			}

			return;
		}

		for (int i = 0; i < number.length; i++) {
			if (queue.contains(number[i])) {
				continue;
			}
			queue.add(number[i]);
			backtrack();
			queue.pollLast();
		}

	}

	private boolean check(ArrayDeque<Integer> queue) {
		int[] list = new int[queue.size()];
		int listIndex = 0;
		for (Integer a : queue) {
			list[listIndex++] = a;
		}
		int l = list.length;

//		System.out.println(Arrays.toString(list));

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				if (i == j)
					continue;

				if (Math.abs(list[i] - list[j]) == Math.abs(i - j)) {
					return false;
				}
			}
		}

		return true;
	}
}