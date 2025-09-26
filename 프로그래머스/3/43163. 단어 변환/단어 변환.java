import java.util.*;
class Solution {
    
    static int answer;
    
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        
        // words안에 target이 없을 경우 바로 return
        boolean check = false;
        for (String word : words){
            if (word.equals(target)){
                check=true;
                break;
            }
        }
        if (!check) return 0;
        
        // target이 있는 경우
        BFS(begin,0,target,words);
        
        
        return answer;
    }
    
    static void BFS(String cur, int count,String target,String[] words){
        ArrayDeque<String[]> queue = new ArrayDeque<>();
        queue.add(new String[]{cur, String.valueOf(count)});
        
        while (!queue.isEmpty()){
            String[] tmp = queue.poll();
            String c = tmp[0];
            int cnt = Integer.parseInt(tmp[1]);
            
            if (c.equals(target)){
                answer = cnt;
                break;
            }
            
            if (cnt >= words.length) break;
            
            for (String next : words){
                if (c.equals(next)) continue;
                
                int diff = 0;
                for (int i = 0 ;i <c.length();i++){
                    if (c.charAt(i) != next.charAt(i)){
                        diff++;
                    }
                }
                
                if (diff != 1) continue;
                
                queue.add(new String[]{next,String.valueOf(cnt+1)});
            }
        }
    }
}