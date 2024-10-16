import java.util.*;
class Solution {
   public int solution(int[][] land) {
		int answer = Integer.MIN_VALUE;
		
		int[] dp = new int[land[0].length];

		ArrayList<Integer[]> location = new ArrayList<>();
		ArrayList<Integer> size = new ArrayList<>();

		int N = land.length;
		int M = land[0].length;

		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && land[i][j] == 1) {
					BFS(i, j, visited, N, M, location, size, land,dp);
				}
			}
		}

//		for (Integer a : size) {
//			System.out.print(a + " ");
//		}
//		System.out.println();
//
//		for (Integer[] aa : location) {
//			System.out.println(Arrays.toString(aa));
//		}

		int[] sizeArr = new int[size.size()];
		int sizeArrIndex = 0;
		for (Integer a : size) {
			sizeArr[sizeArrIndex++] = a;
		}

//		for (int i = 0; i < M; i++) {
//			int sum = 0;
//			int idx = 0;
//			for (Integer[] a : location) {
//				boolean flag = false;
//				for (int j = 0; j < a.length; j++) {
//					if (a[j] == i) {
//						sum += sizeArr[idx];
//						flag = true;
//						break;
//					}
//				}
//				idx++;
//			}
//			answer = Math.max(answer, sum);
//		}
		for (int i = 0 ;i <dp.length;i++) {
			answer = Math.max(answer, dp[i]);
		}

		return answer;
	}

	public void BFS(int i, int j, boolean[][] visited, int N, int M, ArrayList<Integer[]> location,
			ArrayList<Integer> size, int[][] land, int[] dp) {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		// 섬 관련된 변수 설정
		int iSlandSize = 0;
//		ArrayList<Integer> iSlandNum = new ArrayList<>();
		HashSet<Integer> iSlandNum = new HashSet<>();

		ArrayDeque<Integer[]> queue = new ArrayDeque<>();
		queue.add(new Integer[] { i, j, 0 });
		visited[i][j] = true;
		int count = 0;

		while (!queue.isEmpty()) {
			Integer[] tmp = queue.pollLast();
			int cx = tmp[0];
			int cy = tmp[1];
			count++;
			iSlandNum.add(cy);
			int cnt = tmp[2];
			iSlandSize = Math.max(iSlandSize, cnt);

			for (int k = 0; k < 4; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];

				if (nx >= N || nx < 0 || ny >= M || ny < 0 || visited[nx][ny])
					continue;

				if (!visited[nx][ny] && land[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.add(new Integer[] { nx, ny, cnt + 1 });
				}
			}
		}
		
//		System.out.println(iSlandNum);
		for (Integer a : iSlandNum) {
			dp[a]+= count; 
		}
//		Integer[] tmp = Arrays.stream(iSlandNum.stream().mapToInt(a -> a).toArray()).boxed().toArray(Integer[]::new);
////		System.out.println(Arrays.toString(tmp));
//		location.add(tmp);
//		size.add(count);

	}
}