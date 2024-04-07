import java.util.Scanner;

public class Solution {

	static int[] count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 주어지는 테스트케이스

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 세기로한 양 번호 (N번, 2N번...)
			count = new int[10]; // 0부터 9까지를 세어보자
			int multi = 0; // 곱해지는 배수

			while (true) {
				if (check()) { // 0부터 9까지 다찼는지 확인해줘
					break;
				}
				multi++; // 하나씩 곱하는것을 늘려가보자고
				counting(N * multi); // N번째 양에서 쓰인 숫자를 체크하자!
			}

			System.out.println("#" + tc + " " + N * multi); // 몇번째에 멈췄니
		} // 테케마감
	}

	private static void counting(int num) {
		String sheep = String.valueOf(num); // 문자열로 변환해주고

		for (int i = 0; i < sheep.length(); i++) {
			int here = sheep.charAt(i) - '0'; // 해당자리 숫자로 바꿔주고

			count[here]++; // 하나씩 추가
		}
	}

	private static boolean check() {

		for (int i = 0; i < 10; i++) {
			if (count[i] == 0) {
				// 하나라도 0이 있다면?
				return false;
			}
		}
		// 아니라면?
		return true;
	}
}