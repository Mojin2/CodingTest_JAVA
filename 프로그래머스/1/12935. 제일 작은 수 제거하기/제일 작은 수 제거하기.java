import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        int min = Integer.MAX_VALUE;
        for (int i = 0 ;i < arr.length;i++){
            if (arr[i] < min) min = arr[i];
        }
        
        int removeIdx = 0;
        for (int i = 0 ;i < arr.length;i++){
            if (arr[i] == min){
                removeIdx = i;
                break;
            }
        }
        
        int[] ans = {-1};
        int[] answer = new int[arr.length-1];
        if (answer.length == 0) return ans;
        
        System.arraycopy(arr,0,answer,0,removeIdx);
        // (arr,0,answer,0,3)
        System.arraycopy(arr,removeIdx+1,answer,removeIdx,arr.length-1-removeIdx);
        // (arr,4,answer,3,0)
        return answer;
    }
}