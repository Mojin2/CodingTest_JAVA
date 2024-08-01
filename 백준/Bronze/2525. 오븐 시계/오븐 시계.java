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

		st = new StringTokenizer(br.readLine());
		int time = Integer.parseInt(st.nextToken());
		
		int calMin = minute + time;
		if (calMin >=60) {
			hour += calMin / 60;
			if (hour >=24) {hour-=24;}
			calMin %= 60;
			System.out.println(hour+" "+calMin);

		} else {
			System.out.println(hour+" "+calMin);
		}
	}

}
