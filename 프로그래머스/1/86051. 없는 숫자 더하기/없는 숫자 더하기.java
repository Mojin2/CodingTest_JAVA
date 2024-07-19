import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] index = {0,1,2,3,4,5,6,7,8,9};
        for (int i =0 ;i < index.length;i++){
            for (int j =0 ;j < numbers.length; j++){
                if (index[i] == numbers[j]) break;
                if (j == numbers.length-1) answer += index[i];
            }
        }
        return answer;
    }
}