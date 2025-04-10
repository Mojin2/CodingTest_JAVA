//B
//ABBA

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//문자열의 뒤에 A를 추가한다.
//문자열을 뒤집고 뒤에 B를 추가한다.

public class Main {

	static String t;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String S = st.nextToken();

		st = new StringTokenizer(br.readLine());
		String T = st.nextToken();

		while (true) {
			char lastChar = T.charAt(T.length() - 1);
			if (lastChar == 'A') {
				T = T.substring(0, T.length() - 1);
			} else if (lastChar == 'B') {
				T = T.substring(0, T.length() - 1);
				StringBuilder sb = new StringBuilder(T);
				T = sb.reverse().toString();
			}

			if (T.equals(S)) {
				System.out.println("1");
				break;
			}

			if (T.length() == 1) {
				System.out.println("0");
				break;
			}
		}
	}
}
