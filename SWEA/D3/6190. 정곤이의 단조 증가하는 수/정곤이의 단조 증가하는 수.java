import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스 수

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 주어지는 숫자개수
			int[] arr = new int[N]; // 숫자 넣는 배열

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt(); // 배열 받아줍니당
			}

			int max = -1; // 최대값 //max값을 갱신하지 못하면 -1

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					int num = arr[i] * arr[j];// 두수를 곱한 수
					if (check(num)) { // 단조 체크
						max = Math.max(max, num);
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		} // 테케끝
	}// main끝

	private static boolean check(int num) {

		String str = String.valueOf(num);

		int count = 1;

		for (int i = 0; i < str.length() - 1; i++) {
			if ((str.charAt(i) - '0') <= (str.charAt(i + 1) - '0')) {
				count++;
			}
		}

		if (count == str.length())
			return true; // 단조 함수군

		return false;
	}
}