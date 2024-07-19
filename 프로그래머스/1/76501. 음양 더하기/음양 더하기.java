import java.util.stream.IntStream;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        return IntStream.range(0,signs.length).map(i->
                                           {int si = signs[i]? 1:-1;
                                           return absolutes[i]*si;}).sum();
        // int answer = 0;
        // for (int i = 0 ;i < absolutes.length; i++){
        //     if (signs[i] == false) answer -= absolutes[i];
        //     else answer += absolutes[i];
        // }
        // return answer;
    }
}