import java.util.*;

class Solution {
    public long solution(long n) {
        if (Math.sqrt(n) % 1 == 0){
            long t = (long)Math.sqrt(n);
            return (t+1)*(t+1);
        } else return -1;
    }
}