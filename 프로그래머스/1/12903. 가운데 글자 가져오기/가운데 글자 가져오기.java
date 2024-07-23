import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split("");
        int len = arr.length;
        if (len % 2 != 0){
            return arr[(int)len/2];
        } return arr[(int)(len/2)-1] + arr[(int)len/2];
    }
}