import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String str = st.nextToken();
		str = str.toLowerCase();
		
		String[] arr = str.split("");
		
		Map<String,Integer> map = new HashMap<>();
		
		for (int i = 0 ;i < arr.length;i++) {
			if (map.containsKey(arr[i])) {
				int tmp = map.get(arr[i])+1;
				map.put(arr[i], tmp);
			} else {
				map.put(arr[i], 1);
			}
		}
				
		int max =  Collections.max(map.values());
		
		int count = 0;
		for (Map.Entry<String, Integer> entrySet : map.entrySet()) {
            if ( entrySet.getValue() == max ) count++;
        }
		
		if (count >= 2) {
			System.out.println("?");
		} else {
			for (String key : map.keySet()) {
				if (map.get(key) == max) {
					System.out.println(key.toUpperCase());
				}
			}
		}
		
		
		

	}

}
