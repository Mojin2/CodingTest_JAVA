import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Integer[] arr = new Integer[9];
		boolean[] check = new boolean[9];
		int sum = 0;
		
		for (int i = 0 ;i < 9;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());  
			sum += arr[i];
		}
		Arrays.sort(arr,(a,b)->a-b);

		boolean flag = false;
		
		for (int i = 0 ;i < 9; i++) {
			for (int j = i + 1 ; j < 9 ; j++) {
				if (sum - arr[i]- arr[j]  == 100) {
					check[i]= true;
					check[j]= true; 
					flag = true;
				}
				if (flag) break;
			}
			if (flag) break;
		}
		
		for (int i = 0 ;i <9;i++) {
			if (!check[i]) {
				System.out.println(arr[i]);
			}
		}
	}
}