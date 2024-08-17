import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] required = new int[4];  // A, C, G, T의 최소 요구 개수
    static int[] current = new int[4];   // 현재 슬라이딩 윈도우 내의 A, C, G, T 개수
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());  // DNA 문자열의 길이
        int P = Integer.parseInt(st.nextToken());  // 비밀번호로 사용할 부분문자열의 길이

        char[] str = br.readLine().toCharArray();  // DNA 문자열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            required[i] = Integer.parseInt(st.nextToken());  // A, C, G, T의 최소 요구 개수
        }

        // 처음 윈도우 세팅
        for (int i = 0; i < P; i++) {
            addChar(str[i]);
        }

        // 초기 윈도우가 조건을 만족하는지 확인
        if (check()) {
            count++;
        }

        // 슬라이딩 윈도우
        for (int i = P; i < S; i++) {
            addChar(str[i]);       // 새로 추가되는 문자 처리
            removeChar(str[i - P]); // 윈도우에서 벗어나는 문자 처리

            if (check()) {  // 조건을 만족하면 카운트 증가
                count++;
            }
        }

        System.out.println(count);
    }

    // 문자를 추가할 때 개수 갱신
    private static void addChar(char c) {
        switch (c) {
            case 'A':
                current[0]++;
                break;
            case 'C':
                current[1]++;
                break;
            case 'G':
                current[2]++;
                break;
            case 'T':
                current[3]++;
                break;
        }
    }

    // 문자를 제거할 때 개수 갱신
    private static void removeChar(char c) {
        switch (c) {
            case 'A':
                current[0]--;
                break;
            case 'C':
                current[1]--;
                break;
            case 'G':
                current[2]--;
                break;
            case 'T':
                current[3]--;
                break;
        }
    }

    // 현재 슬라이딩 윈도우가 조건을 만족하는지 확인
    private static boolean check() {
        for (int i = 0; i < 4; i++) {
            if (current[i] < required[i]) {
                return false;
            }
        }
        return true;
    }
}