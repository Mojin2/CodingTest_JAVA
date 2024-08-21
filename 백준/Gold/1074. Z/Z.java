import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);
        findOrder(size, 0, 0);
    }

    private static void findOrder(int size, int row, int col) {
        if (size == 1) {
            System.out.println(count);
            return;
        }

        int newSize = size / 2;

        // 1사분면
        if (r < row + newSize && c < col + newSize) {
            findOrder(newSize, row, col);
        } 
        // 2사분면
        else if (r < row + newSize && c >= col + newSize) {
            count += newSize * newSize;
            findOrder(newSize, row, col + newSize);
        } 
        // 3사분면
        else if (r >= row + newSize && c < col + newSize) {
            count += 2 * newSize * newSize;
            findOrder(newSize, row + newSize, col);
        } 
        // 4사분면
        else {
            count += 3 * newSize * newSize;
            findOrder(newSize, row + newSize, col + newSize);
        }
    }
}