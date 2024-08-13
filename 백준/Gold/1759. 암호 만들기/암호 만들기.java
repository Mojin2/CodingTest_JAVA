import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

//		String[][] board = new String[N][M];
//		String[][] startWidthW = new String[N][M];
//		String[][] startWidthB = new String[N][M];
//
//
//		for (int i = 0 ;i < N;i++) {
//			st = new StringTokenizer(br.readLine());
//			board[i] = st.nextToken().split("");
//		}
//		System.out.println(Arrays.deepToString(board));
//		
//		// W로 시작하는 정석 보드 
//		for (int i = 0 ;i < N;i++) {
//			
//		}
//		
//		// B로 시작하는 정석 보드 

		String[] arr = new String[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = st.nextToken();
		}

		Arrays.sort(arr);

		backtrack(arr, new String[N], new boolean[arr.length], 0, 0, N);
	}

	public static void backtrack(String[] arr, String[] out, boolean[] visited, int start, int depth, int r) {
		if (depth == r) {
			int countM = 0;
			int countJ = 0;
			for (String a : out) {
				if (a.equals("a") || a.equals("e") || a.equals("i") || a.equals("o") || a.equals("u")) {
					countM++;
				} else {
					countJ++;
				}
			}
			if (countM >= 1 && countJ >= 2) {
				for (String a : out) {
					System.out.print(a);
				}
				System.out.println();

			}
			return;
		}

		for (int i = start; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				out[depth] = arr[i];
				backtrack(arr, out, visited, i + 1, depth + 1, r);
				visited[i] = false;
			}
		}
	}
}