import java.util.*;

class Solution {
    public int solution(int n) {
        int[] nums = new int[n];
        for (int i = 0;i < n;i++){
            nums[i] = i+1;
        }
        
        return Arrays.stream(nums).filter(i->n%i == 0).sum();
    }
}