import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int N = (int) Math.pow(10, T);

        // 비트마스크를 위한 배열 크기 설정
        isPrime = new int[(N / 32) + 1]; // 32 비트 사용

        // 초기화: 모든 수를 소수라고 가정 (1로 설정)
        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = ~0; // 모든 비트를 1로 설정 (소수로 간주)
        }

        // 0과 1은 소수가 아니므로 비트 0으로 설정
        setNonPrime(0);
        setNonPrime(1);

        // 에라토스테네스의 체로 소수 판별
        for (int i = 2; i * i <= N; i++) {
            if (isPrime(i)) {
                for (int j = i * i; j <= N; j += i) {
                    setNonPrime(j);
                }
            }
        }

        int start = (int) Math.pow(10, T - 1);
        int end = (int) Math.pow(10, T);

        for (int i = start; i < end; i++) {
            int idx = 1;
            boolean flag = false;
            while (idx <= i) {
                int num = i / idx;
                if (!isPrime(num)) {
                    flag = true;
                    break;
                }
                idx *= 10;
            }
            if (!flag) {
                System.out.println(i);
            }
        }
    }

    // 소수 여부를 확인하는 함수 (비트마스크 사용)
    private static boolean isPrime(int num) {
        return (isPrime[num / 32] & (1 << (num % 32))) != 0;
    }

    // 소수가 아닌 숫자를 비트마스크에 설정하는 함수
    private static void setNonPrime(int num) {
        isPrime[num / 32] &= ~(1 << (num % 32));
    }
}