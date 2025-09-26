class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        backtrack(numbers,0,0,target);
        
        return answer;
    }
    
    static void backtrack(int[] numbers, int depth, int sum, int target){
        if (numbers.length == depth){
            if (sum == target){
                answer++;
            }
            return;
        }
        
        backtrack(numbers,depth+1,sum+numbers[depth],target);
        backtrack(numbers,depth+1,sum-numbers[depth],target);
    }
}