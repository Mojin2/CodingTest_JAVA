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

		int[] distance = new int[N - 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}

		int[] price = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

//		System.out.println(Arrays.toString(distance));
//		System.out.println(Arrays.toString(price));

		int totalPrice = 0;

		int pc = 0;

//		4
//		2 3 1
//		5 2 4 1

		for (int i = 0; i < N - 1; i++) {
			int curDis = distance[i];
			int tmp = curDis;
			int curPrice = price[i];
//			System.out.println("curPrice:::"+curPrice);

			for (int j = i+1; j < N; j++) {
				if (j == N - 1) {
					totalPrice += curPrice * tmp;
//					System.out.println("0:::"+totalPrice);
					tmp =0;
					i= j-1;
					break;
				}

				int nextPrice = price[j];
				if (curPrice >= nextPrice) {
					totalPrice += curPrice * tmp;
//					System.out.println("1:::"+totalPrice);
					tmp= 0;
					i = j-1;
					break;
				} else {
					tmp += distance[j];
				}
			}
		}
		
		System.out.println(totalPrice);
	}
}