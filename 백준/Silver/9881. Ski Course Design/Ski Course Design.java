import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] hills = new int[N];
        for (int i = 0; i < N; i++) {
            hills[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(hills); // 오름차순 정렬
        
        int minCost = Integer.MAX_VALUE;

        // 가능한 모든 높이 범위를 탐색 (low ~ low+17)
        for (int low = 0; low <= 100 - 17; low++) {
            int high = low + 17;
            int cost = 0;

            for (int h : hills) {
                if (h < low) {
                    cost += (low - h) * (low - h); // 높이 올리는 비용
                } else if (h > high) {
                    cost += (h - high) * (h - high); // 높이 낮추는 비용
                }
            }

            minCost = Math.min(minCost, cost); // 최소 비용 갱신
        }

        System.out.println(minCost);
    }
}