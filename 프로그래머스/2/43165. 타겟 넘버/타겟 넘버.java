import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
		return BFS(numbers.length, numbers, target);
	}

	private static int BFS(int n, int[] numbers, int target) {
		int answer = 0;
		ArrayDeque<Integer[]> queue = new ArrayDeque<>();

		queue.add(new Integer[] { numbers[0], 1 });
		queue.add(new Integer[] { -numbers[0], 1 });

		while (!queue.isEmpty()) {
			Integer[] tmp = queue.poll();
			int cur = tmp[0];
			int count = tmp[1];

			if (count == n) {
				if (cur == target) {
					answer++;
				}
			} else {
				queue.add(new Integer[] { cur - numbers[count], count + 1 });
				queue.add(new Integer[] { cur + numbers[count], count + 1 });

			}
		}

		return answer;
	}
}