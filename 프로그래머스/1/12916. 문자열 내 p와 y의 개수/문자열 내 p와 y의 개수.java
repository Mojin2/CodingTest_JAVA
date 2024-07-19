class Solution {
    boolean solution(String s) {
        return s.toLowerCase().replace("p","").length() == s.toLowerCase().replace("y","").length();
    }
}