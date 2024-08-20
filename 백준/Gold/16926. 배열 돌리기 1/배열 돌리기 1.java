import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] result = new int[N][M];
		for (int i = 0; i < R; i++) {
			arr = rotate(arr);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ;i < N;i++) {
			for (int j = 0 ;j < M;j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	public static int[][] rotate(int[][] arr) {
        int top = 0;
        int left = 0;
        int bottom = N-1;
        int right = M-1;
        int z = Math.min(N, M);
        z /= 2;
        int[][] tmp = new int[N][M];
        
        int count = 0;
        while (true) {
        	// 왼쪽으로 밀기 
            for (int i = left+1; i <= right; i++) {
                tmp[top][i-1] = arr[top][i];
            }
     
            // 위쪽으로 밀기 
            for (int i = top+1; i <= bottom; i++) {
            	tmp[i-1][right]= arr[i][right]; 
            }
            
            // 오른쪽으로 밀기 
            for (int i = right; i > left; i--) {
            	tmp[bottom][i] = arr[bottom][i-1]; 
            }
            	
            // 아래쪽으로 밀기
            for (int i = bottom; i > top ;i--) {
            	tmp[i][left] = arr[i-1][left];
            }
            
            top++; left++; bottom--; right--;
            
            count++;
            if (count == z ) break;
           
        }
        
        
        return tmp;
    }

}

// 4 4 2

// 1  2  3  4
// 5  6  7  8
// 9 10 11 12
//13 14 15 16

// 2 : 0,1 -> 0,0 -> 1,0
// 7 : 1,2 -> 1,1 -> 2,1