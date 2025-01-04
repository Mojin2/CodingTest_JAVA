import java.io.*;
import java.util.*;

public class Main {
    static int N, top;
    static Map<String, Integer> points = new HashMap<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        top = Integer.parseInt(st.nextToken());

        points.put("0,0", 0);
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.put(x + "," + y, i);
        }

        System.out.println(BFS());
    }

    private static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0, 0 }); // x, y, count
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], count = cur[2];

            if (y == top) {
                return count;
            }

            // 현재 위치에서 상하좌우 및 대각선 2거리 이내만 탐색
            for (int dx = -2; dx <= 2; dx++) {
                for (int dy = -2; dy <= 2; dy++) {
                    int nx = x + dx;
                    int ny = y + dy;
                    String key = nx + "," + ny;

                    if (points.containsKey(key)) {
                        int idx = points.get(key);
                        if (!visited[idx]) {
                            visited[idx] = true;
                            queue.add(new int[] { nx, ny, count + 1 });
                        }
                    }
                }
            }
        }
        return -1;
    }
}