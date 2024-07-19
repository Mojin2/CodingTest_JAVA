import java.util.*;

class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        return Arrays.stream(arr).mapToDouble(i->(double)i).average().orElse(0.0);
    }
}