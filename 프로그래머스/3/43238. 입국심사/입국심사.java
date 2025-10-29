import java.util.*;

class Solution {
    public static long solution(int n, int[] times) {
        long answer = Integer.MAX_VALUE;
        
        long max = 0L;
        
        for (int time : times){
            max = Math.max(max,time);
        }
        
        long min = 1L; // 42
        max = max * (long)n; // 60
        
        
        while (min <= max){
            long mid = (max + min)/2;
            
            long sum = 0;
            for (int time : times){
                sum += mid/time;
            }
            
            if (n <= sum){
                max = mid-1;
                answer = mid;
            } else {
                min = mid+1;
            }
        }
        
        return answer;
	
    }
}