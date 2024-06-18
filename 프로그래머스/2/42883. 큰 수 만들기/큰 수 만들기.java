class Solution {
    public String solution(String number, int k) {
		int len = number.length() - k; // 최종구해야하는 정답 길이

		int[] max = new int[len]; // 최대정답

		int maxIdx = 0; // 비어잇는 부분의 처음 인덱스

		for (int n = 0; n < number.length(); n++) {
			// number를 돌면서 하나씩 빼줌
			int curr = number.charAt(n) - '0'; // 현재 숫자

			// 현재 숫자가 result 배열의 마지막 숫자보다 크면 거기 말고 계속 앞으로 가야함
			while (k > 0 && maxIdx > 0 && max[maxIdx - 1] < curr) {
				maxIdx--;
				k--;
			}

			// 현재 숫자를 result 배열에 넣음
			if (maxIdx < max.length) {
				max[maxIdx] = curr;
				maxIdx++;
			} else {
				k--; //위의 while에서 k가 바뀌지 않은 건 지금들어올 숫자는 어디에도 들어갈 수 없다는 뜻임방구
			}

//			System.out.println(Arrays.toString(max));
//			System.out.println("-----------");
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int m = 0; m < len; m++) {
			sb.append(max[m]);
		}
		
		String answer = sb.toString();

		return answer;
	}
}