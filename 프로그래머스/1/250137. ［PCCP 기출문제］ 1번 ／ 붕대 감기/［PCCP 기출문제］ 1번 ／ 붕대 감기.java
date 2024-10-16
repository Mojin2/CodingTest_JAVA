class Solution {
   public int solution(int[] bandage, int health, int[][] attacks) {
		int maxHealth = health;

		int answer = 0;

		int index = 0;

		int time = 0;
		int healDuration = 0;

		while (true) {

			// 몬스터의 공격시간에 공격받는 경우
			if (attacks[index][0] == time) {
				health -= attacks[index][1];
				if (health <= 0) {
					return -1;
				}
//				System.out.println("time: " + time);
//				System.out.println("health: " + health);
				time++;
				index++;
				if (index == attacks.length) {
					return health;
				}
				healDuration = 0;

				continue;
			}

			// 공격이 없이 힐이 지속되는 경우
			health += bandage[1];

			healDuration++;
			if (healDuration == bandage[0]) {
				health += bandage[2];
				healDuration = 0;
			}

			if (health >= maxHealth) {
				health = maxHealth;
			}

//			System.out.println("time: " + time);
//			System.out.println("health: " + health);
			time++;
		}
	}
}