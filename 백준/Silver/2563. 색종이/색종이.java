import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(arr, (a, b) -> a[0] - b[0]);

		boolean[][] board = new boolean[101][101];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int a = arr[i][0]; a < arr[i][0] + 10; a++) {
				for (int b = arr[i][1]; b < arr[i][1] + 10; b++) {
					if (!board[a][b]) {
						board[a][b] = true;
						sum++;
					}
				}
			}
		}
		System.out.println(sum);
	}
}

//3
//3 7
//15 7
//5 2

// 3 7, 5 2, 15 7
//13 5 15 7
//12