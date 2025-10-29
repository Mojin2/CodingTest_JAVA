import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        // lost : 분실
        // reserve : 여분
        boolean[] check = new boolean[n+2];
        boolean[] reserved = new boolean[n+2];
        Arrays.fill(check,true);
        for (int i : lost) check[i] = false;
        for (int i : reserve) reserved[i] = true;           
        for (int i =1; i <=n ;i++){
            if (!check[i]){
                int back = i-1;
                int front = i+1;
                if (reserved[i]){
                    answer++;
                    reserved[i] = false;
                    continue;
                } else if (reserved[back] && check[back]){
                    reserved[back] = false;
                    check[i] = true;
                    answer++;
                    continue;
                } else if (reserved[front] && check[front]){
                    reserved[front] = false;
                    check[i] = true;
                    answer++;
                    continue;
                }
            }
        }
        
        
        
        return answer;
    }
}