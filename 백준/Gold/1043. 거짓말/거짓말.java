import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer> tru = new ArrayList<>();
		st = new StringTokenizer(br.readLine());

		int cn = Integer.parseInt(st.nextToken());

		for (int j = 0; j < cn; j++) {
			tru.add(Integer.parseInt(st.nextToken()));
		}

		int[] truth = tru.stream().mapToInt(num -> num).toArray();

//		System.out.println(truth);

		ArrayList<Integer>[] party = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());

			for (int j = 0; j < cnt; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		// truth = {1};
		// party = {[1],[2],[3],[4],[4,1]}

		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}

		// 처음 돌면서 유니온 파인드
		for (int i = 0; i < M; i++) {
			int[] tmp = party[i].stream().mapToInt(num -> num).toArray();
			for (int a = 0; a < tmp.length; a++) {
				for (int b = 0; b < tmp.length; b++) {
					if (a == b)
						continue;

					if (find(tmp[a]) != find(tmp[b])) {
						union(tmp[a], tmp[b]);
					}
				}
			}
		}

//		System.out.println(Arrays.toString(parent));
		// 두번째 돌면서 진실을 말하지 못하는 파티 갯수 체크
		int ans = 0;
		for (int i = 0; i < M; i++) {
			boolean fla = false;
			int[] tmp = party[i].stream().mapToInt(num -> num).toArray();
			for (int a = 0; a < tmp.length; a++) {
				int cur = tmp[a];
				boolean flag = false;
				for (int k = 0; k < truth.length; k++) {
					int t = truth[k];
					if (find(cur) == find(t)) {
						flag = true;
						break;
					}
				}
				if (flag) {
					fla = true;
					break;
				}
			}
			if (!fla)
				ans++;
		}

		System.out.println(ans);

	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return;

		if (x > y)
			parent[x] = y;
		else
			parent[y] = x;
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		} else
			return parent[x] = find(parent[x]);
	}
}