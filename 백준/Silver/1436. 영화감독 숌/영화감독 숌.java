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
		int count = 1;
		int num = 666;
		while (true) {
			if (check(num)) {
				if (count == N) {
					System.out.println(num);
					break;
				}

				count++;
			}
			num++;

		}
	}

	private static boolean check(int n) {
		int count = 0;
		while (n > 0) {
			int num = n % 10;
			n = n / 10;
			if (num == 6) {
				count++;
			} else {
				count = 0;
			}
			
			if (count == 3) {
				return true;
			}
		}

		return false;
	}
}