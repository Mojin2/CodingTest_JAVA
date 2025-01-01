//4
//abcd
//abe
//abc
//abchldp

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static int[] answer;
	static int max = Integer.MIN_VALUE;
	static HashMap<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		String[] words = new String[N];
		answer = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			words[i] = st.nextToken();
			map.put(words[i], i);
		}

		String[] original = Arrays.copyOf(words, N);
		Arrays.sort(words);

//		System.out.println(Arrays.toString(words));

		// 계산
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (i == j)
					continue;
				int count = 0;
				String str1 = words[i];
				String str2 = words[j];

				int len = Math.min(str1.length(), str2.length());

				for (int k = 0; k < len; k++) {
					if (str1.charAt(k) == str2.charAt(k)) {
						count++;
					} else {
						break;
					}
				}

				if (count < max) {
					break;
				}

				int str1Index = map.get(str1);
				int str2Index = map.get(str2);

				int one = Math.min(str1Index, str2Index);
				int two = Math.max(str1Index, str2Index);

				if (count > max) {
					max = count;
					answer[0] = one;
					answer[1] = two;
				} else if (count == max) {
					if (answer[0] > one) {
						answer[0] = one;
						answer[1] = two;
					} else if (answer[0] == one && answer[1] > two) {
						answer[1] = two;
					}
				}
			}
		}
		System.out.println(original[answer[0]]);
		System.out.println(original[answer[1]]);

//		String tmp = "newString";
//		System.out.println(tmp.charAt(0));

	}
}