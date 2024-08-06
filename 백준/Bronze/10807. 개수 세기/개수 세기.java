import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0;i <N;i ++ ) {
			arr[i]=  Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		st = new StringTokenizer(br.readLine());

		int target = Integer.parseInt(st.nextToken());
		for (int i = 0 ;i < N;i++) {
			if (arr[i]== target){
				count++;
			}
		}
		
		System.out.println(count);
		

	}

}
