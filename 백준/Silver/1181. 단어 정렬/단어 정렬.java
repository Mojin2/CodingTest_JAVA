import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			set.add(st.nextToken());
		}

		String[] arr = new String[set.size()];
		int index = 0;
		for (String str : set) {
			arr[index++] = str;
		}

		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int o1L = o1.length();
				int o2L = o2.length();

				if (o1L == o2L) {
					return o1.compareTo(o2);
				}
				return o1L - o2L;
			}

		});
		for (String str : arr) {
			System.out.println(str);
		}
	}
}