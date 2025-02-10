import java.util.*;
class Solution {
    
    static ArrayList<Integer>[] graph;
	static int V;
	static boolean[] visited;
	static HashMap<Integer, Integer> map;
    static int maxDistance;

    
    public  int solution(int n, int[][] edge) {
		int answer = 0;
		map = new HashMap<>();
        maxDistance = Integer.MIN_VALUE;


		V = n;
		graph = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[V + 1];

		for (int i = 0; i < edge.length; i++) {
			int from = edge[i][0];
			int to = edge[i][1];

			graph[from].add(to);
			graph[to].add(from);
		}

		int start = 1;

		answer = BFS(1);
		System.out.println(answer);
//		System.out.println(map);
        int maxKey = Collections.max(map.keySet()); // 가장 큰 key 찾기
		int maxValue = map.get(maxKey); // 해당 key의 value 가져오기


		return maxValue;
	}
    
    private static int BFS(int start) {
		int last = 0;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { start, 0 });
		visited[start] = true;

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int cur = tmp[0];
			int distance = tmp[1];

			if (map.containsKey(distance)) {
				map.put(distance, map.get(distance) + 1);
				last = map.get(distance);
			} else {
				map.put(distance, 1);
			}
            maxDistance = Math.max(maxDistance, distance);


			for (int next : graph[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(new int[] { next, distance + 1 });
				}
			}
		}

		return last;
	}
}