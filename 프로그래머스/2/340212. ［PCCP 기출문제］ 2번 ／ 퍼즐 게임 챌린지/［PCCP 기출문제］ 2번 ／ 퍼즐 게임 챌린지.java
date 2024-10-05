class Solution {
    	public int solution(int[] diffs, int[] times, long limit) {
		int start = 1;
		int end = Integer.MIN_VALUE;

		for (int i = 0; i < diffs.length; i++) {
			end = Math.max(diffs[i], end);
		}

		while (start <= end) {
			int level = (start + end) / 2;

			long time = 0;
			for (int i = 0; i < diffs.length; i++) {
				if (level >= diffs[i]) {
					time += times[i];
				} else {
					long longCount = diffs[i] - level;
					long prevTime = 0;
					if (i > 0) {
						prevTime = times[i - 1];
					}
					time += (prevTime + times[i]) * longCount;
					time += times[i];
				}
			}

			if (time > limit) {
				start = level + 1;
			} else {
				end = level - 1;
			}
		}
		
		return start;
	}
}