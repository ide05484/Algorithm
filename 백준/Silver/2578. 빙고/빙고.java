
import java.util.Scanner;

public class Main {

	static int[][] bingo;
	static int count;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		bingo = new int[5][5]; // 빙고판

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				bingo[r][c] = sc.nextInt();
			}
		}

		int answer = 0; // 답
		int bingocount; // 되는 빙고

		for (int i = 0; i < 25; i++) {
			int num = sc.nextInt(); // 25번 숫자를 받을건데

			bingocount = 0;

			// 불러주는 숫자 입력받기
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (bingo[r][c] == num) {
						bingo[r][c] = 0; // 같은게 있으면 0으로 바꿔주세용
					}
				}
			} // 돌면서 하나씩 바꿔줌

			// 끝나기 전에 검사
			bingocount = bingoR() + bingoC() + bingoX() + bingoY();

			if (bingocount >= 3) { // 빙고가 되면
				answer = i + 1; // 횟수는 인덱스 +1
				break;
			}
		}

		System.out.println(answer);

	}

	// 세로빙고
	static int bingoR() {
		count = 0;
		// 열우선 순회를 돌면서
		to: for (int c = 0; c < 5; c++) {
			for (int r = 0; r < 5; r++) {
				// 0으로 바꿔줄거니까 0이 아닌게 있으면 빙고가 아님
				if (bingo[r][c] != 0) {
					continue to; // r이 있는 for문만 나감
				}
			}
			count++;
		}
		// 아예 나와버리면... 아무것도 없는거임
		return count;
	}

	// 가로빙고
	static int bingoC() {
		count = 0;
		// 행우선 순회를 돌면서
		to: for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				// 0으로 바꿔줄거니까 0이 아닌게 있으면 빙고가 아님
				if (bingo[r][c] != 0) {
					continue to;
				}
			}
			// 여기로 나오면 하나 잇는 거임!
			count++;
		}
		// 아예 나와버리면... 아무것도 없는거임
		return count;
	}

	// 대각선올라가는
	static int bingoX() {
		count = 0;
		// 행우선 순회를 돌면서
		for (int r = 0; r < 5; r++) {
			// 0으로 바꿔줄거니까 0이 아닌게 있으면 빙고가 아님
			if (bingo[r][4 - r] != 0) {
				return 0;
			}
		}
		// 여기오면 잇는거임!
		return 1;
	}

	// 대각선내려가는
	static int bingoY() {
		count = 0;
		// 행우선 순회를 돌면서
		for (int r = 0; r < 5; r++) {
			// 0으로 바꿔줄거니까 0이 아닌게 있으면 빙고가 아님
			if (bingo[r][r] != 0) {
				return 0;
			}
			// 여기로 나오면 하나 잇는 거임!
		}
		// 여기오면 잇는거임!
		return 1;
	}
}
