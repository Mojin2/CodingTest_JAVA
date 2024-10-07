class Solution {
    public static long solution(int n, int[] times) {
		long answer = 0;
		long max = Integer.MIN_VALUE;

		for (int i = 0; i < times.length; i++) {
			max = Math.max(max, times[i]);
		}

		long start = 1;
		long end = max*n;

		while (start <= end) {
			long mid = (start + end) / 2;
//			System.out.println(mid);

			long count = 0;
			for (int i = 0; i < times.length; i++) {
				count += mid / times[i];
			}

//			if (count == n) {
//				System.out.println(mid);
//				return mid;
//			}

			if (count >= n) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		//System.out.println(end+1);
		return start;
	}
}