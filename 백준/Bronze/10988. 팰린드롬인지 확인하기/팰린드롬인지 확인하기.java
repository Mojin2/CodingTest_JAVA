import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String str = st.nextToken();
		String[] arr = str.split("");
		for (int i = 0; i < str.length() / 2; i++) {
			if (!arr[i].equals(arr[str.length() - i - 1])) {

				System.out.println(0);
				return;
			}

		}
		System.out.println(1);

	}

}
