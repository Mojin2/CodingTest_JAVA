import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String str = st.nextToken();
		int num = Integer.parseInt(st.nextToken());
		
		int answer = Integer.parseInt(str,num);
		System.out.println(answer);
		
	}
}

//3
//3 7
//15 7
//5 2

// 3 7, 5 2, 15 7
//13 5 15 7
//12