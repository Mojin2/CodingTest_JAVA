import java.util.*;

class Solution {
    public int solution(String s) {

		ArrayDeque<String> word = new ArrayDeque<>();
		int T = s.length();
		String[] wordToArray = s.split("");

		int answer = 0;

		// Deque에 넣어 한바퀴 돌때마다 단어를 회전시킬 수 있도록 함
		for (int i = 0; i < T; i++) {
			word.add(wordToArray[i]);
		}

		// 새로운 문자열 마다 Stack 통해 완벽한 괄호인지 확인
		for (int i = 0; i < T; i++) {
			Stack<String> stack = new Stack<>();
			for (String str : word) {
				if (str.equals(")") && !stack.isEmpty() && stack.peek().equals("(")) {

					stack.pop();
				} else if (str.equals("}") && !stack.isEmpty() && stack.peek().equals("{")) {
					stack.pop();
				} else if (str.equals("]") && !stack.isEmpty() && stack.peek().equals("[")) {
					stack.pop();
				} else {
					stack.add(str);
				}
			}
			if (stack.isEmpty())
				answer++;

			word.add(word.pollFirst());
		}

		return answer;
	}
}