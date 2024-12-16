class Solution {
    public int solution(int[] cards) {
        boolean[] check = new boolean[cards.length];
		int maxFirst = Integer.MIN_VALUE;
		int maxSecond = Integer.MIN_VALUE;

		for (int i = 0; i < cards.length; i++) {
			int num = cards[i];
			if (check[num - 1] == false) {
//			System.out.println(num);
				int cnt = DFS(cards[num - 1], check, cards, 0);
//				System.out.println("cnt:::" + cnt);
				if (maxFirst < cnt) {
                    maxSecond = maxFirst;
					maxFirst = cnt;
				} else if (maxSecond < cnt) {
					maxSecond = cnt;
				}
			}
		}
if (maxSecond == Integer.MIN_VALUE) {
			return 0;
		}
        
		return maxFirst * maxSecond;
    }
    
    private static int DFS(int num, boolean[] check, int[] cards, int cnt) {
		if (check[num - 1] == true)
			return cnt;

		check[num - 1] = true;
		return DFS(cards[num - 1], check, cards, cnt + 1);

	}
}