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
		int M = Integer.parseInt(st.nextToken());

		// 2차원 배열 받아오기
		int[][] board = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 누적합 배열 만들기 
		for (int i = 1 ;i <= N;i++) {
			for (int j = 1 ;j <= N;j++) {
				board[i][j] = board[i][j]+ board[i-1][j]+ board[i][j-1] - board[i-1][j-1];  
			}
		}
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			sb.append(board[x2][y2] - board[x1-1][y2] - board[x2][y1-1] + board[x1-1][y1-1]).append("\n");
			
		}
		System.out.println(sb);
	}
}
//1 2 3 4
//2 3 4 5
//3 4 5 6
//4 5 6 7

//(2,2) -> (3,4)
//(3,1) (1,4)
//[[0, 0, 0, 0, 0], 
// [0, 1, 3, 6, 10], 
// [0, 3, 8, 15, 24], 
// [0, 6, 15, 27, 42], 
// [0, 10, 24, 42, 64]]