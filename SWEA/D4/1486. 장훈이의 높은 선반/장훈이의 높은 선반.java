import java.util.Scanner;

public class Solution {

	static int[] tall;
	static int N, B;
	static int min; // 최소차이
	static boolean[] sel;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테케 갯수

		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt(); // 직원의 수
			B = sc.nextInt(); // 선반의 높이

			tall = new int[N]; // 키를 저장할 배열

			for (int i = 0; i < N; i++) {
				tall[i] = sc.nextInt(); // 키를 저장
			} // 입력끝

			min = Integer.MAX_VALUE;
			// 부분집합구하기
			sel = new boolean[N]; // 선택했는지 체크할 배열
			comb(0);

			System.out.println("#" + tc + " " + min);

		} // 테케끝
	}// main끝

	private static void comb(int idx) {

		if (idx >= N) { // 끝까지 다 탐색했으면 리턴리턴
			int sum = 0;
			for (int n = 0; n < N; n++) {
				if (sel[n]) {
					sum += tall[n];
				}
			}
			
			if (sum < B) {
				return;
			}
			// 그렇지 않으면
			min = Math.min(min, Math.abs(sum - B)); // 둘의 차이가 젤 적은걸로
			return;
		}

		sel[idx] = true; // 선택해
		comb(idx + 1);

		sel[idx] = false; // 미선택
		comb(idx + 1);

	}
}
