import java.io.BufferedReader;
import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int count = 0;
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String[] tmp = st.nextToken().split("");
			List<String> lists = new ArrayList<>();
			for (int k = 0; k < tmp.length; k++) {
				if (k == 0) {
					lists.add(tmp[k]);
				} else {
					if (lists.contains(tmp[k])) {
						if (tmp[k].equals(tmp[k - 1])) {
							if (k == tmp.length - 1) {
								count++;
								break;
							}
						} else {
							lists.add(tmp[k]);
							break;
						}
					} else {
						lists.add(tmp[k]);
					}
				}
				if (k == tmp.length - 1) {
					//System.out.println(Arrays.toString(tmp));
					count++;
				}
			}
		}
		System.out.println(count);

	}

}
