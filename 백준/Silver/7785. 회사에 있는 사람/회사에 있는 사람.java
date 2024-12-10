import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

//4
//Baha enter
//Askar enter
//Baha leave
//Artem enter

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String entrance = st.nextToken();

			if (entrance.equals("enter")) {
				set.add(name);
			} else {
				if (set.contains(name)) {
					set.remove(name);
				}
			}
		}
		
		TreeSet<String> sortedSet = new TreeSet<>(Collections.reverseOrder());
        sortedSet.addAll(set);

        // 출력
        for (String item : sortedSet) {
            System.out.println(item);
        }
	}
}