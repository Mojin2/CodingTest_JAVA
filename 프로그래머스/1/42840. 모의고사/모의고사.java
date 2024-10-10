import java.util.*;
class Solution {
	public int[] solution(int[] answers) {
		int[] answer = {};

		int[] player1 = { 1, 2, 3, 4, 5 };
		int[] player2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] player3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int player1Score = 0;
		int player2Score = 0;
		int player3Score = 0;

		int player1AnswerIndex = 0;
		int player2AnswerIndex = 0;
		int player3AnswerIndex = 0;

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < answers.length; i++) {

			if (answers[i] == player1[(player1AnswerIndex + i) % 5]) {
				player1Score++;
			}
			if (answers[i] == player2[(player2AnswerIndex + i) % 8]) {
				player2Score++;
			}
			if (answers[i] == player3[(player3AnswerIndex + i) % 10]) {
				player3Score++;
			}
		}

		max = Math.max(player1Score, player2Score);
		max = Math.max(player3Score, max);
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		if (player1Score == max) {
			ans.add(1);
		} 
		if (player2Score == max) {
			ans.add(2);
		}
		if (player3Score == max) {
			ans.add(3);
		}

		int[] a = new int[ans.size()];
		int aIndex = 0;
		for (int aa : ans) {
			a[aIndex++] = aa; 
		}
		

		return a;
	}
}