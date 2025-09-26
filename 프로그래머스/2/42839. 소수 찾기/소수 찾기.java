import java.util.*;

class Solution {
    
    static HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        String[] numbersArray = numbers.split("");
        int[] numbersInt = new int[numbersArray.length];
        for (int i =0 ;i <numbersInt.length;i++){
            numbersInt[i] = Integer.parseInt(numbersArray[i]);
        }
        
        for (int i = 1 ;i <=numbersInt.length;i++){
            permutation(numbersInt,new boolean[numbersInt.length],new int[i],0,i);
        }
        
        
        return set.size();
    }
    
    static void permutation(int[] numbers,boolean[] visited,int[] output,int depth, int r){
        if (depth == r){
            
            StringBuilder sb = new StringBuilder();

            for (int num : output) {
                sb.append(num);
            }
            int result = Integer.parseInt(sb.toString());
            // System.out.println(result);
            if (isPrime(result)){
                set.add(result);
            }
            return;
        }
        
        for (int i=0 ;i <numbers.length;i++){
            if (!visited[i]){
                visited[i] = true;
                output[depth] = numbers[i];
                permutation(numbers,visited,output,depth+1,r);
                visited[i] = false;
            }
        }
    }
    
    static boolean isPrime(int num){
        if (num == 1 || num == 0) return false;
        
        for (int i = 2 ;i <num;i++){
            if (num % i == 0){
                return false;
            }
        }
        
        
        return true;
    }
}