import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        Arrays.sort(arr);
        int[] an = {-1};
        int[] answer = Arrays.stream(arr).filter(i->i%divisor == 0).toArray();
        if (answer.length == 0) return an;
        return answer;
    }
}