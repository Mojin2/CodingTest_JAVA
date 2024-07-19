import java.util.stream.*;
import java.util.*;

class Solution {
    public long solution(int a, int b) {
        int tmpA = (int) Math.min(a,b);
        int tmpB = (int) Math.max(a,b);
        return LongStream.range(tmpA,tmpB+1).sum();
    }
}