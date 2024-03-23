import java.util.Scanner;

public class Main {

	public static char[][] chess;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 높이(세로)
		int M = sc.nextInt(); // 가로

		chess = new char[N][M]; // 주어지는 체스판

		for (int r = 0; r < N; r++) {
			String color = sc.next(); // 색깔받기
			for (int c = 0; c < M; c++) {
				chess[r][c] = color.charAt(c);
			}
		}

		int min = Integer.MAX_VALUE; // 최소값 구하기

		for (int r = 0; r < N - 7; r++) {
			for (int c = 0; c < M - 7; c++) {
				// 시작좌표부터 8*8
				min = Math.min(findColoring(r, c), min);
			}
		}

		System.out.println(min);

	}

	// B로 시작할때의 색칠값
	public static int findColoring(int r, int c) {

		int count1 = 0; // 얼마나 바꾸나요? 시작이 B
		int count2 = 0; // 시작이 W

		// r+c가 짝수 인경우, 홀수인 경우로 나뉨!
		for (int nr = r; nr < r+8; nr++) {
			for (int nc = c; nc < c+8; nc++) {
				if ((nr + nc) % 2 == 0) {
					if (chess[nr][nc] != 'B') {
						count1++;
					}
					if (chess[nr][nc] != 'W') {
						count2++;
					}
				} else { // 홀수이면 반대로적용
					if (chess[nr][nc] != 'W') {
						count1++;
					}
					if (chess[nr][nc] != 'B') {
						count2++;
					}
				}
			}
		}

		return Math.min(count1, count2);
	}
}