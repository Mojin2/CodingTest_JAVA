import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = 5;
		int M = 0;
		String[] arr = new String[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken();
		}

		int max = Integer.MIN_VALUE;
		for (String str : arr) {
			if (str.length() > max) {
				max = str.length();
			}
		}

		String[][] tmp = new String[N][];

		for (int i = 0; i < N; i++) {
			tmp[i] = arr[i].split("");
		}

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < N; j++) {
				try {
					System.out.print(tmp[j][i]);
				} catch (IndexOutOfBoundsException e) {
					continue;
				}
			}
		}

	}

}
