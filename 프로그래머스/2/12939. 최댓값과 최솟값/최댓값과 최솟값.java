import java.util.*;

class Solution {
    public String solution(String s) {
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        String[] list = s.split(" ");
        int[] listToInt = new int[list.length];
        for (int i =0 ;i <list.length;i++){
            int num = Integer.parseInt(list[i]);
            if (num > max) max = num;
            if (num < min) min = num;
        }
        
        String answer = min + " "+max;
        return answer;
        
        
    }
}