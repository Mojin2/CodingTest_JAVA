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

		String[][] board = new String[N][M];
		String[][] startWidthW = new String[8][8];
		String[][] startWidthB = new String[8][8];


		for (int i = 0 ;i < N;i++) {
			st = new StringTokenizer(br.readLine());
			board[i] = st.nextToken().split("");
		}
//		System.out.println(Arrays.deepToString(board));
		
		// W로 시작하는 정석 보드 
		String start1 = "W";
		for (int i = 0 ;i < 8;i++) {
			for (int j = 0 ;j < 8;j++) {
				startWidthW[i][j]= start1;
				if (j == 7) continue;
				start1 = start1.equals("W")? "B":"W";
			}
		}
		
		// B로 시작하는 정석 보드 
		String start2 = "B";
		for (int i = 0 ;i < 8;i++) {
			for (int j = 0 ;j < 8;j++) {
				startWidthB[i][j]= start2;
				if (j == 7) continue;
				start2 = start2.equals("W")? "B":"W";
			}
		}
//		System.out.println(Arrays.deepToString(startWidthW));

		int min = Integer.MAX_VALUE;
		
		for (int i = 0;i <= N-8;i++) {
			for (int j = 0 ;j <= M-8;j++) {
				int sum1 = 0;
				int sum2 = 0;
				for (int a = 0 ;a <8;a++) {
					for (int b = 0 ; b< 8;b++) {
						if (!board[a+i][b+j].equals(startWidthW[a][b])) sum1++;
						if (!board[a+i][b+j].equals(startWidthB[a][b])) sum2++;

					}
				}
				min = Math.min(sum1, min);
				min = Math.min(sum2, min);
			}
		}
		
		System.out.println(min);

	}


}