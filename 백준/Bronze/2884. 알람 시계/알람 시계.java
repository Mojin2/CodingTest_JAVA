import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());

		int calMin = minute - 45;
		if (calMin < 0) {
			minute = 60+calMin;
			hour -= 1;
			if (hour== -1) {hour = 23;}
			System.out.println(hour+" "+minute);

		} else {
			System.out.println(hour+" "+calMin);

		}
	}

}
