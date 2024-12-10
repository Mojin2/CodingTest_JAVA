import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

//5
//6 3 2 10 -10
//8
//10 9 -5 2 3 4 5 -10

// 1. 리스트의 contain메서드를 활용한 방법 -> 시간초과
// 2. 어떻게 풀까 map?
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] have = new int[N];
		ArrayList<Integer> have2 = new ArrayList<>();
		HashMap<Integer, Integer> have3 = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			have[i] = num;
			have2.add(num);
			have3.put(num, 1);
		}

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (have3.get(num) != null) {
				sb.append("1").append(" ");
			} else {
				sb.append("0").append(" ");
			}
		}
		System.out.println(sb);
	}
}