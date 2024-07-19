class Solution {
    public int[] solution(long n) {
        int[] arr = new int[String.valueOf(n).length()];
        int idx = 0;
        while (n>0){
            arr[idx] = (int)(n%10);
            n /= 10;
            idx++;
        }
        return arr;
    }
}