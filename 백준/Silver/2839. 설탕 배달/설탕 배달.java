import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int fiveCount = N / 5;

		while (true) {
			int tmp = N - 5 * fiveCount;
			if (tmp % 3 != 0) {
				fiveCount--;
				if (fiveCount < 0) {
					System.out.println(-1);
					break;
				}
				continue;
			} else {
				System.out.println(fiveCount + tmp / 3);
				break;
			}

		}

	}

}