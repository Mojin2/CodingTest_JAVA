//2 4 1 1
//1 2 3 4 0
//5 7 9 11 4
//0 5 6 7 8

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

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		int[][] arr = new int[H + X][W + Y];

		int[][] answer = new int[H][W];

		for (int i = 0; i < H + X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W + Y; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		3 3 1 1
//		1 2 3 0
//		4 6 8 3
//		7 12 14 6
//		0 7 8 9
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				int someX = i - X;
				int someY = j - Y;
				if (someX >= 0 && someX < H && someY >= 0 && someY < W) {
					answer[i][j] = arr[i][j] - answer[someX][someY];
				} else {
					answer[i][j] = arr[i][j];
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(answer[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}