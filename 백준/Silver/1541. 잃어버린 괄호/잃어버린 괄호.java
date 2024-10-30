import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String str = st.nextToken();

		//System.out.println(str);

		int answer = 0;

		String num = "";

		int index = 0;

		for (int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if (cur == '-' || cur == '+') {
				answer += Integer.parseInt(num);
				index = i;
				num = "";
				break;
			} else {
				num += cur;
			}
		}
		boolean flag = false;
		if (index == 0) {
			answer += Integer.parseInt(num);
			System.out.println(answer);
			return;
		}
		char curOperation = str.charAt(index);
		index++;

		for (int i = index; i < str.length(); i++) {
			char cur = str.charAt(i);
			if (cur != '-' && cur != '+') {
				num += cur;
			} else {
				if (!flag) {
					if (curOperation == '-') {
//						System.out.println("1 :::" + num);
						answer -= Integer.parseInt(num);
						curOperation = cur;
						flag = true;
						num = "";
					} else {
//						System.out.println("2 :::" + num);
						answer += Integer.parseInt(num);
						curOperation = cur;
						num = "";
					}
				} else {
//					System.out.println("3 :::" + num);
					answer -= Integer.parseInt(num);
					num = "";
				}
			}
			
			if (i == str.length()-1) {
				if (flag) {
					answer -= Integer.parseInt(num);
				} else {
					if (curOperation == '+') {
						answer += Integer.parseInt(num);
					} else {
						answer -= Integer.parseInt(num);
					}
				}
			}

		}

		System.out.println(answer);
	}
}