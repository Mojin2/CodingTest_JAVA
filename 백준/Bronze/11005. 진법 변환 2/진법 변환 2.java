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

		int str = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		
		String answer = Integer.toString(str,num);
		System.out.println(answer.toUpperCase());
		
	}
}