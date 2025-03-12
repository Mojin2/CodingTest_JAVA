import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

//4
//abakada
//alpabet
//tagalog
//ako

//a b k d e g h i l m n ng o p r s t u w y
public class Main {

	static HashMap<Character, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		map = new HashMap<>();
		Character[] alpha = { 'a', 'b', 'k', 'd', 'e', 'g','h', 'i', 'l', 'm', 'n', '-', 'o', 'p', 'r', 's', 't', 'u',
				'w', 'y' };
		for (int i = 0; i < alpha.length; i++) {
			map.put(alpha[i], i + 1);
		}

		int N = Integer.parseInt(st.nextToken());

		String[] list = new String[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken();
		}

		Arrays.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int o1Index = 0;
				int o2Index = 0;

				while (o1Index < o1.length() && o2Index < o2.length()) {
					char o1Char = o1.charAt(o1Index++);
					char o2Char = o2.charAt(o2Index++);

					if (o1Index < o1.length() && o1Char == 'n') {
						if (o1.charAt(o1Index) == 'g') {
							o1Char = '-';
							o1Index++;
						}
					}

					if (o2Index < o2.length() && o2Char == 'n') {
						if (o2.charAt(o2Index) == 'g') {
							o2Char = '-';
							o2Index++;
						}
					}

					if (o1Char == o2Char) {
						continue;
					}

					return map.get(o1Char) - map.get(o2Char);
				}

				return o1.length() - o2.length();

			}
		});

		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
}