import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        int[] counts = new int[10];
        while (n>0){
            counts[(int)(n % 10)]++;
            n /= 10;
        }
        
        int di = 1;
        for (int i = 0;i <10 ;i++){
            if (counts[i] != 0){
                for (int j = 0;j < counts[i];j++){
                    answer += ((long)i * (long)di);
                    di *= 10;
                }
            }
        }
        System.out.println(Arrays.toString(counts));
        return answer;
    }
}