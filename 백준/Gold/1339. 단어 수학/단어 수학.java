import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int answer;
	static String[] strings;
	static String[] list;
	static ArrayList<Character> set ;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		answer = Integer.MIN_VALUE;
		list = new String[N];

		// Hashset에 저장해서 몇개의 알파벳을 가지고 있는지 확인
		set = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken();
			for (int j = 0; j < list[i].length(); j++) {
                if (!set.contains(list[i].charAt(j))) {
                    set.add(list[i].charAt(j));
                }
            }
		}

		int r = set.size();
		strings = new String[r];
		int index = 0;
//		for (String str : set) {
//			strings[index++] = str;
//		}

		int[] numbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		// System.out.println(Arrays.toString(strings));
		permutation(numbers, new int[r], new boolean[10], 0, r);
		System.out.println(answer);
	}

	public static void permutation(int[] numbers, int[] out, boolean[] visited, int cnt, int depth) {
		if (cnt == depth) {
			 if (depth == set.size()) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int num = 0;
                for (int j = 0; j < list[i].length(); j++) {
                    num *= 10;
                    num += out[ set.indexOf(list[i].charAt(j)) ];
                }
                sum += num;
            }
            answer = Math.max(answer, sum);
            return;
        }

			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				out[cnt] = numbers[i];
				permutation(numbers, out, visited, cnt + 1, depth);
				visited[i] = false;
			}
		}

	}

}