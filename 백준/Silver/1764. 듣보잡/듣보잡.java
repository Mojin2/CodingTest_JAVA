//3 4
//ohhenrie
//charlie
//baesangwook
//obama
//baesangwook
//ohhenrie
//clinton

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		TreeSet<String> listen = new TreeSet<>();
		TreeSet<String> see = new TreeSet<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			listen.add(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			see.add(st.nextToken());
		}

		listen.retainAll(see);

		System.out.println(listen.size());
		for (String name : listen) {
			System.out.println(name);
		}
	}
}