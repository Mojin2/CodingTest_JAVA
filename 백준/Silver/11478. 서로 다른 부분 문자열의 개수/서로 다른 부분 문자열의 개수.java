//ababc

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String str = st.nextToken();

		int max = str.length();
		HashSet<String> set = new HashSet<>();

		int len = 1;

		for (int i = 1; i <= max; i++) {
			for (int k = 0; k <= str.length() - i; k++) {
				set.add(str.subSequence(k, k + i).toString());
			}
		}

		System.out.println(set.size());
	}
}