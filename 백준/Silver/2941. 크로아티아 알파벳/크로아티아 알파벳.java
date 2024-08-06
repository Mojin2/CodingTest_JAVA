import java.io.BufferedReader;
import java.io.Console;
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
		
		int count = 0;
		String[] alphas = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		String str = st.nextToken();

		for (String alpha : alphas) {
			while (str.contains(alpha)) {
				str = str.replace(alpha,"*");
				
			}
		}
		
		System.out.println(str.length());
		
	}

}
