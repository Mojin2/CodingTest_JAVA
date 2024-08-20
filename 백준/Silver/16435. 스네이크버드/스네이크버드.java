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
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Integer[] arr = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ;i < N;i++) {
			arr[i]=  Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr,(a,b)->a-b);
//		System.out.println(Arrays.toString(arr));
		
		if (L < arr[0]) {
			System.out.println(L);
		} else {
			for (int i = 0 ;i < arr.length;i++) {
				if (L >= arr[i]) {
					L++;
				}
			}
			System.out.println(L);
		}
	}

}