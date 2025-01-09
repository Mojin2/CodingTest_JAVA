import java.util.*;
class Solution {
    static public String[] solution(String[] orders, int[] course) {
//		ArrayList<String> answer = new ArrayList<>();
		TreeSet<String> answer = new TreeSet<>();
		// String[] answer = {};

		TreeMap<String, Integer> map = new TreeMap<>();
		for (int i = 0; i < course.length; i++) {
			int len = course[i];
			boolean[] check = new boolean[26];
			for (String str : orders) {
				String[] order = str.split("");
				StringBuilder made = new StringBuilder();
				backtrack(made, order, len, 0, map, 0, check);
			}
		}

//		System.out.println(map);

		// map에서 길이당 최대 값을 구함
		for (int i = 0; i < course.length; i++) {
			String ans = "";
			int max = Integer.MIN_VALUE;
			int len = course[i];

			for (String key : map.keySet()) {
				if (key.length() == len && map.get(key) > max) {
					max = Math.max(max, map.get(key));
				}
			}

			for (String key : map.keySet()) {
				if (key.length() == len && map.get(key) == max && map.get(key) >= 2) {
					answer.add(key);
				}
			}
		}

		String[] ans = new String[answer.size()];
		int ansIndex = 0;
		for (String s : answer) {
			ans[ansIndex++] = s;
		}

//		System.out.println(Arrays.toString(ans));
		return ans;

	}

	private static void backtrack(StringBuilder made, String[] order, int len, int depth, TreeMap<String, Integer> map,
			int start, boolean[] check) {
		if (len == depth) {
			char[] tw = new char[len];
			int twIdx = 0;
			for (int i = 0; i < 26; i++) {
				if (check[i]) {
					tw[twIdx] = (char) (i + 65);
					twIdx++;
				}
			}

			String tmp = new String(tw);
//			System.out.println(tmp);

			if (map.containsKey(tmp)) {
				map.put(tmp, map.get(tmp) + 1);
			} else {
				map.put(tmp, 1);
			}
			return;
		}

		for (int i = start; i < order.length; i++) {
			int checkIdx = order[i].charAt(0) - '0' - 17;
			if (check[checkIdx])
				continue;
			made.append(order[i]);
			check[checkIdx] = true;
			backtrack(made, order, len, depth + 1, map, i + 1, check);
			made.delete(made.length() - 1, made.length());
			check[checkIdx] = false;
		}
	}
}