//3 5
//1 2 4
//2 3 4 5 6

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

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashSet<Integer> arr1 = new HashSet<>();
		HashSet<Integer> arr3 = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr1.add(num);
			arr3.add(num);
		}

		HashSet<Integer> arr2 = new HashSet<>();
		HashSet<Integer> arr4 = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr2.add(num);
			arr4.add(num);
		}

		arr1.removeAll(arr2);
		arr4.removeAll(arr3);

		int answer = arr1.size() + arr4.size();
		System.out.println(answer);

	}
}