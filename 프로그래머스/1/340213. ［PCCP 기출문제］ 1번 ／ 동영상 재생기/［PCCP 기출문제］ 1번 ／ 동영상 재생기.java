class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
		String answer = "";
		String[] vlTmp = video_len.split(":");
		int vl = Integer.parseInt(vlTmp[0]) * 60 + Integer.parseInt(vlTmp[1]);

		String[] posTmp = pos.split(":");
		int start = Integer.parseInt(posTmp[0]) * 60 + Integer.parseInt(posTmp[1]);

		String[] opsTmp = op_start.split(":");
		int ops = Integer.parseInt(opsTmp[0]) * 60 + Integer.parseInt(opsTmp[1]);

		String[] opeTmp = op_end.split(":");
		int ope = Integer.parseInt(opeTmp[0]) * 60 + Integer.parseInt(opeTmp[1]);

		for (int i = 0; i < commands.length; i++) {
			if (commands[i].equals("next")) {
				if (ops <= start && start <= ope) {
					start = ope;
				}
				if (vl - start <= 10) {
					start = vl;
					if (ops <= start && start <= ope) {
						start = ope;
					}
				} else {
					start += 10;
					if (ops <= start && start <= ope) {
						start = ope;
					}
				}
			} else if (commands[i].equals("prev")) {
				if (ops <= start && start <= ope) {
					start = ope;
				}
				if (start <= 10) {
					start = 0;
					if (ops <= start && start <= ope) {
						start = ope;
					}
				} else {
					start -= 10;
					if (ops <= start && start <= ope) {
						start = ope;
					}
				}
			}
		}

		int hour = start / 60;
		int min = start % 60;

		if (hour <= 9) {
			answer += "0";
			answer += String.valueOf(hour);
		} else {
			answer += String.valueOf(hour);
		}

		answer += ":";

		if (min == 0) {
			answer += "00";
		} else if (min <= 9) {
			answer += "0";
			answer += String.valueOf(min);
		} else {
			answer += String.valueOf(min);
		}

		return answer;
	}
}