import java.util.*;

class Solution {
    public int solution(int n) {
        String str = Integer.toString(n,3);
        StringBuffer sb = new StringBuffer(str);
        String reversedStr = sb.reverse().toString();
        return Integer.parseInt(reversedStr,3);
    }
}