import java.util.*;

class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int tmp = x;
        while (x >0){
            sum += x % 10;
            x /= 10;
        }
        if (tmp%sum == 0) return true;
        else return false;
    }
}