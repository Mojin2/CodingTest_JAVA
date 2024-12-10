import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

//5 11
//baekjoononlinejudge
//startlink
//codeplus
//sundaycoding
//codingsh
//baekjoon
//codeplus
//codeminus
//startlink
//starlink
//sundaycoding
//codingsh
//codinghs
//sondaycoding
//startrink
//icerink
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;

//		String[] list = new String[N];
		HashSet<String> list = new HashSet<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String target = st.nextToken();
			if (list.contains(target)) {
				count++;
			}
		}
		System.out.println(count);
	}
}