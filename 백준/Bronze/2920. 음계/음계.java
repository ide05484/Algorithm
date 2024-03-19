import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] input = new int[8]; // 입력받을 배열

		for (int i = 0; i < 8; i++) {
			input[i] = sc.nextInt(); // 입력받습니다
		}

		// 비교할 배열 두개
		int[] ascending = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] descending = { 8, 7, 6, 5, 4, 3, 2, 1 };

		String answer = ""; // 정답 초기화

		int countA = 0; // 올라가는 배열 카운트
		int countB = 0; // 내려가는 배열 카운트

		for (int i = 0; i < 8; i++) {
			if (input[i] == descending[i]) {
				countB++;
			} else if (input[i] == ascending[i]) {
				countA++;
			}
		}

		if (countA == 8) {
			answer = "ascending";
		} else if (countB == 8) {
			answer = "descending";
		} else {
			answer = "mixed";
		}

		System.out.println(answer);
	}
}