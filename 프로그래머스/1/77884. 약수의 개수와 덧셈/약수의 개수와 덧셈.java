import java.util.stream.*;
import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = IntStream.range(left,right+1).filter(v->Math.sqrt(v)%1!=0).sum();
        int ans = IntStream.range(left,right+1).filter(v->Math.sqrt(v)%1==0).sum();
        return answer-ans;
    }
}