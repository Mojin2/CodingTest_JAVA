import java.util.*;

class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int N = phone_number.length()-4;
        String[] str = phone_number.split("");
        
        for (int i = 0; i < phone_number.length(); i++){
            if ( i < N){
                answer += "*";
            } else answer += str[i];
        }
        return answer;
    }
}