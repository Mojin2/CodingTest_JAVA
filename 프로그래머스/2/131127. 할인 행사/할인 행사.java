import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

		// 초기 맵 설정
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			if (map.containsKey(discount[i])) {
				map.put(discount[i], map.get(discount[i]) + 1);
			} else {
				map.put(discount[i], 1);
			}
		}

		boolean flag = false;
		for (int k = 0; k < want.length; k++) {
			String item = want[k];
			int count = number[k];

			if (!map.containsKey(item)) {
				flag = true;
				continue;
			}
			if (map.get(item) != count) {
				flag = true;
			}
		}
		if (!flag)
			answer++;

		int deleteIdx = 0;
		// 하나씩 추가 제거하면서 루프
		for (int i = 10; i < discount.length; i++) {
			boolean check = false;

			// 하나 추가
			if (map.containsKey(discount[i])) {
				map.put(discount[i], map.get(discount[i]) + 1);
			} else {
				map.put(discount[i], 1);
			}

			// 하나 제거
			map.put(discount[deleteIdx], map.get(discount[deleteIdx]) - 1);
			deleteIdx++;

			// 맞는지 확인
			for (int k = 0; k < want.length; k++) {
				String item = want[k];
				int count = number[k];

				if (!map.containsKey(item)) {
					check = true;
					continue;
				}
				if (map.get(item) != count) {
					check = true;
				}
			}
			if (!check) {
				answer++;
			}
		}

		return answer;
    }
}