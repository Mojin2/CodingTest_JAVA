import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		Integer[] arr = new Integer[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Integer[] tmp = arr.clone();

		Arrays.sort(arr, (a, b) -> a - b);

		StringBuilder sb = new StringBuilder();

		HashMap<Integer, Integer> map = new HashMap<>();
		int order = 0;
		for (int i = 0; i < N; i++) {
			if (map.containsKey(arr[i])) {
			} else {
				map.put(arr[i], order++);
			}
		}

		for (int i = 0; i < N; i++) {
			sb.append(map.get(tmp[i]) + " ");
		}
		System.out.println(sb);

	}
}