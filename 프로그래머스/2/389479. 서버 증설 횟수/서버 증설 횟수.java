import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] serverCount = new int[24];
        for (int i =0 ;i <players.length;i++){
            int serverRequire = players[i]/m;
            if (serverRequire == 0) continue;
            
            int diff = serverRequire - serverCount[i];
            if (diff < 0) diff =0;
            if (diff > 0){
                // System.out.println(i+" 시간에서 "+ diff+"개의 서버 증설 필요");
                answer += diff;
            }
            
            for (int j = i ; j< k+i; j++){
                
                if (j>= players.length) break;
          
                // if (i == 18){
                //     System.out.println(serverCount[j]+ " "+diff);
                // }
                serverCount[j] += diff;
            }
            
            // if (i == 17){
            //     System.out.println(Arrays.toString(serverCount));
            // }
            
        }
        
        return answer;
    }
}