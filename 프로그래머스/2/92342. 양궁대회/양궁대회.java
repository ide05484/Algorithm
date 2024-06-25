class Solution {
	static int max = -1000;;
	static int[] lion = new int[11]; // 라이언의 과녁배열
	static int[] answer = { -1 }; // 정답배열
    
    public int[] solution(int n, int[] info) {
      comb(0, n, info);

		return answer;
	}

	private static void comb(int arrow, int n, int[] info) {
		if (arrow == n) {
			
			int apeach_point = 0;
			int lion_point = 0;
			
			for (int i = 0; i <= 10; i++) {
				if (info[i] != 0 || lion[i] != 0) {
					if (info[i] < lion[i])
						lion_point += 10 - i;
					else
						apeach_point += 10 - i;
				}
				
			}
			
			if (lion_point > apeach_point) {
				if (lion_point - apeach_point >= max) {
					answer = lion.clone();
					max = lion_point - apeach_point;
				}
			}
			
			return;
		}
		for (int j = 0; j <= 10 && lion[j] <= info[j]; j++) {
			lion[j]++;
			comb(arrow + 1, n, info);
			lion[j]--;
		}
	}
}
