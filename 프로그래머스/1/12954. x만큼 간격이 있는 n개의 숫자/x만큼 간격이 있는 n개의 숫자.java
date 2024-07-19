import java.util.*;
import java.util.stream.*;

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0;i < answer.length;i++){
            answer[i] = x;
        }
        return LongStream.range(1,n+1).map(i->i*x).toArray();
        
    }
}